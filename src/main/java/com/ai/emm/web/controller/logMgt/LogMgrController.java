package com.ai.emm.web.controller.logMgt;

import com.ai.emm.common.domain.ResultDTO;
import com.ai.emm.common.util.AjaxUtil;
import com.ai.emm.common.util.Constants;
import com.ai.emm.service.impl.LogRecordSVImpl;
import com.ai.emm.servicefacade.bean.SysOrg;
import com.ai.emm.vo.LogRecordVO;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by lenovo on 2016/12/28.
 */
@Controller
@RequestMapping("/logMgr")
public class LogMgrController {
    private Logger logger = LoggerFactory.getLogger(LogMgrController.class);
    @Autowired
    private LogRecordSVImpl logRecordSV;
    @RequestMapping(value = "/page/{one}.html")
    public String getPage(@PathVariable String one, @RequestParam(value="id",required=false) String id, Map map) {
        map.put("id",id);
        return "logMgr/logMgr/" + one;
    }
    @RequestMapping("/queryLogList.ajax")
    @ResponseBody
    public JSONObject queryLogList(@RequestParam(value = "page", defaultValue = "1") int page,
                                       @RequestParam(value = "rows", defaultValue = "10") int rows,
                                       LogRecordVO logRecordVO,HttpServletRequest request) throws Exception {
        ResultDTO result = new ResultDTO(page,rows);
        if(!Constants.STATION_CODE_ADMIN.equals(request.getSession().getAttribute(Constants.SESSION_OPERATOR_STATION))){
            SysOrg sysOrg = (SysOrg)request.getSession().getAttribute(Constants.SESSION_ORG_OBJ);
            logRecordVO.setOrgCode(sysOrg.getOrgCode());
        }
        result = logRecordSV.queryPageList(logRecordVO, result);
        return AjaxUtil.jqGridJson(result);
    }
}
