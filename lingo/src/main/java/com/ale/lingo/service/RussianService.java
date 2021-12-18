package com.ale.lingo.service;

import com.ale.lingo.dto.NounDTO;
import com.ale.lingo.model.Noun;
import com.ale.lingo.model.Russian;
import com.ale.lingo.repository.RussianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Random;

@Service("RU")
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

    public NounDTO getNounByValue(String value){
        Russian noun = this.russianRepository.findByValue(value);
        return NounDTO.builder().noun(noun).build();
    }

    //Return random Noun from table for noun of the day feature
    @Override
    public NounDTO nounOfTheDay(){
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
        Russian randomWord= this.russianRepository.findById(randomId).orElse(null);
        return NounDTO.builder().noun(randomWord).build();
    }

    @Override
    public NounDTO saveNoun(NounDTO noun) {
        return null;
    }

    @Override
    public NounDTO getNounById(long id) {
        return null;
    }
}
