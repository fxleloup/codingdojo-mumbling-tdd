package com.fx.dojo.mumbling.tdd;

import java.util.List;
import java.util.stream.Collectors;

public class StringSplitter {
    public List<String> splitAllLetters(String givenParameter) {
        return givenParameter.chars()
                .mapToObj(letter -> (char) letter)
                .map(letter -> letter.toString())
                .collect(Collectors.toList());
    }
}
