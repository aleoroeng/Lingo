package com.ale.lingo.service;

import com.ale.lingo.model.Noun;
import com.ale.lingo.model.Russian;
import com.ale.lingo.repository.RussianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.LinkedList;
import java.util.Random;

public class RussianService implements WordInterface{

    private final RussianRepository russianRepository;

    @Autowired
    public RussianService(RussianRepository russianRepository){this.russianRepository = russianRepository;}

    //Method that returns Noun if entry with said id is in table, null otherwise
    public Noun getNounById(long id, JpaRepository repository){
        return (Noun) repository.findById(id).orElse(null);
    }

    public Noun saveNoun(Russian noun){

        //Check if it is already in DB by its value
        if(getNounByValue(noun.getValue()) != null)
            return null;

        return this.russianRepository.save(noun);
    }

    public Noun getNounByValue(String value){return this.russianRepository.findByValue(value);}

    //Return random Noun from table for noun of the day feature
    @Override
    public Noun nounOfTheDay(){
        int[] nounsInTable = {0};
        Random randomNum = new Random();
        LinkedList<Long> nounIds = new LinkedList<>();

        this.russianRepository.findAll().forEach((element)->{
            nounIds.add(element.getId()); // Need to use list because non-final variable cannot be mutated inside lambda expression
        });
        int amountOfIds = nounIds.size();

        //Check for non-positive values for table size, Random.nextInt(int input) requires: input > 0
        if(amountOfIds <= 0){
            return null;
        }

        long randomId = nounIds.get(randomNum.nextInt(nounIds.size()));
        return this.russianRepository.findById(randomId).orElse(null);
    }

    @Override
    public Noun saveNoun(Noun noun) {
        return null;
    }

    @Override
    public Noun getNounById(long id) {
        return null;
    }
}
