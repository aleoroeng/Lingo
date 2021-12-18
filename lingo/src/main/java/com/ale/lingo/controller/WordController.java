package com.ale.lingo.controller;

import com.ale.lingo.dto.NounDTO;
import com.ale.lingo.model.Noun;
import com.ale.lingo.service.WordFactory;
import com.ale.lingo.service.WordInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/word")
@CrossOrigin("*")
public class WordController {
    private final WordFactory wordFactory;

    @Autowired
    public WordController(WordFactory wordFactory){
        this.wordFactory = wordFactory;
    }

    @GetMapping
    public NounDTO getWordById(@RequestBody NounDTO noun){
        System.out.println(noun);
        WordInterface wordInterface = this.wordFactory.getWordService(noun.getLanguageCode());
        return wordInterface.saveNoun(noun);
    }
    @PostMapping
    public NounDTO saveNoun(@RequestBody NounDTO noun){
        WordInterface wordInterface = this.wordFactory.getWordService(noun.getLanguageCode());
        return wordInterface.saveNoun(noun);
    }
    @PostMapping("/value")
    public NounDTO getNounByValue(@RequestBody Noun noun){
        WordInterface wordInterface = this.wordFactory.getWordService(noun.getLanguageCode());
        return wordInterface.getNounByValue(noun.getValue());
    }
    @PostMapping("/daily")
    public NounDTO wordOfTheDay(@RequestBody Noun noun){
        WordInterface wordInterface = this.wordFactory.getWordService(noun.getLanguageCode());
        return wordInterface.nounOfTheDay();
    }
}
