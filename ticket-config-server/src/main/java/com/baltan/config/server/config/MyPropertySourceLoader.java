package com.baltan.config.server.config;

import org.springframework.boot.env.OriginTrackedMapPropertySource;
import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * Description: 解决读取git配置中文乱码的问题
 *
 * @author Baltan
 * @date 2019-02-25 22:03
 */
@Component
@Configuration
public class MyPropertySourceLoader implements PropertySourceLoader {
    @Override
    public String[] getFileExtensions() {
        return new String[]{"properties", "xml"};
    }

    @Override
    public List<PropertySource<?>> load(String name, Resource resource) {
        Map<String, ?> properties = getProperties(resource);
        if (properties.isEmpty()) {
            return Collections.emptyList();
        }
        return Collections.singletonList(new OriginTrackedMapPropertySource(name, properties));
    }

    private Map<String, ?> getProperties(Resource resource) {
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = resource.getInputStream();
            properties.load(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            inputStream.close();
        } catch (IOException e) {
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
        }
        return (Map) properties;
    }
}
