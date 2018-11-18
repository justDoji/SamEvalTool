package be.doji.tools.web.pages;

import be.doji.tools.model.Evaluation;
import be.doji.tools.model.MockPopulator;
import be.doji.tools.web.WebConstants;
import be.doji.tools.web.panels.EvaluationPanel;
import org.apache.wicket.model.Model;

public class EvaluationPage extends BasePage {

  public EvaluationPage() {
    super();
    Evaluation evaluation = MockPopulator.mockEvaluation();
    add(new EvaluationPanel("evaluation", Model.of(evaluation)));

  }

  @Override
  public String getActiveMenuItem() {
    return WebConstants.PAGE_NAME_EVALUATION;
  }
}
