package com.fx.dojo.mumbling.tdd;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Mumbling {

    private StringSplitter stringSplitter;
    private StringRepeater stringRepeater;
    private HyphenJoiner hyphenAdder;

    public String accum(String givenParameter) {
        if(givenParameter == null || givenParameter.isEmpty()){
            return "";
        }
        String givenParameterInUpperCase = givenParameter.toUpperCase();
        if(givenParameter.length() == 1){
            return givenParameterInUpperCase;
        }
        List<String> letterUpperCaseList = this.stringSplitter.splitAllLetters(givenParameterInUpperCase);
        List<String> repeatedLetterList = this.stringRepeater.repeatAllLetters(letterUpperCaseList);
        return this.hyphenAdder.joinHyphen(repeatedLetterList);
    }
}
