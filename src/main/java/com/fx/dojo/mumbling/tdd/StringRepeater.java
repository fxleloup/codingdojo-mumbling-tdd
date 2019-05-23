package com.fx.dojo.mumbling.tdd;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StringRepeater {
    public List<String> repeatAllLetters(List<String> letterList) {
        final AtomicInteger repetitions = new AtomicInteger(0);
        return letterList.stream()
                .map(letter -> repeat(letter, repetitions.getAndIncrement()))
                .collect(Collectors.toList());
    }

    static String repeat(String letter, int repetitions) {
        StringBuilder letterRepeated = new StringBuilder(letter);
        String letterLowercase = letter.toLowerCase();
        while(repetitions > 0){
            letterRepeated.append(letterLowercase);
            repetitions--;
        }
        return letterRepeated.toString();
    }
}
