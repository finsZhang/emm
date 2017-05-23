package com.ai.emm.web.controller.common;
import com.ai.emm.common.util.JsonUtil;
import com.ai.emm.common.util.PropertiesUtils;
import com.ai.emm.servicefacade.bean.OrgsResponse;
import com.ai.emm.servicefacade.service.interfaces.IOrgSV;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;

@Controller
@RequestMapping("/common")
public class CommonController {
    private Logger logger = LoggerFactory.getLogger(CommonController.class);
    @Autowired
    private IOrgSV orgSV;

	@RequestMapping("/downloadImg.ajax")
    public String downloadImg(HttpServletRequest request,
            HttpServletResponse response) {
		String fileName = request.getParameter("fileName");
		String oldName = request.getParameter("oldName");
		try {
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName="
                +  new String( oldName.getBytes("gb2312"), "ISO8859-1" ));

            String path = PropertiesUtils.getContextProperty("ImgUpPath");
            InputStream inputStream = new FileInputStream(new File(path
            		+ fileName));
            OutputStream os = response.getOutputStream();
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }
 
            os.close();
 
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
			e.printStackTrace();
		}
        return null;
    }
	
	@RequestMapping("/downloadFile.ajax")
    public String downloadFile(HttpServletRequest request,
            HttpServletResponse response) {
		String fileName = request.getParameter("fileName");
		String oldName = request.getParameter("oldName");
		try {
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName="
                +  new String( oldName.getBytes("gb2312"), "ISO8859-1" ));

            String docUpPath = PropertiesUtils.getContextProperty("DocUpPath");
            
            InputStream inputStream = new FileInputStream(new File(docUpPath + fileName));
            OutputStream os = response.getOutputStream();
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }
            os.close();
 
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
			e.printStackTrace();
		}
        return null;
    }

    @RequestMapping("/getOrgs.ajax")
    @ResponseBody
    public String getOrgs(@RequestParam Map paramMap) throws Exception {
        OrgsResponse orgResponse = orgSV.retrieveOrg(paramMap);
        return JsonUtil.toJson(orgResponse.getSysOrgBeans());
    }

}
