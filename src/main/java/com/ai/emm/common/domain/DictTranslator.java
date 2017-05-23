package com.ai.emm.common.domain;
/**
 * Created by IntelliJ IDEA.
 * User: ZhangFengZhou
 * Date:  2015/9/17
 * Time: 16:46
 * Email:zhangfengzhou@asiainfo.com
 */

public class DictTranslator {
    private String valueFiled;
    private String dictType;
    private String textField;

    public DictTranslator(String valueFiled, String dictType, String textField) {
        this.valueFiled = valueFiled;
        this.dictType = dictType;
        this.textField = textField;
    }

    public String getValueFiled() {
        return valueFiled;
    }

    public void setValueFiled(String valueFiled) {
        this.valueFiled = valueFiled;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getTextField() {
        return textField;
    }

    public void setTextField(String textField) {
        this.textField = textField;
    }
}
