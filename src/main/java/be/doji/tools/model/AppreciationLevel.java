package be.doji.tools.model;

/**
 * Since this is a prototype, we're not bothering with custom appreciation levels for now.
 */
public enum AppreciationLevel {

  IMPROVEMENT_NEEDED(1, "Improvement needed"),
  MODERATE(2, "Moderate"),
  GOOD(3, "Good"),
  VERY_GOOD(4, "Very good");

  private final String displayValue;
  private final int score;

  AppreciationLevel(int score, String displayValue) {
    this.score = score;
    this.displayValue = displayValue;
  }

  public int getScore() {
    return score;
  }

  public String getDisplayValue() {
    return displayValue;
  }
}
