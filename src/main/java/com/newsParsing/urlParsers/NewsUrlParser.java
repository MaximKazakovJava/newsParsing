package com.newsParsing.urlParsers;

import org.jsoup.nodes.Document;

import java.util.List;

public interface NewsUrlParser {
    List<String> getUrlList();
}
