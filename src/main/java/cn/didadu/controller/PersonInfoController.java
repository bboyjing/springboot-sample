package cn.didadu.controller;

import cn.didadu.domain.Person;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinggg on 16/4/23.
 */

@Controller
public class PersonInfoController {

    @RequestMapping("/person")
    public String personInfo(Model model){
        Person single = new Person("zhangjing", 28);
        List<Person> people = new ArrayList<>();
        Person p1 = new Person("xx",1);
        Person p2 = new Person("yy",2);
        Person p3 = new Person("zz",3);
        people.add(p1);
        people.add(p2);
        people.add(p3);

        model.addAttribute("singlePerson", single);
        model.addAttribute("people", people);

        return "person";
    }

    @RequestMapping(value = "/search", produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Person search(String personName){
        return new Person(personName, 28, "hangzhou");
    }

}
