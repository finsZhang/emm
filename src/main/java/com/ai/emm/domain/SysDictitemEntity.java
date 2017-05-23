package com.ai.emm.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

/**
 * Created by IntelliJ IDEA.
 * User: zhangfz3
 * Date: 2017/1/16
 * Time: 15:23
 * Tel:18665598790
 * Email:zhangfz3@asiainfo.com
 */
@Entity
@Table(name = "SYS_DICTITEM", schema = "EMM", catalog = "")
@IdClass(SysDictitemEntityPK.class)
public class SysDictitemEntity implements Serializable{
    private String dictName;
    private String itemName;
    private String itemNo;
    private String parentItemNo;
    private Long itemOrder;
    private String itemState;
    private Long itemLevel;
    private String itemDesc;
    private String itemNamePy;
    private String itemNamePycap;
    private Time createDate;
    private String createUser;
    private String mappingItemNo;
    private String mappingDictName;

    @Id
    @Column(name = "DICT_NAME", nullable = false, length = 48)
    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    @Basic
    @Column(name = "ITEM_NAME", nullable = true, length = 200)
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Id
    @Column(name = "ITEM_NO", nullable = false, length = 50)
    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    @Basic
    @Column(name = "PARENT_ITEM_NO", nullable = true, length = 50)
    public String getParentItemNo() {
        return parentItemNo;
    }

    public void setParentItemNo(String parentItemNo) {
        this.parentItemNo = parentItemNo;
    }

    @Basic
    @Column(name = "ITEM_ORDER", nullable = true, precision = 0)
    public Long getItemOrder() {
        return itemOrder;
    }

    public void setItemOrder(Long itemOrder) {
        this.itemOrder = itemOrder;
    }

    @Basic
    @Column(name = "ITEM_STATE", nullable = true, length = 1)
    public String getItemState() {
        return itemState;
    }

    public void setItemState(String itemState) {
        this.itemState = itemState;
    }

    @Basic
    @Column(name = "ITEM_LEVEL", nullable = true, precision = 0)
    public Long getItemLevel() {
        return itemLevel;
    }

    public void setItemLevel(Long itemLevel) {
        this.itemLevel = itemLevel;
    }

    @Basic
    @Column(name = "ITEM_DESC", nullable = true, length = 200)
    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    @Basic
    @Column(name = "ITEM_NAME_PY", nullable = true, length = 200)
    public String getItemNamePy() {
        return itemNamePy;
    }

    public void setItemNamePy(String itemNamePy) {
        this.itemNamePy = itemNamePy;
    }

    @Basic
    @Column(name = "ITEM_NAME_PYCAP", nullable = true, length = 30)
    public String getItemNamePycap() {
        return itemNamePycap;
    }

    public void setItemNamePycap(String itemNamePycap) {
        this.itemNamePycap = itemNamePycap;
    }

    @Basic
    @Column(name = "CREATE_DATE", nullable = true)
    public Time getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Time createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "CREATE_USER", nullable = true, length = 30)
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Basic
    @Column(name = "MAPPING_ITEM_NO", nullable = true, length = 50)
    public String getMappingItemNo() {
        return mappingItemNo;
    }

    public void setMappingItemNo(String mappingItemNo) {
        this.mappingItemNo = mappingItemNo;
    }

    @Basic
    @Column(name = "MAPPING_DICT_NAME", nullable = true, length = 48)
    public String getMappingDictName() {
        return mappingDictName;
    }

    public void setMappingDictName(String mappingDictName) {
        this.mappingDictName = mappingDictName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysDictitemEntity that = (SysDictitemEntity) o;

        if (dictName != null ? !dictName.equals(that.dictName) : that.dictName != null) return false;
        if (itemName != null ? !itemName.equals(that.itemName) : that.itemName != null) return false;
        if (itemNo != null ? !itemNo.equals(that.itemNo) : that.itemNo != null) return false;
        if (parentItemNo != null ? !parentItemNo.equals(that.parentItemNo) : that.parentItemNo != null) return false;
        if (itemOrder != null ? !itemOrder.equals(that.itemOrder) : that.itemOrder != null) return false;
        if (itemState != null ? !itemState.equals(that.itemState) : that.itemState != null) return false;
        if (itemLevel != null ? !itemLevel.equals(that.itemLevel) : that.itemLevel != null) return false;
        if (itemDesc != null ? !itemDesc.equals(that.itemDesc) : that.itemDesc != null) return false;
        if (itemNamePy != null ? !itemNamePy.equals(that.itemNamePy) : that.itemNamePy != null) return false;
        if (itemNamePycap != null ? !itemNamePycap.equals(that.itemNamePycap) : that.itemNamePycap != null)
            return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (createUser != null ? !createUser.equals(that.createUser) : that.createUser != null) return false;
        if (mappingItemNo != null ? !mappingItemNo.equals(that.mappingItemNo) : that.mappingItemNo != null)
            return false;
        if (mappingDictName != null ? !mappingDictName.equals(that.mappingDictName) : that.mappingDictName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dictName != null ? dictName.hashCode() : 0;
        result = 31 * result + (itemName != null ? itemName.hashCode() : 0);
        result = 31 * result + (itemNo != null ? itemNo.hashCode() : 0);
        result = 31 * result + (parentItemNo != null ? parentItemNo.hashCode() : 0);
        result = 31 * result + (itemOrder != null ? itemOrder.hashCode() : 0);
        result = 31 * result + (itemState != null ? itemState.hashCode() : 0);
        result = 31 * result + (itemLevel != null ? itemLevel.hashCode() : 0);
        result = 31 * result + (itemDesc != null ? itemDesc.hashCode() : 0);
        result = 31 * result + (itemNamePy != null ? itemNamePy.hashCode() : 0);
        result = 31 * result + (itemNamePycap != null ? itemNamePycap.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (createUser != null ? createUser.hashCode() : 0);
        result = 31 * result + (mappingItemNo != null ? mappingItemNo.hashCode() : 0);
        result = 31 * result + (mappingDictName != null ? mappingDictName.hashCode() : 0);
        return result;
    }
}
