package com.ai.emm.ecard.domain;

import javax.persistence.*;
import java.util.Arrays;

/**
 * Created by lenovo on 2016/12/27.
 */
@Entity
@Table(name = "CARD_CARD", schema = "ECARD", catalog = "")
public class CardCard {
    private String cardId;
    private String cardBusinessCode;
    private String idNo;
    private String cardNo;
    private String cardValidity;
    private String name;
    private String sex;
    private String nation;
    private String phone;
    private String address;
    private String unit;
    private String cardholderType;
    private String cityCode;
    private String cardSerial;
    private String chipSerial;
    private String bandCard;
    private String enableFlag;
    private String depositFlag;
    private String cardTime;
    private String deposit;
    private String masterCardType;
    private String daugherCardType;
    private String cardStatus;
    private String cardModel;
    private String cardCost;
    private String barCode;
    private String createTime;
    private String modifyTime;
    private String idType;
    private String birth;
    private String cardNcmsno;

    @Id
    @Column(name = "CARD_ID")
    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    @Basic
    @Column(name = "CARD_BUSINESS_CODE")
    public String getCardBusinessCode() {
        return cardBusinessCode;
    }

    public void setCardBusinessCode(String cardBusinessCode) {
        this.cardBusinessCode = cardBusinessCode;
    }

    @Basic
    @Column(name = "ID_NO")
    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    @Basic
    @Column(name = "CARD_NO")
    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    @Basic
    @Column(name = "CARD_VALIDITY")
    public String getCardValidity() {
        return cardValidity;
    }

    public void setCardValidity(String cardValidity) {
        this.cardValidity = cardValidity;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "SEX")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "NATION")
    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Basic
    @Column(name = "PHONE")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "UNIT")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Basic
    @Column(name = "CARDHOLDER_TYPE")
    public String getCardholderType() {
        return cardholderType;
    }

    public void setCardholderType(String cardholderType) {
        this.cardholderType = cardholderType;
    }

    @Basic
    @Column(name = "CITY_CODE")
    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    @Basic
    @Column(name = "CARD_SERIAL")
    public String getCardSerial() {
        return cardSerial;
    }

    public void setCardSerial(String cardSerial) {
        this.cardSerial = cardSerial;
    }

    @Basic
    @Column(name = "CHIP_SERIAL")
    public String getChipSerial() {
        return chipSerial;
    }

    public void setChipSerial(String chipSerial) {
        this.chipSerial = chipSerial;
    }

    @Basic
    @Column(name = "BAND_CARD")
    public String getBandCard() {
        return bandCard;
    }

    public void setBandCard(String bandCard) {
        this.bandCard = bandCard;
    }

    @Basic
    @Column(name = "ENABLE_FLAG")
    public String getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag;
    }

    @Basic
    @Column(name = "DEPOSIT_FLAG")
    public String getDepositFlag() {
        return depositFlag;
    }

    public void setDepositFlag(String depositFlag) {
        this.depositFlag = depositFlag;
    }

    @Basic
    @Column(name = "CARD_TIME")
    public String getCardTime() {
        return cardTime;
    }

    public void setCardTime(String cardTime) {
        this.cardTime = cardTime;
    }

    @Basic
    @Column(name = "DEPOSIT")
    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    @Basic
    @Column(name = "MASTER_CARD_TYPE")
    public String getMasterCardType() {
        return masterCardType;
    }

    public void setMasterCardType(String masterCardType) {
        this.masterCardType = masterCardType;
    }

    @Basic
    @Column(name = "DAUGHER_CARD_TYPE")
    public String getDaugherCardType() {
        return daugherCardType;
    }

    public void setDaugherCardType(String daugherCardType) {
        this.daugherCardType = daugherCardType;
    }

    @Basic
    @Column(name = "CARD_STATUS")
    public String getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }

    @Basic
    @Column(name = "CARD_MODEL")
    public String getCardModel() {
        return cardModel;
    }

    public void setCardModel(String cardModel) {
        this.cardModel = cardModel;
    }

    @Basic
    @Column(name = "CARD_COST")
    public String getCardCost() {
        return cardCost;
    }

    public void setCardCost(String cardCost) {
        this.cardCost = cardCost;
    }


    @Basic
    @Column(name = "BAR_CODE")
    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    @Basic
    @Column(name = "CREATE_TIME")
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "MODIFY_TIME")
    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Basic
    @Column(name = "ID_TYPE")
    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    @Basic
    @Column(name = "BIRTH")
    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    @Basic
    @Column(name = "CARD_NCMSNO")
    public String getCardNcmsno() {
        return cardNcmsno;
    }

    public void setCardNcmsno(String cardNcmsno) {
        this.cardNcmsno = cardNcmsno;
    }


}
