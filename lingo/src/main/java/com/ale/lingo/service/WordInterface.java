package com.ale.lingo.service;

import com.ale.lingo.model.Noun;

public interface WordInterface {
    Noun nounOfTheDay();
    Noun saveNoun(Noun noun);
    Noun getNounById(long id);
    Noun getNounByValue(String value);
}
