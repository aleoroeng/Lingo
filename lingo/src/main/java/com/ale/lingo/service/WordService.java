package com.ale.lingo.service;

import com.ale.lingo.model.Noun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordService{

    private final RussianService russianService;
    private final JapaneseService japaneseService;
    private final KoreanService koreanService;
    private final ChineseSimplifiedService chineseSimplifiedService;
    private final ChineseTraditionalService chineseTraditionalService;

    @Autowired
    public WordService(RussianService russianService, JapaneseService japaneseService, KoreanService koreanService,
                       ChineseSimplifiedService chineseSimplifiedService, ChineseTraditionalService chineseTraditionalService) {
        this.russianService = russianService;
        this.japaneseService = japaneseService;
        this.koreanService = koreanService;
        this.chineseSimplifiedService = chineseSimplifiedService;
        this.chineseTraditionalService = chineseTraditionalService;
    }

    public WordInterface getLanguageRepository(Noun noun){
        switch(noun.getLanguageCode()){
            case ZHS:
                return this.chineseSimplifiedService;
            case ZHT:
                return this.chineseTraditionalService;
            case JP:
                return this.japaneseService;
            case KO:
                return this.koreanService;
            case RU:
                return this.russianService;
            default:
                return null;
        }
    }

}
