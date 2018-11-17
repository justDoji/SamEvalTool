package be.doji.tools.web.panels;

import be.doji.tools.model.CompetenceLevel;
import be.doji.tools.model.Trait;
import java.util.Comparator;
import java.util.List;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.Model;

public class TraitPanel extends Panel {

  private Model<Trait> trait;

  public TraitPanel(String markupId, Model<Trait> model) {
    super(markupId);
    this.trait = model;

    add(new Label("traitName", trait.getObject().getName()));
    add(new Label("traitDescription", trait.getObject().getDescription()));

    RepeatingView repeatingView = new RepeatingView("traitRepeater");
    List<CompetenceLevel> competenceLevels = trait.getObject().getCompetenceLevels();
    competenceLevels.sort(Comparator.comparing(CompetenceLevel::getAppreciation));
    for (CompetenceLevel trait : competenceLevels) {
      WebMarkupContainer container = new WebMarkupContainer(repeatingView.newChildId());
      repeatingView.add(container);
      container
          .add(new Label("traitItem",
              trait.getAppreciation().toString() + ": " + trait.getDescription()));
    }
    add(repeatingView);


  }
}
