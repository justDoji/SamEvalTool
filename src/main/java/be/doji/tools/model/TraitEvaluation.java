package be.doji.tools.model;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

public class TraitEvaluation {

  private Trait trait;
  private Appreciation level;
  private LocalDateTime evaluationDate;

  public TraitEvaluation(Trait trait) {
    this.trait = trait;

  }

  public Trait getTrait() {
    return trait;
  }

  public void setTrait(Trait trait) {
    this.trait = trait;
  }

  public Appreciation getLevel() {
    return level;
  }

  public void setLevel(Appreciation level) {
    this.level = level;
  }

  public LocalDateTime getEvaluationDate() {
    return evaluationDate;
  }

  public void setEvaluationDate(LocalDateTime evaluationDate) {
    this.evaluationDate = evaluationDate;
  }

  public double getWeighedScore() {
    List<CompetenceLevel> competenceLevels = trait.getCompetenceLevels();
    competenceLevels.sort(new Comparator<CompetenceLevel>() {
      @Override
      public int compare(CompetenceLevel o1, CompetenceLevel o2) {
        return Integer.compare(o1.getAppreciation().getScore(), o2.getAppreciation().getScore());
      }
    });
    int maxScore = competenceLevels.get(competenceLevels.size() - 1).getAppreciation().getScore();
    return this.getLevel().getScore() / maxScore;
  }
  
}
