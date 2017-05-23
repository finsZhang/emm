package com.ai.emm.service;

import com.ai.emm.domain.Person;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ZhangFengZhou
 * Date:  2015/10/19
 * Time: 14:57
 * Email:zhangfz3@asiainfo.com
 */
public interface PersonSV {
    public List<Person> findByName(String name);
    public Person getMaxIdPerson();
}
