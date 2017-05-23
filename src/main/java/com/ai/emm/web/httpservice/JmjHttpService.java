package com.ai.emm.web.httpservice;

import com.ai.emm.bean.resp.*;
import com.ai.emm.bean.resq.*;
import com.ai.emm.common.util.*;
import com.ai.emm.domain.CardDataEntity;
import com.ai.emm.domain.LogRecordEntity;
import com.ai.emm.domain.ServiceLogEntity;
import com.ai.emm.ecard.domain.CardPresendUser;
import com.ai.emm.ecard.domain.MoneyRecord;
import com.ai.emm.ecard.service.CardCardSV;
import com.ai.emm.ecard.domain.CardCard;
import com.ai.emm.exception.DBException;
import com.ai.emm.exception.ParameterException;
import com.ai.emm.service.CommonSV;
import com.ai.emm.service.JmjHttpServiceSV;
import com.ai.emm.service.MakeCardDataSV;
import com.ai.emm.service.ServiceLogSV;
import com.ai.emm.servicefacade.service.RestClient;
import com.ai.emm.web.util.PermissionUtils;
import com.ai.emm.web.util.TradeUtil;
import com.ai.emm.web.util.UserUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Walter on 2016/12/29.
 * JmjHttpService
 */
@RestController
@RequestMapping("/services/commonCard")
public class JmjHttpService {

    @Autowired
    private JmjHttpServiceSV jmjHttpServiceSV;
    @Autowired
    private CardCardSV cardCardSV;
    @Autowired
    private RestClient restClient;
    @Autowired
    private MakeCardDataSV cardDataSV;

    @Autowired
    private ServiceLogSV serviceLogSV;

    @Autowired
    private CommonSV commonSV;

    @Value("${validateJmjUser}")
    private String validateJmjUser;

    private Logger logger = LoggerFactory.getLogger(JmjHttpService.class);
    /*
    * 动态库调用前置机前，调用该服务，进行必要的校验，及日志记录
    * */
    @RequestMapping("/dllPreValidate.ajax")
    public DllPreValidateResp dllPreValidate(@RequestBody DllPreValidateResq resq){
        DllPreValidateResp resp = new DllPreValidateResp();
        Date date = DateUtils.getTime();
        CardCard card =null;
        JmjUserResponse userResponse = null;
        List<CardDataEntity> cardDataEntities = null;
        long logId = 0;
        ServiceLogEntity logBean = null;
        try {
            logId = commonSV.getIdBySeqName("SEQ_SERVICE_LOG");
            logBean = new ServiceLogEntity();
            logBean.setServiceName("dllPreValidate.ajax");
            logBean.setStartTime(new Timestamp(System.currentTimeMillis()));
            logBean.setServiceReq(JsonUtil.toJson(resq));
            logBean.setServiceId(logId);
            serviceLogSV.save(logBean);
            card = cardCardSV.findCardCardRecord(resq.getCardNo());
            cardDataEntities = cardDataSV.getListByCardNoAndCardSerial(resq.getCardNo(),resq.getCardSerial());
            if("02".equals(resq.getBusType())||"04".equals(resq.getBusType())){
                if("02".equals(resq.getBusType())){//发卡
                    if("00".equals(resq.getCardSubType())) {//卡管发标准卡，校验制卡数据
                        userResponse = UserUtil.getXhUser();
                        if (cardDataEntities == null || cardDataEntities.size() == 0) {
                            throw new Exception("制卡数据不存在，无法发卡");
                        }
                    }else{
                        userResponse = UserUtil.getQyUser();
                    }
                }else {//非发卡
                    userResponse = UserUtil.getQyUser();
                    if(card==null){
                        throw new Exception("卡片不存在！");
                    }
                }
            }else{
                String invalidMessage = ValidateUtil.validate(resq);
                if(invalidMessage !=null) {
                    throw new ParameterException(invalidMessage);
                }
            }
            LogRecordEntity logRecordEntity = new LogRecordEntity();
            try {
                if(userResponse==null) {  //如果为空的时候进行校验
                    PermissionUtils.validateJmjUser(resq.getOrgCode(),resq.getUsername(),resq.getPassword());
                    logRecordEntity.setOrgName(resq.getOrgName());
                    logRecordEntity.setOrgCode(resq.getOrgCode());
                }else{
                    logRecordEntity.setOrgName(userResponse.getOrgName());
                    logRecordEntity.setOrgCode(userResponse.getOrgCode());
                }
            } catch (IOException e) {
                logger.error("dllPreValidate.ajax验证身份异常:"+e.getMessage());
                throw new IOException("Webservice Server can't response correctly");
            }

            logRecordEntity.setCardName(resq.getCardName());
            logRecordEntity.setIdNo(resq.getIdNo());
            logRecordEntity.setCardNo(resq.getCardNo());
            logRecordEntity.setCardSerial(resq.getCardSerial());
            logRecordEntity.setChipSerial(resq.getChipSerial());
            logRecordEntity.setDaughterType(resq.getCardSubType());
            logRecordEntity.setPsamNo(resq.getPsamNo());
            logRecordEntity.setBusinessType(resq.getBusType());
            logRecordEntity.setCardType(resq.getCardKind());
            logRecordEntity.setOperateStatus(resq.getOperateStatus());
            logRecordEntity.setOperateDate(date);
            String tradeSerial = TradeUtil.getTradeSerial(resq.getCardSerial(),resq.getBusType());
            resp.setTradeSerial(tradeSerial);
            logRecordEntity.setTradeSerial(tradeSerial);
            jmjHttpServiceSV.save(logRecordEntity);
            resp.setErrMsg("成功");
            resp.setResultCode("0");
        }catch (DBException e) {
            resp.setResultCode("1");
            resp.setErrMsg("数据库连接异常！");
            logger.error("dllPreValidate.ajax=>数据库连接异常：",e);
        } catch (ParameterException e) {
            resp.setResultCode("1");
            resp.setErrMsg(e.getMessage());
            logger.error("dllPreValidate.ajax=>参数异常：",e);
        } catch (Exception e) {
            resp.setResultCode("1");
            resp.setErrMsg(e.getMessage());
            logger.error("dllPreValidate.ajax=>：",e);
        } finally {
            try {
                logBean = serviceLogSV.findOne(logId);
                logBean.setEndTime(new Timestamp(System.currentTimeMillis()));
                logBean.setServiceResp(JsonUtil.toJson(resp));
                logBean.setTotalTime(String.valueOf(logBean.getEndTime().getTime()-logBean.getStartTime().getTime()));
                serviceLogSV.save(logBean);
            } catch (Exception e) {
                logger.error("写日志失败：",e);
            }
            return resp;
        }
    }

