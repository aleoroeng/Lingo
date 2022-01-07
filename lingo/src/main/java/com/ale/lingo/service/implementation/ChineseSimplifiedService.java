package com.ale.lingo.service.implementation;

import com.ale.lingo.dto.NounDTO;
import com.ale.lingo.model.ChineseSimplified;
import com.ale.lingo.repository.ChineseSimplifiedRepository;
import com.ale.lingo.service.WordInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Random;

@Service("ZHS")
public class ChineseSimplifiedService implements WordInterface {

    private final ChineseSimplifiedRepository chineseSimplifiedRepository;

    @Autowired
    public ChineseSimplifiedService(ChineseSimplifiedRepository chineseSimplifiedRepository) {
        this.chineseSimplifiedRepository = chineseSimplifiedRepository;
    }

    //Method that returns Noun if entry with said id is in table, null otherwise
    @Override
    public NounDTO getNounById(long id){
        ChineseSimplified noun = this.chineseSimplifiedRepository.findById(id).orElse(null);
        return NounDTO.builder().noun(noun).build();
    }

    @Override
    public NounDTO getNounByValue(String value) {
        return null;
    }

    //Return random Noun from table for noun of the day feature
    @Override
    public NounDTO nounOfTheDay(){
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
        ChineseSimplified randomWord = this.chineseSimplifiedRepository.findById(randomId).orElse(null);
        return NounDTO.builder().noun(randomWord).build();
    }

    @Override
    public NounDTO saveNoun(NounDTO noun) {
        ChineseSimplified zhsWord = ChineseSimplified.builder().noun(noun).tone(noun.getTone()).build();
        ChineseSimplified savedWord = this.chineseSimplifiedRepository.save(zhsWord);
        return NounDTO.builder().noun(savedWord).tone(savedWord.getTone()).build();
    }
}
