package com.ai.emm.common.util;

import java.io.File;

/**
 * 系统常量
 * @author fangll
 *
 */
public final class Constants {
	public static final String USER_DEFAULT_PWD = "e10adc3949ba59abbe56e057f20f883e";   //新建用户默认密码,123456
	public static final String SESSION_USER = "_USER_INFO_MAP_";            //存session中管理平台用户信息
	public static final String SESSION_USER_OBJ = "_USER_INFO";            //存session中管理平台用户信息
	public static final String SESSION_MENU = "_USER_MENU";
	public static final String SESSION_ORG = "_USER_ORG_JSON";
	public static final String SESSION_ORG_OBJ = "_USER_ORG";
	public static final String SESSION_OPERATOR2ORG = "_OPERATOR2ORG";
	public static final String SESSION_LOGIN_SYS = "USER_LOGIN_SYS_";    //登录的系统
	public static final String SESSION_ROOT_ORG = "ECARD_ROOT_ORG_";    //登录的系统


	public static final String SESSION_JMJUSER = "_JMJ_USER";
	public static final String SESSION_QY_JMJUSER = "_QY_JMJ_USER";
	public static final String SESSION_XH_JMJUSER = "_XH_JMJ_USER";

	public static final String SESSION_CARDMGT_USERNAME = "_CARDMGT_USERNAME";

	public static final String SESSION_LOGIN_SYS_COM = "0";    //系统默认
	public static final String SESSION_LOGIN_CARD_MANAGER = "1";    //一卡通
	public static final String SESSION_LOGIN_HEALTH_ARCHIVE = "2";    //健康档案
	public static final String SESSION_LOGIN_DATA_PLATFORM = "3";    //数据交换平台
	public static final String SESSION_LOGIN_YBJC = "4";    //数据交换平台
	public static final String SESSION_LOGIN_JYFX = "5";    //基药分析系统
	
	public static final String SESSION_LOGIN_BROWSER = "USER_LOGIN_BROWSER_";    //外系统调阅健康浏览器系统标志
	
	public static final String CLIENT_SESSION_USER = "_USER_INFO_MAP_";     //存session中client用户信息,合并为同一session
	public static final String WEB_CLIENT_SESSION_USER = "_USER_INFO_MAP_"; //存session中web client用户信息,合并为同一session
	public static final String SESSION_USER_AREA = "_USER_AREA_MAP_";  //存session中用户对应的dictarea对象信息
	public static final String PRI_MENU = "_PRI_MENU";                  //按钮权限
	public static final String LOGIN_TIME_OUT = "_LOGIN_TIME_OUT_"; //登录过期标识
	public static final String LOGINPARAM = "_LOGIN_PARAM_";        //存session中登录页面参数
	public static final String VIEWONLY = "_VIEW_ONLY_";			//只有查看权限，没有管理权限
	public static final String LAST_PAGE = "_LAST_PAGE_";           //记录最后一次访问页url

	public static final int pageSize = 30; //列表每页显示的条数
	public static final int ATTACH_BUFFER_SIZE = 16*1024;           //上传、下载文件的缓冲大小
	
	//导出数据默认限制行数
    public static final int EXP_LINE_LIMIT = 20000;
    
    ///导出Excel的参数
    public static final String RESULT_EXP_EXCEL = "EXP_EXCEL";
    public static final String ATTR_EXP_EXCEL = "datas";
    
    //交易相关参数
    public static final String SYS_OPERATOR = "SYS";         //系统自动处理账号
    public static final String OP_TYPE_INCOME = "1";         //收入标识
    public static final String OP_TYPE_SPEND = "2";          //支出标识 
 
    //交易科目
    public static final String TRADE_SUBJECT_0 = "0";          //会员卡激活预存金额
    public static final String TRADE_SUBJECT_1 = "1";          //银行充值
    public static final String TRADE_SUBJECT_2 = "2";          //节假日补贴福利 
    public static final String TRADE_SUBJECT_3 = "3";          //补、退订单货款差价 
    public static final String TRADE_SUBJECT_4 = "4";          //人工调账
    public static final String TRADE_SUBJECT_5 = "5";          //订单扣款
	//员工岗位
	public static final String STATION_CODE_COMMON = "EMM_COMMON_TELLER";          //普通柜员
	public static final String STATION_CODE_MANAGER = "EMM_MANAGER";          //部门主管
	public static final String STATION_CODE_ADMIN = "EMM_ADMIN";          //管理员
	public static final String SESSION_OPERATOR_STATION = "_OPERATOR_STATION";



