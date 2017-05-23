package com.ai.emm.ecard.dao.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.ai.emm.ecard.domain.CardCard;
import org.springframework.stereotype.Repository;


@Repository
public interface CardCardDao {
    int insert(@Param("pojo") CardCard pojo);

    int insertSelective(@Param("pojo") CardCard pojo);

    int insertList(@Param("pojos") List<CardCard> pojo);

    int update(@Param("pojo") CardCard pojo);

    List<CardCard> findByCardId(@Param("cardId")String cardId);


}
