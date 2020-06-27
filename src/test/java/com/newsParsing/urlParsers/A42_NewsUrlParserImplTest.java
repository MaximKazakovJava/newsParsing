package com.newsParsing.urlParsers;

import com.newsParsing.dataHolder.SiteUrls;
import com.newsParsing.dateForParsing.DateForParsing;
import com.newsParsing.htmlParsers.HtmlGetter;
import com.newsParsing.htmlParsers.HtmlGetterImpl;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class A42_NewsUrlParserImplTest {

    private A42_NewsUrlParserImpl a42_newsUrlParser;

    @BeforeEach
    void setUp() {
        a42_newsUrlParser = new A42_NewsUrlParserImpl(new HtmlGetterImpl(), new DateForParsing());
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getUrlList() {
        a42_newsUrlParser.getUrlList();
    }




}