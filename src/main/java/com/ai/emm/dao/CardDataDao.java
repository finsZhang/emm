package com.ai.emm.dao;

import com.ai.emm.domain.CardDataEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lenovo on 2016/12/28.
 */
public interface CardDataDao extends PagingAndSortingRepository<CardDataEntity,Long>{
    @Query("SELECT A FROM #{#entityName} A where A.name=?1")
     Page<CardDataEntity> findByName(Pageable pageable,String name);

     Page<CardDataEntity> findAll(Pageable pageable);

     List<CardDataEntity> getListByCardNoAndCardSerial(String cardNo,String cardSerial);

     List<CardDataEntity> getListByCardNo(String cardNo);

     List<CardDataEntity> getListByCardSerial(String cardSerial);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update CardDataEntity a set a.chipSerial =:chipSerial,a.status='02' where a.cardNo=:cardNo and a.cardSerial=:cardSerial ")
    void updateCardDataByChipSerial(@Param("chipSerial") String chipSerial,@Param("cardNo") String cardNo, @Param("cardSerial")String cardSerial);
}
