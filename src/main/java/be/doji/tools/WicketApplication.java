package be.doji.tools;

import be.doji.tools.web.pages.HomePage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class WicketApplication extends WebApplication {

  /**
   * @see org.apache.wicket.Application#getHomePage()
   */
  @Override
  public Class<? extends WebPage> getHomePage() {
    return HomePage.class;
  }

  /**
   * @see org.apache.wicket.Application#init()
   */
  @Override
  public void init() {
    super.init();

    // add your configuration here
  }

  public static void main(String[] args) throws Exception {
    new SpringApplicationBuilder()
        .sources(WicketApplication.class)
        .run(args);
  }
}
