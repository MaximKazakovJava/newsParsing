package com.newsParsing.htmlParsers;

import com.newsParsing.dataHolder.SiteUrls;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HtmlGetterImplTest {
    private final HtmlGetter htmlGetter = new HtmlGetterImpl();

    @Test
    void getHtml() {
        assertThat(htmlGetter.getHtml(SiteUrls.A42).isPresent()).isTrue();
    }
}