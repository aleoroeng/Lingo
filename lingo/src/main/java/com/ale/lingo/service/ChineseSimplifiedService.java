package com.ale.lingo.service;

import com.ale.lingo.model.Noun;
import com.ale.lingo.repository.ChineseSimplifiedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.LinkedList;
import java.util.Random;

public class ChineseSimplifiedService implements WordInterface{

    private final ChineseSimplifiedRepository chineseSimplifiedRepository;

    @Autowired
    public ChineseSimplifiedService(ChineseSimplifiedRepository chineseSimplifiedRepository) {
        this.chineseSimplifiedRepository = chineseSimplifiedRepository;
    }

    //Method that returns Noun if entry with said id is in table, null otherwise
    @Override
    public Noun getNounById(long id){
        return (Noun) chineseSimplifiedRepository.findById(id).orElse(null);
    }

    @Override
    public Noun getNounByValue(String value) {
        return null;
    }

    //Return random Noun from table for noun of the day feature
    @Override
    public Noun nounOfTheDay(){
        int[] nounsInTable = {0};
        Random randomNum = new Random();
        LinkedList<Long> nounIds = new LinkedList<>();

        this.chineseSimplifiedRepository.findAll().forEach((element)->{
            nounIds.add(element.getId()); // Need to use list because non-final variable cannot be mutated inside lambda expression
        });
        int amountOfIds = nounIds.size();

        //Check for non-positive values for table size, Random.nextInt(int input) requires: input > 0
        if(amountOfIds <= 0){
            return null;
        }

        long randomId = nounIds.get(randomNum.nextInt(nounIds.size()));
        return this.chineseSimplifiedRepository.findById(randomId).orElse(null);
    }

    @Override
    public Noun saveNoun(Noun noun) {
        return null;
    }
}
