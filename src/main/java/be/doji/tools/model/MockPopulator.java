package be.doji.tools.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class MockPopulator {

  /**
   * Utility classes should not have a public or default constructor
   */
  private MockPopulator() {
  }

  public static List<Category> mockCategoryData() {

    List<Category> categories = new ArrayList<>();
    categories.add(mockZelfstandigheid());
    categories.add(mockInzet());

    return categories;
  }

  public static Evaluation mockEvaluation() {
    return new Evaluation("Jos De Houwer", mockEvaluationTemplate());
  }

  private static EvaluationTemplate mockEvaluationTemplate() {
    EvaluationTemplate template = new EvaluationTemplate();
    template.addTraitsToEvaluate(mockZelfstandigheid().getTraits());
    template.addTraitsToEvaluate(mockInzet().getTraits());
    return template;
  }


  private static Category mockZelfstandigheid() {
    Category zelfstandigheid = new Category("Zelfstandig Werken");
    zelfstandigheid.setDescription(
        "Zelfstandig werken, het zetten van de eerste stap tot of ten behoeve van iets");

    zelfstandigheid.addTrait(
        generateTrait("Autonomie", new String[]{"Ziet geen werk/kansen en neemt geen initiatief.",
            "Ziet enkel werk/kansen als de verantwoordelijke in de buurt is en neemt dan initiatief.",
            "Ziet werk/kansen, maar moet aangespoord worden om het aan te pakken.",
            "Ziet werk/kansen en pakt het spontaan aan."}));

    zelfstandigheid.addTrait(
        generateTrait("Interesse", new String[]{
            "Is alleen gericht op die zaken, opdrachten die hij/zij graag doet.",
            "Voert soms opdrachten uit die hij/zij niet graag doet.",
            "Voert alle opdrachten op aanwijzing kwaliteitsvol uit, toont meestal inzet.",
            "Voert spontaan kwaliteitsvol opdrachten uit, ook al liggen ze hem niet goed."}));

    zelfstandigheid.addTrait(
        generateTrait("Initiatief", new String[]{
            "Wacht af tot anderen actie ondernemen en doet zelf niets.",
            "Onderneemt enkel actie wanneer er gezegd wordt wat hij/zij moet doen of als de verantwoordelijke in de buurt is.",
            "Onderneemt spontaan actie bij toewijzing van taken die bij het omschreven takenpakket horen.",
            "Onderneemt spontaan actie bij taken, ook al horen ze niet strikt genomen bij het omschreven takenpakket."}));
    return zelfstandigheid;
  }

  private static Category mockInzet() {
    Category inzet = new Category("Inzet en doorzettingsvermogen");

    inzet.addTrait(generateTrait("Taakopvatting / werkafbakening",
        new String[]{"Doet zelf zo weinig mogelijk.",
            "Eerder minimaal. Neemt weinig werk op en doet nooit extra werk.",
            "Doet wat nodig is. Doet extra werk als dat gevraagd wordt.",
            "Stelt zich verantwoordelijk op. Doet spontaan meer dan gevraagd."}));

    inzet.addTrait(generateTrait("Concentratie",
        new String[]{
            "Traag werktempo bij opdrachten, taken of projecten. Verprutst zijn/haar tijd door te dromen, te kletsen, …",
            "Matig. Houdt zich zeer wisselend bezig. Heeft regelmatig aanmoediging nodig om door te zetten.",
            "Maakt zinvol gebruik van de normale tijd om een taak af te werken, een opdracht te doen.",
            "Houdt er een stevig werktempo op na. Is erg gemotiveerd."}));

    inzet.addTrait(generateTrait("Doorzettingsvermogen",
        new String[]{"Geeft snel op.",
            "Geeft vrij snel op.",
            "Geeft niet op vooraleer er een bevredigende oplossing is.",
            "Geeft nooit op, bijt zich vast in een probleem."}));

    return inzet;
  }

  private static Trait generateTrait(String traitName, String[] levelDescriptions) {

    Trait trait = new Trait(traitName);
    trait.setDescription(traitName + " tralalalala.");
    List<String> descriptions = Arrays.asList(levelDescriptions);
    for (int i = 0; i < descriptions.size() && i < 4; i++) {
      trait.addCompetenceLevel(traitName + "-level" + i, Appreciation.values()[i],
          descriptions.get(i));
    }

    return trait;
  }

}
