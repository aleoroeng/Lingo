package com.ale.lingo.dto;

import com.ale.lingo.enums.WordAttributes;
import com.ale.lingo.model.Noun;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class NounDTO extends Noun {
    int tone;

    @Builder
    public NounDTO(Noun noun, int tone) {
        super(noun.getId(), noun.getNounAttribute(), noun.getValue(), noun.isApproved(), noun.getLanguageCode());
        this.tone = tone;
    }

    public NounDTO(long id, WordAttributes nounAttribute, String value, boolean approved, String languageCode, int tone) {
        super(id, nounAttribute, value, approved, languageCode);
        this.tone = tone;
    }
    public NounDTO(){}
}