    /*
     * 动态库写卡后，通知加密机中间件操作状态
     */
    @RequestMapping("/dllPostValidate.ajax")
    public DllPostValidateResp dllPostValidate(@RequestBody DllPostValidateResq resq){
        LogRecordEntity logRecordEntity=null;
        DllPostValidateResp resp = new DllPostValidateResp();
        long logId = 0;
        ServiceLogEntity logBean = null;
        try {
            logId = commonSV.getIdBySeqName("SEQ_SERVICE_LOG");
            logBean = new ServiceLogEntity();
            logBean.setServiceName("dllPostValidate.ajax");
            logBean.setStartTime(new Timestamp(System.currentTimeMillis()));
            logBean.setServiceReq(JsonUtil.toJson(resq));
            logBean.setServiceId(logId);
            serviceLogSV.save(logBean);
            logRecordEntity = jmjHttpServiceSV.selectRecord(resq.getTradeSerial());
            if (logRecordEntity == null) {
                throw new Exception("无此交易流水号");
            }
            if("02".equals(logRecordEntity.getBusinessType())||"04".equals(logRecordEntity.getBusinessType())){
            }else{
                String invalidMessage = ValidateUtil.validate(resq);
                if(invalidMessage !=null) {
                    throw new ParameterException(invalidMessage);
                }
                PermissionUtils.validateJmjUser(resq.getOrgCode(),resq.getUsername(),resq.getPassword());
            }
            logRecordEntity.setOperateStatus(resq.getOperateStatus());
            logRecordEntity.setUpdateDate(DateUtils.getTime());
            jmjHttpServiceSV.update(logRecordEntity);
            resp.setErrMsg("成功");
            resp.setResultCode("0");
        }catch (DBException e){
            resp.setResultCode("1");
            resp.setErrMsg("数据库连接异常");
            logger.error("dllPostValidate.ajax=>数据库连接异常：",e);
        } catch (ParameterException e) {
            resp.setResultCode("1");
            resp.setErrMsg(e.getMessage());
            logger.error("dllPostValidate.ajax=>参数异常：",e);
        } catch (Exception e) {
            resp.setResultCode("1");
            resp.setErrMsg(e.getMessage());
            logger.error("dllPostValidate.ajax=>：",e);
        } finally {
            try {
                logBean = serviceLogSV.findOne(logId);
                logBean.setEndTime(new Timestamp(System.currentTimeMillis()));
                logBean.setServiceResp(JsonUtil.toJson(resp));
                logBean.setTotalTime(String.valueOf(logBean.getEndTime().getTime()-logBean.getStartTime().getTime()));
                serviceLogSV.save(logBean);
            } catch (Exception e) {
                logger.error("写日志失败：",e);
            }
            return resp;
        }
    }

