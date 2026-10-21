package com.techtest.object.oriented.programming.data;

import static com.techtest.object.oriented.programming.data.Constants.HIGH;
import static com.techtest.object.oriented.programming.data.Constants.LOW;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum NormalisedRole {
  ARCHITECT(Constants.ARCHITECT, List.of(Weight.highOf(Constants.ARCHITECT))),
  SOFTWARE_ENGINEER(
      Constants.SOFTWARE_ENGINEER,
      List.of(Weight.lowOf(Constants.SOFTWARE), Weight.lowOf(Constants.ENGINEER))),
  QUANTITY_SURVEYOR(
      Constants.QUANTITY_SURVEYOR,
      List.of(Weight.lowOf(Constants.QUANTITY), Weight.lowOf(Constants.SURVEYOR))),
  ACCOUNTANT(Constants.ACCOUNTANT, List.of(Weight.highOf(Constants.ACCOUNTANT)));

  private final String normalisedTitle;
  private final List<Weight> weights;

  public double evaluateQualityScore(String input) {
    if (input == null || input.isEmpty()) {
      return 0;
    }
    return this.weights.stream().map(w -> w.evaluate(input)).reduce(0.0, Double::sum);
  }

  public record Weight(String keyWord, double weight) {

    public double evaluate(String input) {
      if (input != null && input.toLowerCase().contains(keyWord.toLowerCase())) {
        return weight;
      }
      return 0;
    }

    public static Weight highOf(String keyWord) {
      return new Weight(keyWord, HIGH);
    }

    public static Weight lowOf(String keyWord) {
      return new Weight(keyWord, LOW);
    }
  }
}
