package be.doji.tools.web.panels;

import be.doji.tools.model.Evaluation;
import be.doji.tools.model.TraitEvaluation;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
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
            .getSubjectName());

    RepeatingView repeatingView = new RepeatingView("evalRepeater");
    for (TraitEvaluation trait : evaluation.getObject().getEvaluations()) {
      WebMarkupContainer container = new WebMarkupContainer(repeatingView.newChildId());
      repeatingView.add(container);
      container.add(new TraitEvaluationPanel("listItem", Model.of(trait)));
    }
    add(repeatingView);

    add(new Label("score", evaluation.getObject().getScore()));
  }
}
