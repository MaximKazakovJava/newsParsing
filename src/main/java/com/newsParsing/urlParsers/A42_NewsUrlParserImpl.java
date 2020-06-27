package com.newsParsing.urlParsers;

import com.newsParsing.dataHolder.SiteUrls;
import com.newsParsing.dateForParsing.DateForParsing;
import com.newsParsing.htmlParsers.HtmlGetter;
import com.newsParsing.htmlParsers.HtmlGetterImpl;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

@Component
public class A42_NewsUrlParserImpl implements NewsUrlParser {
    private final String A42URL;
    private final String yesterdayDateString;
    private final String dayBeforeYesterday;

    private final HtmlGetter htmlGetter;


    public A42_NewsUrlParserImpl(HtmlGetter htmlGetter, DateForParsing dateForParsing) {
        this.htmlGetter = htmlGetter;

        A42URL = SiteUrls.A42;
        yesterdayDateString = dateForParsing.getYesterdayDateString();
        dayBeforeYesterday = dateForParsing.getDayBeforeYesterday();
    }

    @Override
    public List<String> getUrlList() {
        List<String> urlList = new ArrayList<>();
        Set<String> urlSet = new HashSet<>();

        Optional<Document> stringOptional = htmlGetter.getHtml(A42URL);
        Elements elements;
        System.out.println("Начало работы");
        if (stringOptional.isEmpty()) {
            return urlList;
        } else {
            UnaryOperator<String> unaryOperator = (el) -> {
                if ("".equals(el)) {
                    return "";
                } else {
                    return (String) el.subSequence(0, 2);
                }
            };
            elements = stringOptional.get().getElementsByClass("item").removeClass("category-tag");
            for (Element element : elements) {
                String link = element.attr("href");
                String today = unaryOperator.apply(element.getElementsByClass("date-label").text());
                System.out.println("Job FOR cycle");

                if (!"".equals(link)) {
//                    urlList.add(link);
                    urlSet.add(link);
                }
            }
//            System.out.println(urlList);
            System.out.println(urlSet);

        }
        return urlList;
    }


}
