package be.doji.tools.web.pages;

import be.doji.tools.web.panels.FooterPanel;
import be.doji.tools.web.panels.HeaderPanel;
import be.doji.tools.web.panels.NavBarPanel;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public abstract class BasePage extends WebPage {

  public static final String CONTENT_ID = "contentComponent";
  private final HeaderPanel headerPanel;
  private final FooterPanel footerPanel;

  public BasePage() {
    add(headerPanel = new HeaderPanel(("header")));
    add(newNavBar());
    add(footerPanel = new FooterPanel("footer"));
    add(new Label(CONTENT_ID, "Hello world!"));
  }

  private NavBarPanel newNavBar() {
    // ADD PAGES TO MENU HERE
    return new NavBarPanel.Builder("navBar", HomePage.class, "SamEval", getActiveMenuItem())

        .build();
  }

  public HeaderPanel getHeaderPanel() {
    return headerPanel;
  }

  public FooterPanel getFooterPanel() {
    return footerPanel;
  }

  public abstract String getActiveMenuItem();
}
