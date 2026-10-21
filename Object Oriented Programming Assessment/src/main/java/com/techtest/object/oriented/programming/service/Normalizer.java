package com.techtest.object.oriented.programming.service;

import com.techtest.object.oriented.programming.data.NormalisedRole;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.BinaryOperator;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Normalizer {

  public String normalize(String input) {

    if (input == null || input.isEmpty()) {
      throw new IllegalArgumentException("Job title cannot be null or empty");
    }

    Optional<NormalisedRole> bestFit =
        Arrays.stream(NormalisedRole.values())
            .map(role -> QualityScore.ofRole(role, input))
            .filter(q -> q.score > 0)
            .reduce(getBestFit(input))
            .map(QualityScore::role);

    if (bestFit.isEmpty()) {
      return input;
    }
    return bestFit.get().getNormalisedTitle();
  }

  private static BinaryOperator<QualityScore> getBestFit(String input) {
    return (current, next) -> current.score >= next.score ? current : next;
  }

  public record QualityScore(NormalisedRole role, double score) {
    public static QualityScore ofRole(NormalisedRole role, String input) {
      return new QualityScore(role, role.evaluateQualityScore(input));
    }
  }
}
