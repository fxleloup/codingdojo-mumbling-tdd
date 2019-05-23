package com.fx.dojo.mumbling.tdd;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class AcceptanceTests {
    private static final Mumbling MUMBLING = new Mumbling(
            new StringSplitter(),
            new StringRepeater(),
            new HyphenJoiner());

    @ParameterizedTest
    @MethodSource("givenParameterAndExpectedResult")
    void givenParameterWhenAccumShouldOutputExpectedResult(String givenParameter, String expectedResult) {
        // When
        String actualResult = MUMBLING.accum(givenParameter);

        // Then
        assertEquals(expectedResult, actualResult);
    }

    // given
    private static Stream<Arguments> givenParameterAndExpectedResult() {
        return Stream.of(
                arguments(null, ""),
                arguments("", ""),
                arguments("a", "A"),
                arguments("B", "B"),
                arguments("ab", "A-Bb"),
                arguments("abcd", "A-Bb-Ccc-Dddd"),
                arguments("RqaEzty", "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"),
                arguments("cwAt", "C-Ww-Aaa-Tttt")
        );
    }
}
