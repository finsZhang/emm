package com.ai.emm.service.impl;

import com.ai.emm.dao.SysDictitemDao;
import com.ai.emm.domain.SysDictitemEntity;
import com.ai.emm.service.SysDictitemSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhangfz3
 * Date: 2017/1/16
 * Time: 15:33
 * Tel:18665598790
 * Email:zhangfz3@asiainfo.com
 */
@Service
public class SysDictitemSVImpl  implements SysDictitemSV{
    @Autowired
    private SysDictitemDao sysDictitemDao;
    public SysDictitemEntity[] findByDictName(String dictName) {
        return sysDictitemDao.findByDictName(dictName);
    }
    public List<SysDictitemEntity> findAll() {
        return sysDictitemDao.findAll();
    }
}
