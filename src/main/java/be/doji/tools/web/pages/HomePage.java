package be.doji.tools.web.pages;

import be.doji.tools.model.Category;
import be.doji.tools.model.MockPopulator;
import be.doji.tools.web.WebConstants;
import be.doji.tools.web.panels.CategoryPanel;
import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import java.util.List;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;

@WicketHomePage
public class HomePage extends BasePage {

  private static final long serialVersionUID = 1L;

  public HomePage() {
    super();

    replace(new Label(CONTENT_ID, "TEST 123!"));
    List<Category> categories = MockPopulator.mockCategoryData();

    RepeatingView repeatingView = new RepeatingView("categoryRepeater");
    for (Category cat : categories) {
      WebMarkupContainer container = new WebMarkupContainer(repeatingView.newChildId());
      repeatingView.add(container);
      container
          .add(new CategoryPanel("category", cat));
    }
    add(repeatingView);


  }

  @Override
  public String getActiveMenuItem() {
    return WebConstants.PAGE_NAME_HOME;
  }
}
