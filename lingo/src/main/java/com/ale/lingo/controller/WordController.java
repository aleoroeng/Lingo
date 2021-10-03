package com.ale.lingo.controller;

import com.ale.lingo.model.Noun;
import com.ale.lingo.service.WordInterface;
import com.ale.lingo.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

@RestController
@RequestMapping("/word")
@CrossOrigin("*")
public class WordController {
    private final WordService wordService;

    @Autowired
    public WordController(WordService wordService){
        this.wordService = wordService;
    }

    @GetMapping()
    public Noun getWordById(@RequestBody Noun noun){
        WordInterface wordInterface = this.wordService.getLanguageRepository(noun);
        return wordInterface.getNounById(noun.getId());
    }
    @PostMapping
    public Noun saveNoun(@RequestBody Noun noun){
        WordInterface wordInterface = this.wordService.getLanguageRepository(noun);
        return wordInterface.saveNoun(noun);
    }
    @PostMapping("/value")
    public Noun getNounByValue(@RequestBody Noun noun){
        WordInterface wordInterface = wordService.getLanguageRepository(noun);
        return wordInterface.getNounByValue(noun.getValue());
    }
    @PostMapping("/daily")
    public Noun wordOfTheDay(@RequestBody Noun noun){
        WordInterface wordInterface = wordService.getLanguageRepository(noun);
        return wordInterface.nounOfTheDay();
    }
}
