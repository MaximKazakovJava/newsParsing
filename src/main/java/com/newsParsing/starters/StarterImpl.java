package com.newsParsing.starters;

import com.newsParsing.dataHolder.SiteUrls;
import com.newsParsing.newsParsers.NewsParser;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;


@Component
public class StarterImpl implements Starter {
    private final List<NewsParser> newsParserList;

    public StarterImpl(List<NewsParser> newsParserList) {this.newsParserList = newsParserList;}


    @Override
    public void start() {
        newsParserList.forEach(el -> System.out.println(el.getNewsList().get(0)));
    }
}