    /**
     * 制卡数据前置校验
     *
     * @param resq
     * @return
     * @throws Exception
     */
    @RequestMapping("/makeCardPreValidate.ajax")
    public MakeCardPreValidateResp makeCardPreValidate(@RequestBody MakeCardPreValidateResq resq){
        MakeCardPreValidateResp resp = new MakeCardPreValidateResp();
        Date date = DateUtils.getTime();
        long logId = 0;
        ServiceLogEntity logBean = null;
        try {
            logId = commonSV.getIdBySeqName("SEQ_SERVICE_LOG");
            logBean = new ServiceLogEntity();
            logBean.setServiceName("makeCardPreValidate.ajax");
            logBean.setStartTime(new Timestamp(System.currentTimeMillis()));
            logBean.setServiceReq(JsonUtil.toJson(resq));
            logBean.setServiceId(logId);
            serviceLogSV.save(logBean);
            String invalidMessage = ValidateUtil.validate(resq);
            if(invalidMessage !=null) {
                throw new ParameterException(invalidMessage);
            }
            PermissionUtils.validateJmjUser(resq.getOrgCode(),resq.getUsername(),resq.getPassword());
            List<CardDataEntity> cardList = cardDataSV.getListByCardNoAndCardSerial(resq.getCardNo(),resq.getCardSerial());
            if (cardList !=null&&cardList.size()>0) {
                throw new Exception("制卡数据不存在，无法制卡！");
            }
            CardDataEntity cardDataEntity = cardList.get(0);
            cardDataEntity.setStatus("01");
            cardDataSV.save(cardDataEntity);
            LogRecordEntity logRecordEntity = new LogRecordEntity();
            logRecordEntity.setCardName(resq.getCardName());
            logRecordEntity.setIdNo(resq.getIdNo());
            logRecordEntity.setCardNo(resq.getCardNo());
            logRecordEntity.setCardSerial(resq.getCardSerial());
            logRecordEntity.setChipSerial(resq.getChipSerial());
            logRecordEntity.setDaughterType(resq.getCardSubType());
            logRecordEntity.setPsamNo(resq.getPsamNo());
            logRecordEntity.setBusinessType(resq.getBusType());
            logRecordEntity.setCardType(resq.getCardKind());
            logRecordEntity.setOperateStatus(resq.getOperateStatus());
            logRecordEntity.setOrgName(resq.getOrgName());
            logRecordEntity.setOrgCode(resq.getOrgCode());
            logRecordEntity.setOperateDate(date);

            String tradeSerial = TradeUtil.getTradeSerial(resq.getCardSerial(),resq.getBusType());
            logRecordEntity.setTradeSerial(tradeSerial);
            jmjHttpServiceSV.save(logRecordEntity);
             //2、连接加密机进行加密操作
            try {
                List<MakeCardPreValidateResq.ResqDatasBean> resqDatals = new ArrayList<MakeCardPreValidateResq.ResqDatasBean>();
                List<MakeCardPreValidateResp.RespDatasBean> respDatals = new ArrayList<MakeCardPreValidateResp.RespDatasBean>();
                resqDatals = resq.getResqDatas();
                for(int index=0;index<resqDatals.size();index++){
                    String hexStr2 = resqDatals.get(index).getResqData();
                    int length = hexStr2.length();
                    byte[] writeByte2 =  CodeUtils.hexString2Bytes(hexStr2);
                    byte[] readByte2 = new byte[length];
                    ConnJmj(writeByte2,readByte2);
                    String readStr2 = CodeUtils.byte2HexString(readByte2);
                    MakeCardPreValidateResp.RespDatasBean respDatasBean = new MakeCardPreValidateResp.RespDatasBean();
                    respDatasBean.setRespData(DESUtil.encode(readStr2));
                    respDatals.add(index,respDatasBean);
                }
                resp.setResultCode("0");
                resp.setErrMsg("成功");
                resp.setTradeSerial(tradeSerial);
                resp.setRespDatas(respDatals);
            }catch (Exception Ex){
                logger.error("makeCardPreValidate.ajax加密机请求失败:"+Ex.getMessage());
                throw new Exception("加密机请求失败");
            }
        }catch (DBException e){
            resp.setResultCode("1");
            resp.setErrMsg("数据库操作异常");
            logger.error("makeCardPreValidate.ajax=>数据库连接异常：",e);
        }catch (ParameterException e) {
            resp.setResultCode("1");
            resp.setErrMsg(e.getMessage());
            logger.error("makeCardPreValidate.ajax=>参数异常：",e);
        } catch (Exception e) {
            resp.setResultCode("1");
            resp.setErrMsg(e.getMessage());
            logger.error("makeCardPreValidate.ajax：",e);
        }finally {
            try {
                logBean = serviceLogSV.findOne(logId);
                logBean.setEndTime(new Timestamp(System.currentTimeMillis()));
                logBean.setServiceResp(JsonUtil.toJson(resp));
                logBean.setTotalTime(String.valueOf(logBean.getEndTime().getTime()-logBean.getStartTime().getTime()));
                serviceLogSV.save(logBean);
            } catch (Exception e) {
                logger.error("写日志失败：",e);
            }
            return resp;
        }
    }

