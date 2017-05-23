package com.ai.emm.domain;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ZhangFengZhou
 * Date:  2015/10/19
 * Time: 16:17
 * Email:zhangfz3@asiainfo.com
 */
public class PersonTest {
    @Test
    public void testPerson() {
    //1. 创建 EntitymanagerFactory
    String persistenceUnitName = "jpa-1";

    Map<String, Object> properites = new HashMap<String, Object>();
    properites.put("hibernate.show_sql",true);

    EntityManagerFactory entityManagerFactory =
            //Persistence.createEntityManagerFactory(persistenceUnitName);
            Persistence.createEntityManagerFactory(persistenceUnitName, properites);

    //2. 创建 EntityManager. 类似于 Hibernate 的 SessionFactory
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    //3. 开启事务
    EntityTransaction transaction = entityManager.getTransaction();
    transaction.begin();

    //4. 进行持久化操作
    Person person = new Person();
    person.setName("zhangsan");
    person.setAge(18);
    person.setSex(false);
    person.setBirthday(new Date());

    entityManager.persist(person);

    //5. 提交事务
    transaction.commit();

    //6. 关闭 EntityManager
    entityManager.close();

    //7. 关闭 EntityManagerFactory
    entityManagerFactory.close();
    }
}
