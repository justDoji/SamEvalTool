package be.doji.tools.model;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TRAIT_EVALUATION")
public class TraitEvaluation implements Serializable {

  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "TRAIT_ID")
  private Trait trait;

  @Enumerated(EnumType.STRING)
  private AppreciationLevel level;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "EVALUATION_ID")
  private Evaluation parentEvaluation;

  public TraitEvaluation(Trait trait) {
    this.trait = trait;

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Trait getTrait() {
    return trait;
  }

  public void setTrait(Trait trait) {
    this.trait = trait;
  }

  public AppreciationLevel getLevel() {
    return level;
  }

  public void setLevel(AppreciationLevel level) {
    this.level = level;
  }

  public Evaluation getParentEvaluation() {
    return parentEvaluation;
  }

  public void setParentEvaluation(Evaluation parentEvaluation) {
    this.parentEvaluation = parentEvaluation;
  }

  public double getWeighedScore() {
    if (this.getTrait() == null || this.getLevel() == null) {
      return 0;
    }

    List<CompetenceLevel> competenceLevels = trait.getCompetenceLevels();
    competenceLevels.sort(
        Comparator.comparingInt(o -> o.getAppreciationLevel().getScore()));
    int maxScore = competenceLevels.get(competenceLevels.size() - 1).getAppreciationLevel()
        .getScore();
    return this.getLevel().getScore() / maxScore;
  }

}
