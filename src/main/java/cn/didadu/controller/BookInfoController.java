package cn.didadu.controller;

import cn.didadu.config.AuthorSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jinggg on 16/4/22.
 */
@RestController
public class BookInfoController {

    /**
     * 以下获取配置文件的内容可以被注入类取代
     */
   /* @Value("${book.author}")
    private String bookAuthor;
    @Value("${book.name}")
    private String bookName;*/

    /**
     * 获取配置文件信息
     */
    @Autowired
    private AuthorSettings authorSettings;

    @RequestMapping("/book")
    public String index(){
        return "book name is: " + authorSettings.getName() + " book author is: " + authorSettings.getAuthor();
    }
}