    /*
     * 动态库写卡后，通知加密机中间件操作状态
     */
    @RequestMapping("/makeCardPostValidate.ajax")
    public MakeCardPostValidateResp makeCardPostValidate(@RequestBody MakeCardPostValidateResq  resq){
        MakeCardPostValidateResp resp = new MakeCardPostValidateResp();
        long logId = 0;
        ServiceLogEntity logBean = null;
        try {
            logId = commonSV.getIdBySeqName("SEQ_SERVICE_LOG");
            logBean = new ServiceLogEntity();
            logBean.setServiceName("makeCardPostValidate.ajax");
            logBean.setStartTime(new Timestamp(System.currentTimeMillis()));
            logBean.setServiceReq(JsonUtil.toJson(resq));
            logBean.setServiceId(logId);
            serviceLogSV.save(logBean);
            String tradeSerial = resq.getTradeSerial();
            String invalidMessage = ValidateUtil.validate(resq);
            if(invalidMessage !=null) {
                throw new ParameterException(invalidMessage);
            }
            LogRecordEntity logRecordEntity = jmjHttpServiceSV.selectRecord(tradeSerial);
            if (logRecordEntity == null) {
                throw new Exception("无此交易流水号");
            }
            PermissionUtils.validateJmjUser(resq.getOrgCode(),resq.getUsername(),resq.getPassword());
            logRecordEntity.setOperateStatus(resq.getOperateStatus());
            logRecordEntity.setChipSerial(resq.getChipSerial());
            logRecordEntity.setUpdateDate(new Date());
            jmjHttpServiceSV.update(logRecordEntity);

            cardDataSV.updateCardDataByChipSerial(resq.getChipSerial(),logRecordEntity.getCardNo(),logRecordEntity.getCardSerial());
            resp.setErrMsg("成功");
            resp.setResultCode("0");
        } catch (DBException e) {
            resp.setResultCode("1");
            resp.setErrMsg("数据库操作异常");
            logger.error("makeCardPostValidate.ajax=>数据库连接异常：",e);
        }catch (ParameterException e) {
            resp.setResultCode("1");
            resp.setErrMsg(e.getMessage());
            logger.error("makeCardPostValidate.ajax=>参数异常：",e);
        } catch (Exception e) {
            resp.setResultCode("1");
            resp.setErrMsg(e.getMessage());
            logger.error("makeCardPostValidate.ajax：",e);
        } finally {
            try {
                logBean = serviceLogSV.findOne(logId);
                logBean.setEndTime(new Timestamp(System.currentTimeMillis()));
                logBean.setServiceResp(JsonUtil.toJson(resp));
                logBean.setTotalTime(String.valueOf(logBean.getEndTime().getTime()-logBean.getStartTime().getTime()));
                serviceLogSV.save(logBean);
            } catch (Exception e) {
                logger.error("写日志失败：",e);
            }
            return resp;
        }
    }



