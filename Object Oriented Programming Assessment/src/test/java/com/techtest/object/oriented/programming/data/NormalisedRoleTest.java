package com.techtest.object.oriented.programming.data;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

class NormalisedRoleTest {

  @ParameterizedTest
  @MethodSource("invalidInputs")
  void testEvaluate_withInvalidArgs_returnsZero(String invalidInput) {
    NormalisedRole role = NormalisedRole.ARCHITECT;

    double result = role.evaluateQualityScore(invalidInput);

    assertThat(result).isEqualTo(0.0);
  }

  @ParameterizedTest
  @MethodSource("invalidInputs")
  void testWeightEvaluate_withInvalidArgs_returnsZero(String invalidInput) {
    NormalisedRole role = NormalisedRole.ACCOUNTANT;

    double weightResult = role.getWeights().getFirst().evaluate(invalidInput);

    assertThat(weightResult).isEqualTo(0.0);
  }

  private static Stream<Arguments> invalidInputs() {
    return Stream.of(Arguments.of((String) null), Arguments.of(""));
  }

  @ParameterizedTest
  @EnumSource(NormalisedRole.class)
  void testNormalizedResult_returns_rolls_andWeights(NormalisedRole role) {
    assertThat(role).isNotNull();
    assertThat(role.getNormalisedTitle()).isNotNull().isNotEmpty();
    assertThat(role.getWeights()).isNotNull().isNotEmpty();
  }
}
