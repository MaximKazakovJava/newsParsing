package com.newsParsing.newsParsers;

import com.newsParsing.urlParsers.A42_NewsUrlParserImpl;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class A42_NewsParserImpl implements NewsParser {
    private final A42_NewsUrlParserImpl a42_newsUrlParser;

    public A42_NewsParserImpl(A42_NewsUrlParserImpl a42_newsUrlParser) {this.a42_newsUrlParser = a42_newsUrlParser;}

    @Override
    public List<String> getNewsList() {
        return a42_newsUrlParser.getUrlList();
    }
}
