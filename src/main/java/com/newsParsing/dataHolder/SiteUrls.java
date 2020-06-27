package com.newsParsing.dataHolder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface SiteUrls {
    String A42 = "https://gazeta.a42.ru/lenta/news";
    String VSE42_SITE = "https://vse42.ru/news/all/all/";
    String VSE42_Tape = "https://vse42.ru";
    String[] siteUrls = new String[] {A42};

    List<String> getSiteUrls();
}
