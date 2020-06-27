package com.newsParsing.newsParsers;

import com.newsParsing.htmlParsers.HtmlGetter;
import com.newsParsing.htmlParsers.HtmlGetterImpl;
import com.newsParsing.urlParsers.Vse42_NewsUrlParserImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vse42_NewsParserImplTest {
    private Vse42_NewsParserImpl vse42_newsParser;

    @BeforeEach
    void setUp() {
        vse42_newsParser = new Vse42_NewsParserImpl(
                new Vse42_NewsUrlParserImpl(new HtmlGetterImpl()),
                new HtmlGetterImpl());
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getNewsList() {
        vse42_newsParser.getNewsList();
    }
}