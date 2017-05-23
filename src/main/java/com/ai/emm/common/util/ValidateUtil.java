package com.ai.emm.common.util;


import com.ai.emm.common.validate.*;
import com.ai.emm.common.validate.interceptor.ValidatorInterceptor;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by IntelliJ IDEA.
 * User: ZhangFengZhou
 * Date:  2015/11/20
 * Time: 15:06
 * Email:zhangfz3@asiainfo.com
 */
public enum ValidateUtil {
    MakeCardPreValidate(com.ai.emm.bean.resq.MakeCardPreValidateResq.class,
                                new NotNullValidator(
                                        new ValidateInOut("cardNo","卡号不能为空！"),
                                        new ValidateInOut("cardSerial","发卡序列号不能为空！"),
                                        new ValidateInOut("orgName","机构名称不能为空！"),
                                        new ValidateInOut("orgCode","机构编码不能为空！"),
                                        new ValidateInOut("username","用户名不能为空！"),
                                        new ValidateInOut("password","密码不能为空！")
                                                    ),
                                new InValidator(
                                        new ValidateInOut("cardSubType","卡子类型只能为00,01,02,03,04,05","00","01","02","03","04","05"),
                                        new ValidateInOut("busType","业务类型只能为01","01"),
                                        new ValidateInOut("cardKind","卡产品只能为01,02","01","02"),
                                        new ValidateInOut("operateStatus","操作状态只能为01:未知","01")
                                )
    ),
    MakeCardPostValidate(com.ai.emm.bean.resq.MakeCardPostValidateResq.class,
            new NotNullValidator(
                    new ValidateInOut("tradeSerial","交易流水号不能为空！"),
                    new ValidateInOut("chipSerial","芯片序列号不能为空！"),
                    new ValidateInOut("orgName","机构名称不能为空！"),
                    new ValidateInOut("orgCode","机构编码不能为空！"),
                    new ValidateInOut("username","用户名不能为空！"),
                    new ValidateInOut("password","密码不能为空！")
            ),
            new InValidator(
                    new ValidateInOut("operateStatus","操作状态只能为02:成功|03:失败","02","03")
            )
    ),
    DllPreValidate(com.ai.emm.bean.resq.DllPreValidateResq.class,
            new NotNullValidator(
                    new ValidateInOut("cardNo","卡号不能为空！"),
                    new ValidateInOut("cardSerial","发卡序列号不能为空！"),
                    new ValidateInOut("orgName","机构名称不能为空！"),
                    new ValidateInOut("orgCode","机构编码不能为空！"),
                    new ValidateInOut("username","用户名不能为空！"),
                    new ValidateInOut("password","密码不能为空！")
            ),
            new InValidator(
                    new ValidateInOut("cardSubType","卡子类型只能为00,01,02,03,04,05","00","01","02","03","04","05"),
                    new ValidateInOut("busType","业务类型只能为(02:发卡|03:充值|04:退费|05:擦卡)","02","03","04","05"),
                    new ValidateInOut("cardKind","卡产品只能为01,02","01","02"),
                    new ValidateInOut("operateStatus","操作状态只能为01:未知","01")
            )
    ),
    DllPostValidate(com.ai.emm.bean.resq.DllPostValidateResq.class,
            new NotNullValidator(
                    new ValidateInOut("tradeSerial","交易流水号不能为空！"),
                    new ValidateInOut("orgName","机构名称不能为空！"),
                    new ValidateInOut("orgCode","机构编码不能为空！"),
                    new ValidateInOut("username","用户名不能为空！"),
                    new ValidateInOut("password","密码不能为空！")
            ),
            new InValidator(
                    new ValidateInOut("operateStatus","操作状态只能为02:成功|03:失败","02","03")
            )
    ),
    CommonPreLogValidate(com.ai.emm.bean.resq.CommonPreLogResq.class,
            new NotNullValidator(
                    new ValidateInOut("cardNo","卡号不能为空！"),
                    new ValidateInOut("cardSerial","发卡序列号不能为空！"),
                    new ValidateInOut("orgName","机构名称不能为空！"),
                    new ValidateInOut("orgCode","机构编码不能为空！"),
                    new ValidateInOut("username","用户名不能为空！"),
                    new ValidateInOut("password","密码不能为空！")
            ),
            new InValidator(
                    new ValidateInOut("cardSubType","卡子类型只能为00,01,02,03,04,05","00","01","02","03","04","05"),
                    new ValidateInOut("busType","业务类型只能为(02:发卡|03:充值|04:退费|05:擦卡)","02","03","04","05"),
                    new ValidateInOut("cardKind","卡产品只能为01,02","01","02"),
                    new ValidateInOut("operateStatus","操作状态只能为01:未知","01")            )
    ),
    CommonPostLogValidate(com.ai.emm.bean.resq.CommonPostLogResq.class,
            new NotNullValidator(
                    new ValidateInOut("tradeSerial","交易流水号不能为空！"),
                    new ValidateInOut("orgName","机构名称不能为空！"),
                    new ValidateInOut("orgCode","机构编码不能为空！"),
                    new ValidateInOut("username","用户名不能为空！"),
                    new ValidateInOut("password","密码不能为空！")
            ),
            new InValidator(
                    new ValidateInOut("operateStatus","操作状态只能为02:成功|03:失败","02","03")
            )
    ),
    ;

    private Class<?> clz;
    private AbstractValidator[]validators;
    private ValidatorInterceptor[] validatorInterceptors;
    ValidateUtil(Class<?> clz,ValidatorInterceptor[] validatorInterceptors, AbstractValidator... validators){
        this.clz=clz;
        this.validatorInterceptors = validatorInterceptors;
        this.validators = validators;
    }
    ValidateUtil(Class<?> clz, AbstractValidator... validators){
        this.clz=clz;
        this.validators = validators;
    }
    private static ValidateUtil getValidateUtil(Class<?> clz){
        ValidateUtil[] validateUtils = ValidateUtil.values();
        for(ValidateUtil validateUtil:validateUtils){
            if(validateUtil.clz == clz){
                return validateUtil;
            }
        }
        return null;
    }
    public static <T> String validate(T bean,ValidateUtil... validateUtilParam) throws Exception {
        ValidateUtil validateUtil;
        if(validateUtilParam==null||validateUtilParam.length==0){
            validateUtil = getValidateUtil(bean.getClass());
        }else{
            validateUtil = validateUtilParam[0];
        }
        String message = null;
        if(validateUtil.validatorInterceptors!=null) {
            for (int i = 0; i < validateUtil.validatorInterceptors.length; i++) {
                ValidatorInterceptor validatorInterceptor = validateUtil.validatorInterceptors[i];
                message = validatorInterceptor.preHandle(bean);
                if (message != null) {
                    return message;
                }
            }
        }
        for(AbstractValidator validator : validateUtil.validators){
            message = validator.validate(bean);
            if(message!=null){
                return message;
            }
        }
        if(validateUtil.validatorInterceptors!=null) {
            for (int i = validateUtil.validatorInterceptors.length - 1; i >= 0; i--) {
                ValidatorInterceptor validatorInterceptor = validateUtil.validatorInterceptors[i];
                validatorInterceptor.postHandle(bean);
            }
        }
        return message;
    }
}
