package com.ai.emm.service.impl;

import com.ai.emm.dao.PersonDao;
import com.ai.emm.domain.Person;
import com.ai.emm.service.PersonSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ZhangFengZhou
 * Date:  2015/10/19
 * Time: 14:58
 * Email:zhangfz3@asiainfo.com
 */
@Service
public class PersonSVImpl implements PersonSV {
    @Autowired
    private PersonDao personDao;
    public List<Person> findByName(String name){
        return personDao.findByName(name);
    }
    public Person getMaxIdPerson(){
        return personDao.getMaxIdPerson();
    }
}
