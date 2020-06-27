package com.newsParsing.htmlParsers;

import org.jsoup.nodes.Document;

import java.util.Optional;

public interface HtmlGetter {

    Optional<Document> getHtml(String url);
}