    /**
     * 连接加密机校验MAC
     *
     * @throws Exception
     */
    private static void ConnJmj(byte[] writeByte,byte[] readByte) throws Exception{

        String EncryptionMachineIp = PropertiesUtils.getContextProperty("jmj.ip");
        int EncryptionMachinePort = Integer.parseInt(PropertiesUtils.getContextProperty("jmj.port"));
        Socket s1 = new Socket(EncryptionMachineIp, EncryptionMachinePort);
        // 打开输出流
        OutputStream os = s1.getOutputStream();
        // 封装输出流
        DataOutputStream dos = new DataOutputStream(os);
        // 打开输入流
        InputStream is = s1.getInputStream();
        // 封装输入流
        DataInputStream dis = new DataInputStream(is);
        dos.write(writeByte);
        // 转发消息
        dis.read(readByte);
        // 关闭打开的socket对象
        dos.close();
        s1.close();
    }


    public static  void main(String []args)throws Exception{
        String hexStr2 = "wewewewq2";
        System.out.println(hexStr2);
        int length = hexStr2.getBytes().length;
        byte[] writeByte2 =  CodeUtils.hexString2Bytes(hexStr2);
        byte[] readByte2 = new byte[length];
        ConnJmj(writeByte2,readByte2);
        String readStr2 = CodeUtils.byte2HexString(readByte2);
        System.out.println(readStr2);
    }

    @RequestMapping("/commonPreLog.ajax")
    public CommonPreLogResp commonPreLog(@RequestBody CommonPreLogResq resq) throws Exception {
        CommonPreLogResp resp = new CommonPreLogResp();
        Date date = DateUtils.getTime();
        long logId = 0;
        ServiceLogEntity logBean = null;
        try {
            logId = commonSV.getIdBySeqName("SEQ_SERVICE_LOG");
            logBean = new ServiceLogEntity();
            logBean.setServiceName("commonPreLog.ajax");
            logBean.setStartTime(new Timestamp(System.currentTimeMillis()));
            logBean.setServiceReq(JsonUtil.toJson(resq));
            logBean.setServiceId(logId);
            serviceLogSV.save(logBean);
            String invalidMessage = ValidateUtil.validate(resq);
            if(invalidMessage !=null) {
                throw new ParameterException(invalidMessage);
            }
            PermissionUtils.validateJmjUser(resq.getOrgCode(),resq.getUsername(),resq.getPassword());

            CardCard card = cardCardSV.findCardCardRecord(resq.getCardNo());
            if (card == null) {
                throw new Exception("卡或账户不存在");
            }
            LogRecordEntity logRecordEntity = new LogRecordEntity();
            logRecordEntity.setCardName(resq.getCardName());
            logRecordEntity.setIdNo(resq.getIdNo());
            logRecordEntity.setCardNo(resq.getCardNo());
            logRecordEntity.setCardSerial(resq.getCardSerial());
            logRecordEntity.setChipSerial(resq.getChipSerial());
            logRecordEntity.setDaughterType(resq.getCardSubType());
            logRecordEntity.setPsamNo(resq.getPsamNo());
            logRecordEntity.setBusinessType(resq.getBusType());
            logRecordEntity.setCardType(resq.getCardKind());
            logRecordEntity.setOperateStatus(resq.getOperateStatus());
            logRecordEntity.setOrgName(resq.getOrgName());
            logRecordEntity.setOrgCode(resq.getOrgCode());
            logRecordEntity.setOperateDate(date);

            String tradeSerial = TradeUtil.getTradeSerial(resq.getCardSerial(),resq.getBusType());
            if(StringUtils.isNotBlank(resq.getTradeSerial())){
                tradeSerial = resq.getTradeSerial();
            }
            resp.setErrMsg("成功");
            resp.setResultCode("0");
            resp.setTradeSerial(tradeSerial);
            logRecordEntity.setTradeSerial(tradeSerial);
            jmjHttpServiceSV.save(logRecordEntity);

        }catch (DBException e) {
            resp.setResultCode("1");
            resp.setErrMsg("数据库操作异常");
            logger.error("commonPreLog.ajax=>数据库连接异常：",e);
        }catch (ParameterException e) {
            resp.setResultCode("1");
            resp.setErrMsg(e.getMessage());
            logger.error("commonPreLog.ajax=>参数异常：",e);
        } catch (Exception e) {
            resp.setResultCode("1");
            resp.setErrMsg(e.getMessage());
            logger.error("commonPreLog.ajax：",e);
        } finally {
            try {
                logBean = serviceLogSV.findOne(logId);
                logBean.setEndTime(new Timestamp(System.currentTimeMillis()));
                logBean.setServiceResp(JsonUtil.toJson(resp));
                logBean.setTotalTime(String.valueOf(logBean.getEndTime().getTime()-logBean.getStartTime().getTime()));
                serviceLogSV.save(logBean);
            } catch (Exception e) {
                logger.error("写日志失败：",e);
            }
            return resp;
        }
    }

