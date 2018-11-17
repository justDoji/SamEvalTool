package be.doji.tools.web.panels;

import be.doji.tools.web.WebConstants;
import be.doji.tools.web.pages.BasePage;
import be.doji.tools.web.panels.components.MenuDropdownItem;
import be.doji.tools.web.panels.components.MenuItem;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import java.io.Serializable;
import java.util.Collection;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.Model;

public class NavBarPanel extends Panel {

  private NavBarPanel(final Builder builder) {
    super(builder.id);
    BookmarkablePageLink<Void> homeLink = new BookmarkablePageLink<Void>(
        WebConstants.PAGE_NAME_HOME,
        builder.homePage);
    homeLink.add(new Label("label",
        "" + builder.applicationName));

    add(homeLink);

    RepeatingView repeatingView = new RepeatingView("menuItems");

    for (String item : builder.links.keys()) {
      boolean shouldBeActive = item.equals(builder.activeItem);

      Collection<BookmarkablePageLink<?>> linksInMenu = builder.links.get(item);
      if (linksInMenu.size() == 1) {
        BookmarkablePageLink<?> pageLink = Iterables.get(linksInMenu, 0);
        repeatingView.add(new MenuItem(repeatingView.newChildId(), pageLink, shouldBeActive));
      } else {
        repeatingView.add(
            new MenuDropdownItem(repeatingView.newChildId(), linksInMenu, shouldBeActive, item));
      }
    }
    add(repeatingView);
  }

  public static class Builder implements Serializable {

    private String id;
    private Class<? extends BasePage> homePage;
    private String applicationName;
    private String activeItem;

    private Multimap<String, BookmarkablePageLink<?>> links = LinkedHashMultimap.create();


    public Builder(String markupId, Class<? extends BasePage> homePage, String applicationName,
        String activeItem) {
      this.id = markupId;
      this.homePage = homePage;
      this.applicationName(applicationName);
      this.activeItem = activeItem;
    }

    public Builder(String markupId, Class<? extends BasePage> homePage) {
      this.id = markupId;
      this.homePage = homePage;
      this.applicationName(WebConstants.APPLICATION_DISPLAY_NAME);
    }

    public void applicationName(String name) {
      this.applicationName = name;
    }

    public Builder addMenuItem(String itemName, Class<? extends BasePage> pageToLink) {
      Preconditions
          .checkState(links.containsKey(itemName) == false, "Builder already contains " + itemName +
              ". Please use withMenuItemInDropdown if you need many links in one menu item");
      BookmarkablePageLink<BasePage> link = new BookmarkablePageLink<BasePage>("link", pageToLink);
      link.setBody(new Model<>(itemName));
      links.put(itemName, link);
      return this;
    }

    public Builder addMenuItemAsDropdown(String itemName, Class<? extends BasePage> pageToLink,
        String label) {
      BookmarkablePageLink<BasePage> link = new BookmarkablePageLink<BasePage>("link", pageToLink);
      link.setBody(new Model<>(label));
      links.put(itemName, link);
      return this;
    }

    public NavBarPanel build() {
      return new NavBarPanel(this);
    }

  }

}
