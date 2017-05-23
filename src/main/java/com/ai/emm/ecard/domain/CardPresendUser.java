package com.ai.emm.ecard.domain;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhangfz3
 * Date: 2017/3/29
 * Time: 9:47
 * Tel:18665598790
 * Email:zhangfz3@asiainfo.com
 */
@Entity
@Table(name = "CARD_PRESEND_USER", schema = "ECARD", catalog = "")
public class CardPresendUser {
    private long cardPresendUserId;
    private String idNo;
    private String cardNo;
    private String name;
    private String sex;
    private String nation;
    private String phone;
    private String address;
    private String unit;
    private String cardholderType;
    private String cardSerial;
    private String enableFlag;
    private String depositFlag;
    private String deposit;
    private String masterCardType;
    private String daugherCardType;
    private String cardStatus;
    private String moneyRecordSerial;

    @Id
    @Column(name = "CARD_PRESEND_USER_ID", nullable = false, precision = 0)
    public long getCardPresendUserId() {
        return cardPresendUserId;
    }

    public void setCardPresendUserId(long cardPresendUserId) {
        this.cardPresendUserId = cardPresendUserId;
    }

    @Basic
    @Column(name = "ID_NO", nullable = true, length = 32)
    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    @Basic
    @Column(name = "CARD_NO", nullable = true, length = 18)
    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    @Basic
    @Column(name = "NAME", nullable = true, length = 32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "SEX", nullable = true, length = 1)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "NATION", nullable = true, length = 2)
    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Basic
    @Column(name = "PHONE", nullable = true, length = 16)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "ADDRESS", nullable = true, length = 120)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "UNIT", nullable = true, length = 64)
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Basic
    @Column(name = "CARDHOLDER_TYPE", nullable = true, length = 20)
    public String getCardholderType() {
        return cardholderType;
    }

    public void setCardholderType(String cardholderType) {
        this.cardholderType = cardholderType;
    }

    @Basic
    @Column(name = "CARD_SERIAL", nullable = true, length = 16)
    public String getCardSerial() {
        return cardSerial;
    }

    public void setCardSerial(String cardSerial) {
        this.cardSerial = cardSerial;
    }

    @Basic
    @Column(name = "ENABLE_FLAG", nullable = true, length = 20)
    public String getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag;
    }

    @Basic
    @Column(name = "DEPOSIT_FLAG", nullable = true, length = 20)
    public String getDepositFlag() {
        return depositFlag;
    }

    public void setDepositFlag(String depositFlag) {
        this.depositFlag = depositFlag;
    }

    @Basic
    @Column(name = "DEPOSIT", nullable = true, length = 20)
    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    @Basic
    @Column(name = "MASTER_CARD_TYPE", nullable = true, length = 20)
    public String getMasterCardType() {
        return masterCardType;
    }

    public void setMasterCardType(String masterCardType) {
        this.masterCardType = masterCardType;
    }

    @Basic
    @Column(name = "DAUGHER_CARD_TYPE", nullable = true, length = 20)
    public String getDaugherCardType() {
        return daugherCardType;
    }

    public void setDaugherCardType(String daugherCardType) {
        this.daugherCardType = daugherCardType;
    }

    @Basic
    @Column(name = "CARD_STATUS", nullable = true, length = 1)
    public String getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }

    @Basic
    @Column(name = "MONEY_RECORD_SERIAL", nullable = true, length = 64)
    public String getMoneyRecordSerial() {
        return moneyRecordSerial;
    }

    public void setMoneyRecordSerial(String moneyRecordSerial) {
        this.moneyRecordSerial = moneyRecordSerial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardPresendUser that = (CardPresendUser) o;

        if (cardPresendUserId != that.cardPresendUserId) return false;
        if (idNo != null ? !idNo.equals(that.idNo) : that.idNo != null) return false;
        if (cardNo != null ? !cardNo.equals(that.cardNo) : that.cardNo != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (nation != null ? !nation.equals(that.nation) : that.nation != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (unit != null ? !unit.equals(that.unit) : that.unit != null) return false;
        if (cardholderType != null ? !cardholderType.equals(that.cardholderType) : that.cardholderType != null)
            return false;
        if (cardSerial != null ? !cardSerial.equals(that.cardSerial) : that.cardSerial != null) return false;
        if (enableFlag != null ? !enableFlag.equals(that.enableFlag) : that.enableFlag != null) return false;
        if (depositFlag != null ? !depositFlag.equals(that.depositFlag) : that.depositFlag != null) return false;
        if (deposit != null ? !deposit.equals(that.deposit) : that.deposit != null) return false;
        if (masterCardType != null ? !masterCardType.equals(that.masterCardType) : that.masterCardType != null)
            return false;
        if (daugherCardType != null ? !daugherCardType.equals(that.daugherCardType) : that.daugherCardType != null)
            return false;
        if (cardStatus != null ? !cardStatus.equals(that.cardStatus) : that.cardStatus != null) return false;
        if (moneyRecordSerial != null ? !moneyRecordSerial.equals(that.moneyRecordSerial) : that.moneyRecordSerial != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (cardPresendUserId ^ (cardPresendUserId >>> 32));
        result = 31 * result + (idNo != null ? idNo.hashCode() : 0);
        result = 31 * result + (cardNo != null ? cardNo.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (nation != null ? nation.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + (cardholderType != null ? cardholderType.hashCode() : 0);
        result = 31 * result + (cardSerial != null ? cardSerial.hashCode() : 0);
        result = 31 * result + (enableFlag != null ? enableFlag.hashCode() : 0);
        result = 31 * result + (depositFlag != null ? depositFlag.hashCode() : 0);
        result = 31 * result + (deposit != null ? deposit.hashCode() : 0);
        result = 31 * result + (masterCardType != null ? masterCardType.hashCode() : 0);
        result = 31 * result + (daugherCardType != null ? daugherCardType.hashCode() : 0);
        result = 31 * result + (cardStatus != null ? cardStatus.hashCode() : 0);
        result = 31 * result + (moneyRecordSerial != null ? moneyRecordSerial.hashCode() : 0);
        return result;
    }
}
