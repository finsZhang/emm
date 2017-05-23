package com.ai.emm.specification;

import com.ai.emm.domain.LogRecordEntity;
import com.ai.emm.vo.LogRecordVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/1/6.
 */
public class LogRecordSpec implements Specification<LogRecordEntity> {
    private LogRecordVO logRecordVO;

    public LogRecordSpec() {
    }

    public LogRecordSpec(LogRecordVO logRecordVO) {
        this.logRecordVO = logRecordVO;
    }

    public Predicate toPredicate(Root<LogRecordEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<Predicate>();
        if(StringUtils.isNotBlank(logRecordVO.getBusinessType())){
            predicates.add(cb.equal(root.get("businessType"), logRecordVO.getBusinessType()));
        }
        if(StringUtils.isNotBlank(logRecordVO.getCardName())){
            predicates.add(cb.like(root.get("cardName").as(String.class), "%"+logRecordVO.getCardName().trim()+"%"));
        }
        Predicate[] p = new Predicate[predicates.size()];
        return cb.and(predicates.toArray(p));
    }
}
