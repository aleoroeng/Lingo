package com.ale.lingo.service;

import com.ale.lingo.model.Noun;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.LinkedList;
import java.util.Random;

public interface WordInterface {
    Noun nounOfTheDay();
    Noun saveNoun(Noun noun);
    Noun getNounById(long id);
    Noun getNounByValue(String value);
}
