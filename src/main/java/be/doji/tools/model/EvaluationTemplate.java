package be.doji.tools.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class EvaluationTemplate {

  List<Trait> traitsToEvaluate;
  String title;
  LocalDateTime creationDate;
  String description;

  public EvaluationTemplate(String title) {
    this.title = title;
    this.creationDate = LocalDateTime.now();
  }

  public EvaluationTemplate() {
    this.creationDate = LocalDateTime.now();
    this.title = "Untitled-" + creationDate.format(DateTimeFormatter.BASIC_ISO_DATE);
  }

  public List<Trait> getTraitsToEvaluate() {
    return traitsToEvaluate;
  }

  public void setTraitsToEvaluate(List<Trait> traitsToEvaluate) {
    this.traitsToEvaluate = traitsToEvaluate;
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


  public void addTraitsToEvaluate(List<Trait> traits) {
    if (traits == null || traits.isEmpty()) {
      throw new IllegalArgumentException("No traits found to add to the template.");
    }

    this.traitsToEvaluate.addAll(traits);
  }
}
