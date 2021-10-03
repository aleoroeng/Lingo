package com.ale.lingo.model;

import com.ale.lingo.enums.LanguageCode;
import com.ale.lingo.enums.WordAttributes;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Noun{


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected long id;
    @Enumerated(EnumType.ORDINAL)
    protected WordAttributes nounAttribute;
    protected String value;
    protected boolean approved;
    @Enumerated(EnumType.ORDINAL)
    protected LanguageCode languageCode;

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

    public LanguageCode getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(LanguageCode languageCode) {
        this.languageCode = languageCode;
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
