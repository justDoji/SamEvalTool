package be.doji.tools.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class depicting personality trait
 */
public class Trait implements Serializable {

  private String name;
  private String description;
  private Map<Appreciation, CompetenceLevel> levels = new HashMap<>();

  public Trait(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void addCompetenceLevel(String competenceName, Appreciation level, String description) {
    CompetenceLevel competenceLevel = new CompetenceLevel(competenceName, level, description);
    this.addCompetenceLevel(competenceLevel);
  }

  public void addCompetenceLevel(CompetenceLevel element) {
    if (element == null || element.getAppreciation() == null) {
      throw new IllegalArgumentException(
          "The provided competence, or it's attributed level were NULL");
    }

    if (levels.containsKey(element.getAppreciation())) {
      throw new IllegalArgumentException(
          "This trait already contains a competence element with the same attributed competence level");
    }

    levels.put(element.getAppreciation(), element);
  }

  public List<CompetenceLevel> getCompetenceLevels() {
    return new ArrayList<>(levels.values());
  }
}
