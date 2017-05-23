package com.ai.emm.dao;

import com.ai.emm.domain.CardDataEntity;
import com.ai.emm.domain.CardRecordEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by lenovo on 2016/12/28.
 */
public interface CardRecordDao extends PagingAndSortingRepository<CardRecordEntity,Long>{
    @Query(value = "select count(a) from #{#entityName} a where a.txtFileName=?1")
    long countEqualsTxtFile(String fileName);
    @Query(value = "select count(a) from CardRecordEntity a where a.zipFileName=?1")
    long countEqualsZipFile(String fileName);
}
