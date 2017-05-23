package com.ai.emm.task;

import com.ai.emm.common.util.cache.DictCache;
import com.ai.emm.web.util.UserUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: ZhangFengZhou
 * Date:  2016/5/13
 * Time: 10:08
 * Email:zhangfz3@asiainfo.com
 */
@Component
public class CacheTask {
    @Scheduled(cron = "0 0 0 * * ?")
        public void loadCache() throws Exception {//每天凌晨执行一次
            DictCache.reloadData();
            UserUtil.saveJmjUser();
        }
    }
