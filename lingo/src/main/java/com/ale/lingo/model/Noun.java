package com.ale.lingo.model;

import com.ale.lingo.enums.WordAttributes;

import javax.persistence.*;
import java.util.List;

@Entity
public class Noun{


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Enumerated(EnumType.ORDINAL)
    WordAttributes nounAttribute;
    private String value;

    public Noun(){}

    public Noun(int id, WordAttributes nounAttribute, String value) {
        this.id = id;
        this.nounAttribute = nounAttribute;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public WordAttributes getNounAttribute() {
        return nounAttribute;
    }

    public void setNounAttribute(WordAttributes nounAttribute) {
        this.nounAttribute = nounAttribute;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Noun{" +
                "nounAttribute=" + nounAttribute +
                ", id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
