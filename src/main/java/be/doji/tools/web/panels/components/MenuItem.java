package be.doji.tools.web.panels.components;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;

public class MenuItem extends Panel {

  public MenuItem(String markupId, BookmarkablePageLink<?> pageLink, boolean shouldBeActive) {
    super(markupId);
    add(pageLink);
    if (shouldBeActive) {
      add(new AttributeAppender("class", "active"));
    }
  }

  public MenuItem(String markupId, BookmarkablePageLink<?> pageLink) {
    super(markupId);
    add(pageLink);
  }

}
