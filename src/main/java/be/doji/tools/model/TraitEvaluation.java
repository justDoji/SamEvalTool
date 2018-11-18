package be.doji.tools.model;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

public class TraitEvaluation implements Serializable {

  private Trait trait;
  private Appreciation level;

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

  public double getWeighedScore() {
    if (this.getTrait() == null || this.getLevel() == null) {
      return 0;
    }

    List<CompetenceLevel> competenceLevels = trait.getCompetenceLevels();
    competenceLevels.sort(
        Comparator.comparingInt(o -> o.getAppreciation().getScore()));
    int maxScore = competenceLevels.get(competenceLevels.size() - 1).getAppreciation().getScore();
    return this.getLevel().getScore() / maxScore;
  }

}
