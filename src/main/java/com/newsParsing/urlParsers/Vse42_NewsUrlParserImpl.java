package com.newsParsing.urlParsers;

import com.newsParsing.dataHolder.SiteUrls;
import com.newsParsing.dateForParsing.DateForParsing;
import com.newsParsing.htmlParsers.HtmlGetter;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Vse42_NewsUrlParserImpl implements NewsUrlParser {
    private final String VSE42_SITE;
    private final String VSE42_Tape;

    private final HtmlGetter htmlGetter;

    public Vse42_NewsUrlParserImpl(HtmlGetter htmlGetter) {
        this.htmlGetter = htmlGetter;

        VSE42_SITE = SiteUrls.VSE42_SITE;
        VSE42_Tape = SiteUrls.VSE42_Tape;
    }


    @Override
    public List<String> getUrlList() {
        List<String> urlList = new ArrayList<>();
        Set<String> urlSet = new HashSet<>();

        for (int i = 1; i < 50; i++) {
//            System.out.println("i = " + i);
            Optional<Document> optionalDocument  = htmlGetter.getHtml(VSE42_SITE+i);
            if (optionalDocument.isEmpty()) {
                return urlList;
            } else {
                Document document = optionalDocument.get();
                Elements elements = document.getElementsByClass("list-item");
                for (Element element: elements) {
                    if (element.getElementsByClass("list-item__info list-item__info_created").text().contains("сегодня")) {
//                        System.out.println(urlList.size());
                    } else if (element.getElementsByClass("list-item__info list-item__info_created").text().contains("вчера")) {
//                        System.out.println(urlList.size());
                        urlSet.add(VSE42_Tape + element.attr("href"));
                    }
                }
            }
        }
//        System.out.println(urlSet);
        return new ArrayList<>(urlSet);
    }
}
