package be.doji.tools.model;

public enum Appreciation {

  IMPROVEMENT_NEEDED(1),
  MODERATE(2),
  GOOD(3),
  VERY_GOOD(4);

  private int score;

  Appreciation(int score) {
    this.score = score;
  }

  public int getScore() {
    return score;
  }
}
