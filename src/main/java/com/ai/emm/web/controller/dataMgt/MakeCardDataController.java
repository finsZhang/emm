package com.ai.emm.web.controller.dataMgt;

import com.ai.emm.common.domain.ResultDTO;
import com.ai.emm.common.util.*;
import com.ai.emm.domain.CardDataEntity;
import com.ai.emm.domain.CardRecordEntity;
import com.ai.emm.exception.ParameterException;
import com.ai.emm.service.CommonSV;
import com.ai.emm.service.MakeCardDataSV;
import com.ai.emm.servicefacade.bean.User;
import com.ai.emm.vo.CardDataVO;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2016/12/28.
 */
@Controller
@RequestMapping("/makeCardDataMgt")
public class MakeCardDataController {
    private Logger logger = LoggerFactory.getLogger(MakeCardDataController.class);
    @Autowired
    private MakeCardDataSV makeCardDataSV;
    @Autowired
    private CommonSV commonSV;
    @RequestMapping(value = "/page/{one}.html")
    public String getPage(@PathVariable String one, @RequestParam(value="id",required=false) String id, Map map) {
        map.put("id",id);
        return "dataMgt/makeCardMgt/" + one;
    }
    @RequestMapping("/queryMakeCardList.ajax")
    @ResponseBody
    public JSONObject queryMakeCardList(@RequestParam(value = "page", defaultValue = "1") int page,
                                        @RequestParam(value = "rows", defaultValue = "10") int rows,
                                         CardDataVO cardDataVO) throws Exception {
        ResultDTO<CardDataVO> result = new ResultDTO<CardDataVO>(page,rows);
        result = makeCardDataSV.queryPageList(cardDataVO, result);
        return AjaxUtil.jqGridJson(result);
    }

