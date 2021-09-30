package com.ale.lingo.controller;

import com.ale.lingo.model.Noun;
import com.ale.lingo.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Noun getWordById(@RequestParam int id){
        System.out.println(id);
        return this.wordService.getNounById(id);
    }
    @PostMapping
    public Noun saveNoun(@RequestBody Noun noun){
        System.out.println(noun);
        return this.wordService.saveNoun(noun);
    }
}
