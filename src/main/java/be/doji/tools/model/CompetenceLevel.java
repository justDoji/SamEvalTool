package be.doji.tools.model;

import java.io.Serializable;

public class CompetenceLevel implements Serializable {

  private String name;
  private Appreciation appreciation;
  private String description;
  private Trait trait;


  public CompetenceLevel(String name, Appreciation appreciation) {
    this.name = name;
    this.appreciation = appreciation;
  }

  public CompetenceLevel(String name, Appreciation appreciation, String description) {
    this(name, appreciation);
    setDescription(description);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Appreciation getAppreciation() {
    return appreciation;
  }

  public void setAppreciation(Appreciation appreciation) {
    this.appreciation = appreciation;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
