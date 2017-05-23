package com.ai.emm.dao;

import com.ai.emm.domain.LogRecordEntity;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.logging.LogRecord;

/**
 * Created by Walter on 2016/12/28.
 */
public interface LogRecordDao extends JpaRepository<LogRecordEntity,Long>,JpaSpecificationExecutor<LogRecordEntity> {
    Page<LogRecordEntity> findAll(Specification<LogRecordEntity> spec, Pageable pageable);
}