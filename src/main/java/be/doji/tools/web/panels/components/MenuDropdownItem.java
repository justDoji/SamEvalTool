package be.doji.tools.web.panels.components;

import java.util.Collection;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;

public class MenuDropdownItem extends Panel {

  public MenuDropdownItem(String markupId, Collection<BookmarkablePageLink<?>> pageLinks,
      boolean shouldBeActive, String menuLabel) {
    super(markupId);
    WebMarkupContainer itemContainer = newItemContainer(shouldBeActive, menuLabel);
    itemContainer.add(newDropdownView(pageLinks));
    add(itemContainer);
  }

  private WebMarkupContainer newItemContainer(boolean shouldBeActive, String menuLabel) {
    WebMarkupContainer itemContainer = new WebMarkupContainer("itemContainer");

    if (shouldBeActive) {
      itemContainer.add(new AttributeAppender("class", "active"));
    }
    itemContainer.add(new Label("label", menuLabel));
    return itemContainer;
  }

  private RepeatingView newDropdownView(Collection<BookmarkablePageLink<?>> pageLinks) {
    RepeatingView repeatView = new RepeatingView("itemLinks");
    for (BookmarkablePageLink<?> pageLink : pageLinks) {
      MenuItem dropdownItem = new MenuItem(repeatView.newChildId(), pageLink, false);
      repeatView.add(dropdownItem);
    }
    return repeatView;
  }

}
