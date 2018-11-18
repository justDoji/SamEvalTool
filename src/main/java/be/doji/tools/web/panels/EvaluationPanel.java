package be.doji.tools.web.panels;

import be.doji.tools.model.CompetenceLevel;
import be.doji.tools.model.Evaluation;
import be.doji.tools.model.TraitEvaluation;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.Model;

public class EvaluationPanel extends Panel {

  private Model<Evaluation> evaluation = null;

  public EvaluationPanel(String id) {
    super(id);
  }

  public EvaluationPanel(String id, Model<Evaluation> evaluation) {
    super(id);
    this.evaluation = evaluation;
    add(new Label("title",
        evaluation.getObject().getTemplate().getTitle() + " for " + evaluation.getObject()
            .getSubjectName()));

    Form<Void> form = new Form<>("form");
    RepeatingView repeatingView = new RepeatingView("evalRepeater");
    for (TraitEvaluation traitEvaluation : evaluation.getObject().getEvaluations()) {
      WebMarkupContainer container = new WebMarkupContainer(repeatingView.newChildId());
      repeatingView.add(container);

      container.add(new Label("traitName", traitEvaluation.getTrait().getName()));
      container.add(new Label("traitDescription", traitEvaluation.getTrait().getDescription()));
      List<String> selectionOptions = new ArrayList<>();
      List<CompetenceLevel> competenceLevels = traitEvaluation.getTrait().getCompetenceLevels();
      competenceLevels.sort(Comparator.comparingInt(o -> o.getAppreciation().getScore()));
      for (CompetenceLevel level : competenceLevels) {
        selectionOptions.add(
            level.getAppreciation().toString() + "(" + level.getAppreciation().getScore() + ") "
                + " : " + level.getDescription());
      }
      container.add(new RadioChoice("radioGroup", Model.of(""), selectionOptions));
    }

    form.add(repeatingView);
    add(form);

    add(new Label("score", evaluation.getObject().getScore()));
  }
}
