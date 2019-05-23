package com.fx.dojo.mumbling.tdd;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class StringRepeaterTest {

    private static final StringRepeater STRING_REPEATER = new StringRepeater();

    @ParameterizedTest
    @MethodSource("givenParameterAndExpectedResult")
    void givenParameterWhenRepeatAllLettersShouldOutputExpectedResult(List<String> givenLetterList, List<String> expectedResult) {
        // When
        List<String> actualResult = STRING_REPEATER.repeatAllLetters(givenLetterList);

        // Then
        assertEquals(expectedResult, actualResult);
    }

    // given
    private static Stream<Arguments> givenParameterAndExpectedResult() {
        return Stream.of(
                arguments(Arrays.asList("A", "B", "C", "D"), Arrays.asList("A", "Bb", "Ccc", "Dddd")),
                arguments(Arrays.asList("Z", "Y", "X", "W"), Arrays.asList("Z", "Yy", "Xxx", "Wwww"))
        );
    }
}
