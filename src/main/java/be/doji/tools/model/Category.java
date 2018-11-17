package be.doji.tools.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Category implements Serializable {

  private String title;
  private String description;
  private List<Trait> traits = new ArrayList<>();

  public Category(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Trait> getTraits() {
    return traits;
  }

  public void setTraits(List<Trait> traits) {
    this.traits = traits;
  }

  public void addTrait(Trait trait) {
    if (trait == null) {
      throw new IllegalArgumentException(
          "The provided trait was NULL");
    }

    if (traits.contains(trait)) {
      throw new IllegalArgumentException(
          "This trait already contains this trait");
    }

    traits.add(trait);
  }
}
