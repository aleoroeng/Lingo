package com.ale.lingo.service;

import com.ale.lingo.model.Noun;
import com.ale.lingo.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Random;

@Service
public class WordService {

    private final WordRepository wordRepository;

    @Autowired
    public WordService(WordRepository wordRepository){
        this.wordRepository = wordRepository;
    }

    //Method that returns Noun if entry with said id is in table, null otherwise
    public Noun getNounById(long id){
        return this.wordRepository.findById(id).orElse(null);
    }

    //Method to add Noun to Table without duplicate noun values
    public Noun saveNoun(Noun noun){

        //Check if it is already in DB by its value
        if(getNounByValue(noun.getValue()) != null)
            return null;

        return this.wordRepository.save(noun);
    }

    public Noun getNounByValue(String value){return this.wordRepository.findByValue(value);}

    //Return random Noun from table for noun of the day feature
    public Noun nounOfTheDay(){
        int[] nounsInTable = {0};
        Random randomNum = new Random();
        LinkedList<Long> nounIds = new LinkedList<>();

        this.wordRepository.findAll().forEach((element)->{
            nounIds.add(element.getId()); // Need to use list because non-final variable cannot be mutated inside lambda expression
        });
        int amountOfIds = nounIds.size();

        //Check for non-positive values for table size, Random.nextInt(int input) requires: input > 0
        if(amountOfIds <= 0){
            return null;
        }

        long randomId = nounIds.get(randomNum.nextInt(nounIds.size()));
        return this.wordRepository.findById(randomId).orElse(null);
    }

}
