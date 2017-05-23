package com.ai.emm.web.controller.report;

import com.ai.emm.common.domain.ResultDTO;
import com.ai.emm.common.util.AjaxUtil;
import com.ai.emm.common.util.Constants;
import com.ai.emm.service.LogReportSV;
import com.ai.emm.servicefacade.bean.SysOrg;
import com.ai.emm.vo.LogReportVO;
import com.ai.emm.web.controller.LoginController;
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
 * reportMgt/logReport.html
 */
@Controller
@RequestMapping("/reportMgt")
public class ReportController {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);


    @Autowired
    private LogReportSV logReportSV;
    @RequestMapping(value = "/logReport/{one}.html")
    public String getPage(@PathVariable String one, @RequestParam(value="id",required=false) String id, Map map) {
        map.put("id",id);
        return "reportMgt/logReport/" + one;
    }
    @RequestMapping("/queryLogList.ajax")
    @ResponseBody
    public JSONObject queryLogList(@RequestParam(value = "page", defaultValue = "1") int page,
                                       @RequestParam(value = "rows", defaultValue = "10") int rows,
                                       LogReportVO logReportVO,HttpServletRequest request) throws Exception {
        ResultDTO result = new ResultDTO(page,rows);
        if(!Constants.STATION_CODE_ADMIN.equals(request.getSession().getAttribute(Constants.SESSION_OPERATOR_STATION))){
            SysOrg sysOrg = (SysOrg)request.getSession().getAttribute(Constants.SESSION_ORG_OBJ);
            logReportVO.setOrgCode(sysOrg.getOrgCode());
        }
        result = logReportSV.queryPageList(logReportVO, result);
        return AjaxUtil.jqGridJson(result);
    }
}
