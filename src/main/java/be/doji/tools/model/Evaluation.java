package be.doji.tools.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Evaluation implements Serializable {

  private List<TraitEvaluation> evaluations = new ArrayList<>();
  private String subjectName;
  private EvaluationTemplate template;

  public Evaluation(String subjectName, EvaluationTemplate template) {
    this.subjectName = subjectName;
    this.template = template;
    for (Trait trait : template.getTraitsToEvaluate()) {
      evaluations.add(new TraitEvaluation(trait));
    }
  }

  public List<TraitEvaluation> getEvaluations() {
    return evaluations;
  }

  public void setEvaluations(List<TraitEvaluation> evaluations) {
    this.evaluations = evaluations;
  }

  public String getSubjectName() {
    return subjectName;
  }

  public void setSubjectName(String subjectName) {
    this.subjectName = subjectName;
  }

  public EvaluationTemplate getTemplate() {
    return template;
  }

  public double getScore() {
    if (evaluations.isEmpty()) {
      return 0;
    }

    double score = 0;
    for (TraitEvaluation eval : evaluations) {
      score += eval.getWeighedScore();
    }
    return score / evaluations.size();
  }
}
