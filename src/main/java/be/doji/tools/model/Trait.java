package be.doji.tools.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Class depicting personality trait
 */
public class Trait implements Serializable {

  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "NAME", nullable = false)
  private String name;

  @Column(name = "DESCRIPTION")
  private String description;

  @OneToMany(mappedBy = "trait", targetEntity = CompetenceLevel.class)
  private List<CompetenceLevel> levels = new ArrayList<>();

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
    
    if (levels.stream().anyMatch(level -> level.getAppreciation() == element.getAppreciation())) {
      throw new IllegalArgumentException(
          "This trait already contains a competence element with the same attributed competence level");
    }

    levels.add(element);
  }


  public List<CompetenceLevel> getCompetenceLevels() {
    return new ArrayList<>(levels);
  }
}
