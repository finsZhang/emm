package com.ai.emm.ecard.dao;

import com.ai.emm.ecard.domain.CsvNews;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by lenovo on 2016/12/27.
 */
public interface CsvNewsDao extends Repository<CsvNews,String> {
    List<CsvNews> findByNewsType(String name);
}
