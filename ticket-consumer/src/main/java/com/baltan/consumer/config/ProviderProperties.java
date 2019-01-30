package com.baltan.consumer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author Baltan
 * @date 2019-01-29 15:44
 */
@Component
@ConfigurationProperties("provider")
public class ProviderProperties {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
