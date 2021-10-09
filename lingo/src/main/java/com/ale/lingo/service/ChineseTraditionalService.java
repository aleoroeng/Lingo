package com.ale.lingo.service;

import com.ale.lingo.model.Noun;
import com.ale.lingo.repository.ChineseTraditionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Random;

@Service
public class ChineseTraditionalService implements WordInterface{

    private final ChineseTraditionalRepository chineseTraditionalRepository;

    @Autowired
    public ChineseTraditionalService(ChineseTraditionalRepository chineseTraditionalRepository) {
        this.chineseTraditionalRepository = chineseTraditionalRepository;
    }

    //Method that returns Noun if entry with said id is in table, null otherwise
    public Noun getNounById(long id, JpaRepository repository){
        return (Noun) repository.findById(id).orElse(null);
    }

    //Return random Noun from table for noun of the day feature
    public Noun nounOfTheDay(){
        int[] nounsInTable = {0};
        Random randomNum = new Random();
        LinkedList<Long> nounIds = new LinkedList<>();

        this.chineseTraditionalRepository.findAll().forEach((element)->{
            nounIds.add(element.getId()); // Need to use list because non-final variable cannot be mutated inside lambda expression
        });
        int amountOfIds = nounIds.size();

        //Check for non-positive values for table size, Random.nextInt(int input) requires: input > 0
        if(amountOfIds <= 0){
            return null;
        }

        long randomId = nounIds.get(randomNum.nextInt(nounIds.size()));
        return this.chineseTraditionalRepository.findById(randomId).orElse(null);
    }

    @Override
    public Noun saveNoun(Noun noun) {
        return null;
    }

    @Override
    public Noun getNounById(long id) {
        return null;
    }

    @Override
    public Noun getNounByValue(String value) {
        return null;
    }
}
