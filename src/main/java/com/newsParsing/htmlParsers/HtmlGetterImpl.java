package com.newsParsing.htmlParsers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
public class HtmlGetterImpl implements HtmlGetter {

    @Override
    public Optional<Document> getHtml(String url) {

        Document document = null;

        try {
            document = Jsoup.connect(url)
                    .userAgent("Chrome/4.0.249.0 Safari/532.5")
                    .referrer("https://yandex.ru/")
                    .get();
        } catch (IOException e) {
            System.out.println("Такой страницы нет");
        }

        return Optional.ofNullable(document);
    }
}
