package com.ale.lingo.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class ChineseSimplified extends Noun{
    private int tone;

    @Builder
    public ChineseSimplified(Noun noun, int tone){
        super(noun.getId(), noun.getNounAttribute(), noun.getValue(), noun.isApproved(), noun.getLanguageCode());
        this.tone = tone;
    }
}
