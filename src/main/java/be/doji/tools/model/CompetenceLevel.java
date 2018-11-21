package be.doji.tools.model;

import java.io.Serializable;
import javax.persistence.Column;
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
@Table(name = "COMPETENCE_LEVEL")
public class CompetenceLevel implements Serializable {

  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "NAME", nullable = false)
  private String name;

  @Enumerated(EnumType.STRING)
  private AppreciationLevel appreciationLevel;

  @Column(name = "DESCRIPTION", nullable = false)
  private String description;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "TRAIT_ID")
  private Trait trait;


  public CompetenceLevel(String name, AppreciationLevel appreciationLevel) {
    this.name = name;
    this.appreciationLevel = appreciationLevel;
  }

  public CompetenceLevel(String name, AppreciationLevel appreciationLevel, String description) {
    this(name, appreciationLevel);
    setDescription(description);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AppreciationLevel getAppreciationLevel() {
    return appreciationLevel;
  }

  public void setAppreciationLevel(AppreciationLevel appreciationLevel) {
    this.appreciationLevel = appreciationLevel;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Trait getTrait() {
    return trait;
  }

  public void setTrait(Trait trait) {
    this.trait = trait;
  }
}
