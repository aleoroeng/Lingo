package com.ale.lingo.model;

import com.ale.lingo.enums.WordAttributes;

import javax.persistence.Entity;

@Entity
public class Japanese extends Noun{
    public Japanese(long id, WordAttributes nounAttribute, String value, boolean approved, String languageCode) {
        super(id, nounAttribute, value, approved, languageCode);
    }
}
