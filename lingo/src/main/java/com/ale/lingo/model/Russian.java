package com.ale.lingo.model;

import com.ale.lingo.enums.WordAttributes;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Russian extends Noun{
    @Builder
    public Russian(long id, WordAttributes nounAttribute, String value, boolean approved, String languageCode) {
        super(id, nounAttribute, value, approved, languageCode);
    }
}