    //查询账户变更记录
    @RequestMapping("/uploadCardData.ajax")
    @ResponseBody
    public synchronized JSONObject uploadCardData(HttpServletRequest request,HttpServletResponse response) throws Exception {
        JSONObject json = new JSONObject() ;
        User user = (User) (request.getSession().getAttribute(Constants.SESSION_USER_OBJ));
        String dataType = request.getParameter("dataType");
        File zipFile = null;
        String zipFilePath = null;
        BufferedReader reader = null;
        try {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile cardDataFile = multipartRequest.getFile("cardDataFile");// 获取上传文件名
            long zipNum = makeCardDataSV.countNumByZipFile(cardDataFile.getOriginalFilename());
            if(zipNum>0){
                json.put("ERRCODE", "1");
                json.put("ERRINFO", "该压缩文件已导入，无需再次导入！");
                return json;
            }
            Map<String,Txt2Bean> mainCardFieldCols = new HashMap<String,Txt2Bean>();
            mainCardFieldCols.put("orgName",new Txt2Bean(98,String.class));
            mainCardFieldCols.put("orgCode",new Txt2Bean(99,String.class));
            mainCardFieldCols.put("cityCode",new Txt2Bean(92,String.class));
            mainCardFieldCols.put("cardSerial",new Txt2Bean(100,String.class));
            mainCardFieldCols.put("cardNo",new Txt2Bean(102,String.class));
            mainCardFieldCols.put("masterType",new Txt2Bean(95,String.class));
            mainCardFieldCols.put("daughterType",new Txt2Bean(96,String.class));
            mainCardFieldCols.put("name",new Txt2Bean(113,String.class));
            mainCardFieldCols.put("sex",new Txt2Bean(114,String.class));
            mainCardFieldCols.put("idNo",new Txt2Bean(116,String.class));
            mainCardFieldCols.put("phoneNo",new Txt2Bean(119,String.class));
            mainCardFieldCols.put("address",new Txt2Bean(120,String.class));

            Map<String,Txt2Bean> subCardFieldCols = new HashMap<String,Txt2Bean>();
            subCardFieldCols.put("orgName",new Txt2Bean(6,String.class));
            subCardFieldCols.put("orgCode",new Txt2Bean(7,String.class));
            subCardFieldCols.put("cityCode",new Txt2Bean(0,String.class));
            subCardFieldCols.put("cardSerial",new Txt2Bean(8,String.class));
            subCardFieldCols.put("cardNo",new Txt2Bean(10,String.class));
            subCardFieldCols.put("masterType",new Txt2Bean(3,String.class));
            subCardFieldCols.put("daughterType",new Txt2Bean(4,String.class));
            subCardFieldCols.put("name",new Txt2Bean(21,String.class));
            subCardFieldCols.put("sex",new Txt2Bean(22,String.class));
            subCardFieldCols.put("idNo",new Txt2Bean(24,String.class));
            subCardFieldCols.put("phoneNo",new Txt2Bean(27,String.class));
            subCardFieldCols.put("address",new Txt2Bean(28,String.class));

            String docUpPath = PropertiesUtils.getContextProperty("DocUpPath");
            UpFileUtils.uploadPic(cardDataFile,docUpPath,cardDataFile.getOriginalFilename());
            zipFilePath = docUpPath+cardDataFile.getOriginalFilename();
            UnCompressFile unCompressFile = UnCompressFile.getInstance();
            String idsUUID = UUIDUtil.getUUID();
            unCompressFile.deCompress(docUpPath+cardDataFile.getOriginalFilename(),docUpPath+idsUUID);//解压缩图片到临时目录，读取文件
            zipFile = new File(docUpPath+idsUUID);
            File[] sjFiles = zipFile.listFiles(new CustomFileFilter.ZKSJFileFilter());
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(sjFiles[0]),"GBK"));
            String line;
            int i = 0;
            Map<String,CardRecordEntity> batchNum2CardRecord = new HashMap<String, CardRecordEntity>();
            CardRecordEntity cardRecordEntity;
            while ((line = reader.readLine()) != null) {
                if (i < 1) {
                    i++;
                    continue;
                }
                String[]lineData = line.split(":");
                cardRecordEntity = new CardRecordEntity();
                cardRecordEntity.setZipFileName(cardDataFile.getOriginalFilename());
                cardRecordEntity.setTxtFileName(lineData[0]+".txt");
                cardRecordEntity.setBatchNum(lineData[0]);
                cardRecordEntity.setReceiveAddr(lineData[1]);
                cardRecordEntity.setCreatorName(user.getOperatorName());
                cardRecordEntity.setCreatorCode(user.getOperatorCode());
                cardRecordEntity.setCreateTime(DateUtils.getTime());
                batchNum2CardRecord.put(lineData[0],cardRecordEntity);
            }
            List<CardRecordEntity> cardRecordEntities = new ArrayList<CardRecordEntity>();
            if("01".equals(dataType)) { //标准卡
                File[] files = zipFile.listFiles(new CustomFileFilter.ZKCPFileFilter());
                if(files.length==0){//成品文件为空
                    files = zipFile.listFiles(new CustomFileFilter.ZKYZFileFilter());//查找预制卡
                }
                List<CardDataEntity> cardDataEntityList;
                for(File file:files){
                    long num = makeCardDataSV.countNumByTxtFile(file.getName());
                    if(num>0){
                        continue;
                    }
                    cardRecordEntity = batchNum2CardRecord.get(file.getName().substring(0,file.getName().lastIndexOf(".")));
                    cardDataEntityList =  TxtReader.readTxt(file, 2, CardDataEntity.class, mainCardFieldCols);
                    for( CardDataEntity cardDataEntity:cardDataEntityList){
                        cardDataEntity.setCardRecordEntity(cardRecordEntity);
                    }
                    cardRecordEntity.setCardDataEntities(cardDataEntityList);

                    cardRecordEntities.add(cardRecordEntity);
                }

            }else{ //衍生卡
                File[] files = zipFile.listFiles(new CustomFileFilter.ZKYSFileFilter());
                List<CardDataEntity> cardDataEntityList;
                for(File file:files) {
                    long num = makeCardDataSV.countNumByTxtFile(file.getName());
                    if(num>0){
                        continue;
                    }
                    cardRecordEntity = batchNum2CardRecord.get(file.getName().substring(0,file.getName().lastIndexOf(".")));
                    cardDataEntityList =  TxtReader.readTxt(file, 2, CardDataEntity.class, subCardFieldCols);
                    for( CardDataEntity cardDataEntity:cardDataEntityList){
                        cardDataEntity.setCardRecordEntity(cardRecordEntity);
                    }
                    cardRecordEntity.setCardDataEntities(cardDataEntityList);

                    cardRecordEntities.add(cardRecordEntity);
                }
            }
            makeCardDataSV.saveCardRecords(cardRecordEntities);
            json.put("ERRCODE", "0");
            json.put("ERRINFO", "保存正常");
        } catch (ParameterException e) {
            json.put("ERRCODE", "1");
            json.put("ERRINFO", e.getMessage());
            FileUtils.deleteAllFilesOfDir(zipFilePath);
        } catch (Exception e) {
            json.put("ERRCODE", "1");
            json.put("ERRINFO", "系统异常");
            FileUtils.deleteAllFilesOfDir(zipFilePath);
        }finally {
            if(reader!=null)
                reader.close();
            if(zipFile!=null)
                FileUtils.deleteAllFilesOfDir(zipFile);
        }
        return json;
    }
}
