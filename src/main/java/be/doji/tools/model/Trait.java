package be.doji.tools.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Class depicting personality trait
 *
 * Annotations on fields in stead of access methods.
 * For more discussion on the topic,
 * read: https://stackoverflow.com/questions/594597/hibernate-annotations-which-is-better-field-or-property-access/2869468#2869468
 */
@Entity
@Table(name = "TRAIT")
public class Trait implements Serializable {

  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "NAME", nullable = false)
  private String name;

  @Column(name = "DESCRIPTION")
  private String description;

  @OneToMany(mappedBy = "trait", targetEntity = CompetenceLevel.class)
  private List<CompetenceLevel> competenceLevels = new ArrayList<>();

  public Trait(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
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

  public void addCompetenceLevel(String competenceName, AppreciationLevel level, String description) {
    CompetenceLevel competenceLevel = new CompetenceLevel(competenceName, level, description);
    this.addCompetenceLevel(competenceLevel);
  }

  public void addCompetenceLevel(CompetenceLevel element) {
    if (element == null || element.getAppreciationLevel() == null) {
      throw new IllegalArgumentException(
          "The provided competence, or it's attributed level were NULL");
    }

    if (competenceLevels.stream()
        .anyMatch(level -> level.getAppreciationLevel() == element.getAppreciationLevel())) {
      throw new IllegalArgumentException(
          "This trait already contains a competence element with the same attributed competence level");
    }

    competenceLevels.add(element);
  }

  public List<CompetenceLevel> getCompetenceLevels() {
    return new ArrayList<>(competenceLevels);
  }

  public void setCompetenceLevels(List<CompetenceLevel> competenceLevels) {
    this.competenceLevels = competenceLevels;
  }
}
