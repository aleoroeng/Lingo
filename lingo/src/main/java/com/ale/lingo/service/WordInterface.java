package com.ale.lingo.service;

import com.ale.lingo.dto.NounDTO;

public interface WordInterface {
    NounDTO nounOfTheDay();
    NounDTO saveNoun(NounDTO noun);
    NounDTO getNounById(long id);
    NounDTO getNounByValue(String value);
}
