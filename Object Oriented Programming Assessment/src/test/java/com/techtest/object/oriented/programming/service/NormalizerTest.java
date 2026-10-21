package com.techtest.object.oriented.programming.service;

import static com.techtest.object.oriented.programming.data.Constants.ACCOUNTANT;
import static com.techtest.object.oriented.programming.data.Constants.ARCHITECT;
import static com.techtest.object.oriented.programming.data.Constants.QUANTITY_SURVEYOR;
import static com.techtest.object.oriented.programming.data.Constants.SOFTWARE_ENGINEER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NormalizerTest {

  private Normalizer normalizer;

  @BeforeEach
  void setUp() {
    normalizer = new Normalizer();
  }

  @ParameterizedTest
  @MethodSource("invalidInputArgs")
  void testNormalize_whenGivenNullOrEmpty_throwException(String invalidInputArg) {
    assertThatThrownBy(() -> normalizer.normalize(invalidInputArg))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("cannot be null or empty");
  }

  private static Stream<Arguments> invalidInputArgs() {
    return Stream.of(Arguments.of((String) null), Arguments.of(""));
  }

  @ParameterizedTest
  @MethodSource("normalisedTitlesAndOutcomes")
  void testNormalize_whenGivenATitle_returnExpectedOutput(String title, String expectedResult) {
    String actualResult = normalizer.normalize(title);

    assertThat(actualResult).isNotNull().isEqualTo(expectedResult);
  }

  private static Stream<Arguments> normalisedTitlesAndOutcomes() {
    return Stream.of(
        // examples from assessment doc
        Arguments.of("Java engineer", SOFTWARE_ENGINEER),
        Arguments.of("C# engineer", SOFTWARE_ENGINEER),
        Arguments.of("Chief Accountant", ACCOUNTANT),
        // rationale examples
        Arguments.of("Solutions architect", ARCHITECT),
        Arguments.of("Software architect", ARCHITECT),
        Arguments.of("Building architect", ARCHITECT),
        Arguments.of("Security architect", ARCHITECT),
        Arguments.of(QUANTITY_SURVEYOR, QUANTITY_SURVEYOR),
        Arguments.of("Building surveyor", QUANTITY_SURVEYOR),
        Arguments.of("Software Engineering Architect", ARCHITECT),
        Arguments.of("Quantity Accountant", ACCOUNTANT),
        // non normalizable examples
        Arguments.of("Teacher", "Teacher"),
        Arguments.of("Agile Delivery Manager", "Agile Delivery Manager"));
  }
}
