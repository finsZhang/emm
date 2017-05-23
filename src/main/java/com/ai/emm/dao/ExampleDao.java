package com.ai.emm.dao;

import com.ai.emm.domain.ExampleBean;
import com.ai.emm.domain.Person;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by IntelliJ IDEA.
 * User: ZhangFengZhou
 * Date:  2015/10/19
 * Time: 14:59
 * Email:zhangfz3@asiainfo.com
 *CrudRepository,PagingAndSortingRepository,JpaRepository
 * SimpleJpaRepository,QueryDslPredicateExecutor
 */
public interface ExampleDao extends Repository<ExampleBean,Long> {
    List<ExampleBean> findByName(String name);
}
