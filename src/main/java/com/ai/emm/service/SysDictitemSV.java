package com.ai.emm.service;

import com.ai.emm.domain.SysDictitemEntity;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhangfz3
 * Date: 2017/1/16
 * Time: 15:28
 * Tel:18665598790
 * Email:zhangfz3@asiainfo.com
 */
public interface SysDictitemSV {
    SysDictitemEntity[] findByDictName(String dictName);

    List<SysDictitemEntity> findAll();
}
