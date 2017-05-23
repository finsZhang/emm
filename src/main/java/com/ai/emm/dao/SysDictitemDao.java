package com.ai.emm.dao;

import com.ai.emm.domain.SysDictitemEntity;
import com.ai.emm.domain.SysDictitemEntityPK;
import com.ai.emm.ecard.domain.CsvNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

/**
 * Created by IntelliJ IDEA.
 * User: zhangfz3
 * Date: 2017/1/16
 * Time: 15:27
 * Tel:18665598790
 * Email:zhangfz3@asiainfo.com
 */
public interface SysDictitemDao extends JpaRepository<SysDictitemEntity, SysDictitemEntityPK> {
    SysDictitemEntity[] findByDictName(String dictName);
}
