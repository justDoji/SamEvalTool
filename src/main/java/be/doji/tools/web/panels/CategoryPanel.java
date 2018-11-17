package be.doji.tools.web.panels;

import be.doji.tools.model.Category;
import be.doji.tools.model.Trait;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.Model;

public class CategoryPanel extends Panel {

  private Model<Category> category;

  public CategoryPanel(String markupId) {
    super(markupId);
  }

  public CategoryPanel(String markupId, Category category) {
    super(markupId);
    this.category = Model.of(category);
    add(new Label("title", category.getTitle()));
    add(new Label("description", category.getDescription()));

    RepeatingView repeatingView = new RepeatingView("repeater");
    for (Trait trait : category.getTraits()) {
      WebMarkupContainer container = new WebMarkupContainer(repeatingView.newChildId());
      repeatingView.add(container);
      container.add(new TraitPanel("listItem", Model.of(trait)));
    }
    add(repeatingView);
  }

}
