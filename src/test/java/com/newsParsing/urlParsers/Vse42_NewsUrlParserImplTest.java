package com.newsParsing.urlParsers;

import com.newsParsing.dateForParsing.DateForParsing;
import com.newsParsing.htmlParsers.HtmlGetter;
import com.newsParsing.htmlParsers.HtmlGetterImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vse42_NewsUrlParserImplTest {

    private Vse42_NewsUrlParserImpl vse42_newsUrlParser;

    @BeforeEach
    void setUp() {
        vse42_newsUrlParser = new Vse42_NewsUrlParserImpl(new HtmlGetterImpl());
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getUrlList() {
        vse42_newsUrlParser.getUrlList();
    }
}