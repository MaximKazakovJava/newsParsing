package com.newsParsing.newsParsers;

import com.newsParsing.htmlParsers.HtmlGetter;
import com.newsParsing.urlParsers.Vse42_NewsUrlParserImpl;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import javax.lang.model.util.Elements;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class Vse42_NewsParserImpl implements NewsParser {

    private final Vse42_NewsUrlParserImpl vse42_newsUrlParser;
    private final HtmlGetter htmlGetter;

    public Vse42_NewsParserImpl(Vse42_NewsUrlParserImpl vse42_newsUrlParser, HtmlGetter htmlGetter) {
        this.vse42_newsUrlParser =vse42_newsUrlParser;
        this.htmlGetter = htmlGetter;
    }


    @Override
    public List<String> getNewsList() {
        List<String> urlList = vse42_newsUrlParser.getUrlList();
        System.out.println(urlList);
        List<String> newsList= new ArrayList<>();

        for (String url : urlList) {
            Optional<Document> optionalDocument= htmlGetter.getHtml(url);
            if (optionalDocument.isPresent()) {
                Document document = optionalDocument.get();
                String title = document.getElementsByClass("news-obj-wide__title").text().strip() + "\n\n";
                String paragraph = document.getElementsByClass("paragraph-block__text")
                        .stream().map(Element::text)
                        .reduce("", (text, newElement) -> text + newElement.strip() + "\n\n");
                String newsUrl = "Новость опубликована: " + url + "\n\n";

                String tags = document.getElementsByClass("news-obj-wide__tag")
                        .stream()
                        .map(element -> element.select("a").text())
                        .reduce("#Кузбасс #Кумерово #Новокузнецк ", (text, newElement) -> text + " #" +newElement.strip()) + "\n\n";

                String photobox = document.getElementsByClass("photobox")
                        .stream().map(element -> element.attr("href"))
                        .reduce("", (text, newElement) -> text + "https:" + newElement.strip() + "\n\n");

                String news = title + paragraph + newsUrl + tags + photobox;

                System.out.println(news);
                newsList.add(news);
                //            System.out.println(title);
                //            System.out.println(paragraph);
                //            System.out.println(newsUrl);
                //            System.out.println(tags);
                //            System.out.println(photobox);
            }
//            newsList.forEach();
        }



        return newsList;
    }
}
