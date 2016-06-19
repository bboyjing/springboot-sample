package cn.didadu.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 对应配置文件配置如下信息
 * book.author=wangyunfei
 * book.name=spring book
 * Created by jinggg on 16/4/23.
 */

@Component
@ConfigurationProperties(prefix = "book")
public class AuthorSettings {

    private String author;

    private String name;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
