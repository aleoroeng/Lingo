package com.ale.lingo.model;

import com.ale.lingo.enums.WordAttributes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Noun{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected long id;
    @Enumerated(EnumType.ORDINAL)
    protected WordAttributes nounAttribute;
    protected String value;
    protected boolean approved;
    protected String languageCode;
}
