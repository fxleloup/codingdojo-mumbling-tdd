package com.fx.dojo.mumbling.tdd;

import java.util.List;
import java.util.stream.Collectors;

public class HyphenJoiner {
    public String joinHyphen(List<String> wordList) {
        return wordList.stream()
                .collect(Collectors.joining("-"));
    }
}
