package com.ai.emm.web.controller;

import com.ai.emm.domain.Person;
import com.ai.emm.service.PersonSV;
import com.ai.emm.web.httpservice.JmjHttpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ZhangFengZhou
 * Date:  2015/10/19
 * Time: 15:04
 * Email:zhangfz3@asiainfo.com
 */
@Controller
@RequestMapping(value = "/person")
public class PersnController {
    private Logger logger = LoggerFactory.getLogger(PersnController.class);
    @Autowired
    private PersonSV personSV;
    @RequestMapping(value = "/find")
    @ResponseBody
    public List<Person> findPersonByName(@RequestParam(value = "name") String name){
        List<Person> persons = personSV.findByName(name);
        return persons;
    }
}
