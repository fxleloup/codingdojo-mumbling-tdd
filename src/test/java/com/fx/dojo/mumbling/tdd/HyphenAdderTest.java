package com.fx.dojo.mumbling.tdd;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class HyphenAdderTest {

    private static final HyphenJoiner HYPHEN_ADDER = new HyphenJoiner();

    @ParameterizedTest
    @MethodSource("givenParameterAndExpectedResult")
    void givenParameterWhenRepeatAllLettersShouldOutputExpectedResult(List<String> givenWordList, String expectedResult) {
        // When
        String actualResult = HYPHEN_ADDER.joinHyphen(givenWordList);

        // Then
        assertEquals(expectedResult, actualResult);
    }

    // given
    private static Stream<Arguments> givenParameterAndExpectedResult() {
        return Stream.of(
                arguments(Arrays.asList("coucou", "ça", "va"), "coucou-ça-va"),
                arguments(Arrays.asList("Oui", "bien"), "Oui-bien")
        );
    }

}
