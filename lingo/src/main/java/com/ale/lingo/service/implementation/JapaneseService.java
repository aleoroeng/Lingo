package com.ale.lingo.service.implementation;

import com.ale.lingo.dto.NounDTO;
import com.ale.lingo.model.Japanese;
import com.ale.lingo.model.Noun;
import com.ale.lingo.repository.JapaneseRepository;
import com.ale.lingo.service.WordInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Random;

@Service("JP")
public class JapaneseService implements WordInterface {

    private final JapaneseRepository japaneseRepository;

    @Autowired
    public JapaneseService(JapaneseRepository japaneseRepository) {
        this.japaneseRepository = japaneseRepository;
    }

    //Method that returns Noun if entry with said id is in table, null otherwise
    public Noun getNounById(long id, JpaRepository repository){
        return (Noun) repository.findById(id).orElse(null);
    }

    //Return random Noun from table for noun of the day feature
    public NounDTO nounOfTheDay(){
        Random randomNum = new Random();
        LinkedList<Long> nounIds = new LinkedList<>();

        this.japaneseRepository.findAll().forEach((element)->{
            nounIds.add(element.getId()); // Need to use list because non-final variable cannot be mutated inside lambda expression
        });
        int amountOfIds = nounIds.size();

        //Check for non-positive values for table size, Random.nextInt(int input) requires: input > 0
        if(amountOfIds <= 0){
            return null;
        }

        long randomId = nounIds.get(randomNum.nextInt(nounIds.size()));
        Japanese randomWord = this.japaneseRepository.findById(randomId).orElse(null);
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

    @Override
    public NounDTO getNounByValue(String value) {
        return null;
    }
}
