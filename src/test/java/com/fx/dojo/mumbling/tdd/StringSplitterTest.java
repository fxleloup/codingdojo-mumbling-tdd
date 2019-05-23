package com.fx.dojo.mumbling.tdd;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class StringSplitterTest {

    private static final StringSplitter STRING_SPLITTER = new StringSplitter();

    @ParameterizedTest
    @MethodSource("givenParameterAndExpectedResult")
    void givenParameterWhenSplitAllLettersShouldOutputExpectedResult(String givenParameter, List<String> expectedResult) {
        // When
        List<String> actualResult = STRING_SPLITTER.splitAllLetters(givenParameter);

        // Then
        assertEquals(expectedResult, actualResult);
    }

    // given
    private static Stream<Arguments> givenParameterAndExpectedResult() {
        return Stream.of(
                arguments("abcd", Arrays.asList("a", "b", "c", "d")),
                arguments("zyxw", Arrays.asList("z", "y", "x", "w"))
        );
    }
}
