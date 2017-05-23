package com.ai.emm.ecard.dao;

import com.ai.emm.dao.ExampleDao;
import com.ai.emm.domain.ExampleBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by lenovo on 2016/12/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ExampleTest {
    @Autowired
    private ExampleDao exampleDao;

    @Test
    @Transactional()
    public void testUpdateCustomer(){
        List<ExampleBean> examples = exampleDao.findByName("zhangsan");

        System.out.println();
    }
}
