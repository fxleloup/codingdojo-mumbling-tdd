package com.fx.dojo.mumbling.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MumblingTest {

    private StringSplitter mockedStringSplitter;
    private StringRepeater mockedStringRepeater;
    private HyphenJoiner mockedHyphenJoiner;
    private Mumbling mumbling;

    @BeforeEach
    void initMumbling(){
        this.mockedStringSplitter = mock(StringSplitter.class);
        this.mockedStringRepeater = mock(StringRepeater.class);
        this.mockedHyphenJoiner = mock(HyphenJoiner.class);
        this.mumbling = new Mumbling(this.mockedStringSplitter, this.mockedStringRepeater, this.mockedHyphenJoiner);
    }

    @ParameterizedTest
    @MethodSource("givenParameterAndExpectedResult")
    void givenParameterWhenAccumShouldOutputExpectedResult(String givenParameter, String expectedResult) {
        // When
        String actualResult = this.mumbling.accum(givenParameter);

        // Then
        assertEquals(expectedResult, actualResult);
    }

    // given
    private static Stream<Arguments> givenParameterAndExpectedResult() {
        return Stream.of(
                arguments(null, ""),
                arguments("", ""),
                arguments("a", "A"),
                arguments("B", "B")
        );
    }

    @Test
    public void givenLettersWhenAccumThenCallsSplitAllLettersCorrectly(){
        // Given
        String givenParameter = "abc";
        // When
        this.mumbling.accum(givenParameter);
        // Then
        verify(this.mockedStringSplitter).splitAllLetters("ABC");
    }

    @Test
    public void givenMockedStringSplitterWhenAccumThenCallsRepeatAllLettersCorrectly(){
        // Given
        String givenParameter = "abc";
        List<String> letterSplittedList = Arrays.asList("A", "B", "C");
        given(this.mockedStringSplitter.splitAllLetters(givenParameter.toUpperCase())).willReturn(letterSplittedList);
        // When
        this.mumbling.accum(givenParameter);
        // Then
        verify(this.mockedStringRepeater).repeatAllLetters(letterSplittedList);
    }

    @Test
    public void givenMockedStringRepeaterWhenAccumThenCallsJoinHyphenCorrectly(){
        // Given
        String givenParameter = "abc";
        List<String> letterSplittedList = Arrays.asList("A", "B", "C");
        List<String> letterRepeatedList = Arrays.asList("A", "Bb", "Ccc");
        given(this.mockedStringSplitter.splitAllLetters(givenParameter.toUpperCase())).willReturn(letterSplittedList);
        given(this.mockedStringRepeater.repeatAllLetters(letterSplittedList)).willReturn(letterRepeatedList);
        // When
        this.mumbling.accum(givenParameter);
        // Then
        verify(this.mockedHyphenJoiner).joinHyphen(letterRepeatedList);
    }
}
