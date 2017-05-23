package com.ai.emm.dao;

import com.ai.emm.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ZhangFengZhou
 * Date:  2015/10/19
 * Time: 15:17
 * Email:zhangfz3@asiainfo.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PersonSVTests {
    @Autowired
    private PersonDao personDao;

    @Test
    public void testSave(){
       List<Person> persons = personDao.findByName("YY");
        System.out.println(persons.size());
    }
    @Test
    public void testQuery(){
       System.out.println(personDao.getMaxIdPerson());
    }
    @Test
    public void testfindByNameAndAge(){
        System.out.println(personDao.findByNameAndAge("ZHANGSAN",18));
    }
    @Test
    public void findByNameAndAgeAnnotation(){
        System.out.println(personDao.findByNameAndAgeAnnotation1());
    }

    @Test
    public void updatePersonNameById(){
        personDao.updatePersonNameById("wangwu", 2);
    }
}
