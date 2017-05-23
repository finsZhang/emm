package com.ai.emm.dao.mapper;

import com.ai.emm.domain.LogRecordEntity;
import com.ai.emm.vo.LogRecordVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by IntelliJ IDEA.
 * User: zhangfz3
 * Date: 2017/5/23
 * Time: 14:15
 * Tel:18665598790
 * Email:zhangfz3@asiainfo.com
 */
@Mapper
public interface LogRecordMapper {
    LogRecordVO findById(@Param("id") String id);
}