    /*
     * 动态库写卡后，通知加密机中间件操作状态
     */
    @RequestMapping("/commonPostLog.ajax")
    public CommonPostLogResp commonPostLog(@RequestBody CommonPostLogResq resq) throws Exception {
        LogRecordEntity logRecordEntity=null;
        CommonPostLogResp resp = new CommonPostLogResp();
        long logId = 0;
        ServiceLogEntity logBean = null;
        try {
            logId = commonSV.getIdBySeqName("SEQ_SERVICE_LOG");
            logBean = new ServiceLogEntity();
            logBean.setServiceName("commonPostLog.ajax");
            logBean.setStartTime(new Timestamp(System.currentTimeMillis()));
            logBean.setServiceReq(JsonUtil.toJson(resq));
            logBean.setServiceId(logId);
            serviceLogSV.save(logBean);
            String invalidMessage = ValidateUtil.validate(resq);
            if(invalidMessage !=null) {
                throw new ParameterException(invalidMessage);
            }
            PermissionUtils.validateJmjUser(resq.getOrgCode(),resq.getUsername(),resq.getPassword());

            String tradeSerial = resq.getTradeSerial();
            logRecordEntity = jmjHttpServiceSV.selectRecord(tradeSerial);//需要改，可能查出多条记录，比如自助机发卡
            if (logRecordEntity == null) {
                throw new Exception("无此交易流水号");
            }
            //自助机发卡
            if("02".equals(logRecordEntity.getBusinessType())&&StringUtils.isBlank(logRecordEntity.getIdNo())&&StringUtils.isBlank(logRecordEntity.getCardName())) {
                CardPresendUser cardPresendUser = cardCardSV.findCardPresendUserByMoneyRecordSerial(tradeSerial);
                MoneyRecord moneyRecord = null;
                if(cardPresendUser!=null) {
                    logRecordEntity.setCardName(cardPresendUser.getName());
                    logRecordEntity.setIdNo(cardPresendUser.getIdNo());
                }else{
                    moneyRecord = cardCardSV.findMoneyRecordByMoneyRecordSerial(tradeSerial);
                    if(moneyRecord != null) {
                        CardCard card = cardCardSV.findCardCardRecord(moneyRecord.getCardNo());
                        if (card != null) {
                            logRecordEntity.setCardName(card.getName());
                            logRecordEntity.setIdNo(card.getIdNo());
                        }
                    }
                }
                if(StringUtils.isBlank(logRecordEntity.getPsamNo())) {
                    if(moneyRecord == null){
                        moneyRecord = cardCardSV.findMoneyRecordByMoneyRecordSerial(tradeSerial);
                    }
                    if (moneyRecord != null) {
                        logRecordEntity.setPsamNo(moneyRecord.getTerminalNo());
                    }
                }
            }

            logRecordEntity.setOperateStatus(resq.getOperateStatus());
            logRecordEntity.setUpdateDate(new Date());
            jmjHttpServiceSV.update(logRecordEntity);
            resp.setErrMsg("成功");
            resp.setResultCode("0");
        } catch (DBException e) {
            resp.setResultCode("1");
            resp.setErrMsg("数据库操作异常");
            logger.error("makeCardPostValidate.ajax=>数据库连接异常：",e);
        }catch (ParameterException e) {
            resp.setResultCode("1");
            resp.setErrMsg(e.getMessage());
            logger.error("makeCardPostValidate.ajax=>参数异常：",e);
        } catch (Exception e) {
            resp.setResultCode("1");
            resp.setErrMsg(e.getMessage());
            logger.error("makeCardPostValidate.ajax：",e);
        } finally {
            try {
                logBean = serviceLogSV.findOne(logId);
                logBean.setEndTime(new Timestamp(System.currentTimeMillis()));
                logBean.setServiceResp(JsonUtil.toJson(resp));
                logBean.setTotalTime(String.valueOf(logBean.getEndTime().getTime()-logBean.getStartTime().getTime()));
                serviceLogSV.save(logBean);
            } catch (Exception e) {
                logger.error("写日志失败：",e);
            }
            return resp;
        }
    }
}

