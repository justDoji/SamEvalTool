package be.doji.tools.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TEMPLATE")
public class EvaluationTemplate implements Serializable {

  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "TITLE")
  private String title;
  @Column(name = "DESCRIPTION")
  private String description;
  @Column(name = "CREATION")
  private LocalDateTime creationDate;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "TEMPLATE_X_TRAIT",
      joinColumns = @JoinColumn(name = "TEMPLATE_ID", referencedColumnName = "ID"),
      inverseJoinColumns = @JoinColumn(name = "TRAIT_ID", referencedColumnName = "ID"))
  private List<Trait> traitsToEvaluate = new ArrayList<>();

  public EvaluationTemplate() {
    this.creationDate = LocalDateTime.now();
    this.title = "Untitled-" + creationDate.format(DateTimeFormatter.BASIC_ISO_DATE);
  }

  public EvaluationTemplate(String title) {
    this.title = title;
    this.creationDate = LocalDateTime.now();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<Trait> getTraitsToEvaluate() {
    return traitsToEvaluate;
  }

  public void setTraitsToEvaluate(List<Trait> traitsToEvaluate) {
    this.traitsToEvaluate = traitsToEvaluate;
  }

  public void addTraitsToEvaluate(List<Trait> traits) {
    if (traits == null || traits.isEmpty()) {
      throw new IllegalArgumentException("No traits found to add to the template.");
    }

    this.traitsToEvaluate.addAll(traits);
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDateTime getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDateTime creationDate) {
    this.creationDate = creationDate;
  }


}
