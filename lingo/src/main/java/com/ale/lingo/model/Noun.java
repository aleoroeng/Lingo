package com.ale.lingo.model;

import com.ale.lingo.enums.WordAttributes;

import javax.persistence.*;

@Entity
public class Noun{


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Enumerated(EnumType.ORDINAL)
    WordAttributes nounAttribute;
    private String value;
    private boolean approved;

    public Noun(){}
    public Noun(String value){
        this.value = value;
    }
    public Noun(long id, WordAttributes nounAttribute, String value) {
        this.id = id;
        this.nounAttribute = nounAttribute;
        this.value = value;
        this.approved = false;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public long getId() {
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
                "id=" + id +
                ", nounAttribute=" + nounAttribute +
                ", value='" + value + '\'' +
                ", approved=" + approved +
                '}';
    }
}
