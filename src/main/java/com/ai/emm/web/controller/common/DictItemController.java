package com.ai.emm.web.controller.common;

import com.ai.emm.common.util.cache.DictCache;
import com.ai.emm.domain.SysDictitemEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fins on 2016/6/23.
 */
@Controller
@RequestMapping("/common/dictItem")
public class DictItemController {
    private static Logger logger = LoggerFactory.getLogger(DictItemController.class);

    @RequestMapping("/getDictItemCondition.ajax")
    @ResponseBody
    public Map getQueryCondition(@RequestParam Map<String,String> dictMap) throws Exception {
        Map map = new HashMap();
        if(!dictMap.isEmpty()){
            for(Map.Entry<String,String> entry:dictMap.entrySet()){
                String key = entry.getKey();
                String value = entry.getValue();
                List<SysDictitemEntity> keys = DictCache.getDictItemListsByDictName(value);
                map.put(key,keys);
            }
        }
        return map;
    }
}
