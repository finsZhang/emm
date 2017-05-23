package com.ai.emm.ecard.dao.impl;

import com.ai.emm.ecard.dao.CustomSqlDao;
import com.ai.emm.ecard.domain.CardTradeRecord;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by lenovo on 2016/12/27.
 */
@Repository
public class CustomSqlDaoImpl implements CustomSqlDao {
    @PersistenceContext(unitName="entityManagerFactoryEcard")
    private EntityManager em;
    public List<CardTradeRecord> findList(String sql) {
//执行原生SQL
        Query nativeQuery = em.createQuery(sql);
        List<CardTradeRecord> resultList = nativeQuery.getResultList();
        return  resultList;
    }
}
