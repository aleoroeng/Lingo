package com.ale.lingo.service;

import com.ale.lingo.model.Noun;
import com.ale.lingo.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordService {

    private final WordRepository wordRepository;

    @Autowired
    public WordService(WordRepository wordRepository){
        this.wordRepository = wordRepository;
    }

    public Noun getNounById(int id){
        return this.wordRepository.findById(id).orElse(null);
    }

    public Noun saveNoun(Noun noun){
        return this.wordRepository.save(noun);
    }

}