	//钱箱操作交易类型
	public static final int TRADE_TYPE_1 = 1;          //现金上缴
	public static final int TRADE_TYPE_2 = 2;          //现金上缴入库
	public static final int TRADE_TYPE_3 = 3;          //发放备用金
	public static final int TRADE_TYPE_4 = 4;          //领取备用金
	public static final int TRADE_TYPE_5 = 5;          //现金调出
	public static final int TRADE_TYPE_6 = 6;          //现金调入
	public static final int TRADE_TYPE_7 = 7;          //充值
	public static final int TRADE_TYPE_8 = 8;          //充值撤销
	public static final int TRADE_TYPE_9 = 9;          //退费
	public static final int TRADE_TYPE_10 = 10;          //消费
	public static final int TRADE_TYPE_11 = 11;          //消费撤销
	public static final int TRADE_TYPE_12 = 12;          //消费取消
	public static final int TRADE_TYPE_13 = 13;          //发卡押金
	public static final int TRADE_TYPE_14 = 14;          //余额转出
	public static final int TRADE_TYPE_15 = 15;          //余额转入
	public static final int TRADE_TYPE_16 = 16;          //退押金
    //钱箱操作现金流向
	public static final int CASHFLOW_1 = 1;          //支出
	public static final int CASHFLOW_2 = 2;          //收入
	
	public static final String CURRENT_CITY_ID = "6104";  //当前城市地区编码  6104-咸阳
	public static final String CSV_BUSINESS_TYPE_DICT_NAME = "CSV_BUSINESS_ACCEPT_BUSINESS_TYPE";
	public static final String CSV_SERVICE_TYPE_DICT_NAME = "CSV_MERCHANT_SERVICE_TYPE";
	public static final String CSV_CHECK_STATUS_DICT_NAME = "MERCHANT_CHECK_STATUS";
	//用户类型
	public static final String USER_TYPE_T = "MERCHANT";           //特约商户用户
	public static final String USER_TYPE_P = "ORDINARY";           //普通用户
	
	//文件上传地址
	public static final String NEWS_IMG_PATH = "CsvNews"+File.separator+"Images"+File.separator;  //新闻:图片
	public static final String NEWS_DOC_PATH = "CsvNews"+File.separator+"Html"+File.separator;  //新闻:html
	public static final String ATTACHFILE_PATH = "CsvMerchant"+File.separator+"AttachFile"+File.separator;  //特约商户: 证件图片
	public static final String MERCHANTPHOTO_PATH = "CsvMerchant"+File.separator+"MerchantPhoto"+File.separator;  //特约商户: 商户照片
	public static final String THUMBPHOTO_PATH = "CsvMerchantActivity"+File.separator+"ThumbPhoto"+File.separator;  //商户活动：缩略图地址
	public static final String DISCOUNTPHOTO_PATH = "CsvMerchantActivity"+File.separator+"DiscountPhoto"+File.separator;  //商户活动：折扣图地址
	public static final String DETAILPHOTO_PATH = "CsvMerchantActivity"+File.separator+"DetailPhoto"+File.separator;  //商户活动：折扣图地址
	public static final String SERVICE_TOUCH_PATH = "CsvService"+File.separator+"ServiceTouch"+File.separator;  //服务范围： 触发图片
	public static final String SERVICE_OFF_PATH = "CsvService"+File.separator+"ServiceOff"+File.separator;  //服务范围： 未触发图片
	public static final String NET_POINT_PATH = "NetPoint"+File.separator ;  //网点图片

	public static final float CARD_MAX_AMOUNT = 1000;          //收入

	public static final String SESSION_STATION_RESOURCES = "_STATION_RESOURCES";
}