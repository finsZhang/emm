package com.ai.emm.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

/**
 * Created by Walter on 2017/1/4.
 */
@Entity
@Table(name = "LOG_RECORD", schema = "EMM", catalog = "")
public class LogRecordEntity {
    private long id;
    private String tradeSerial;
    private String chipSerial;
    private String cardSerial;
    private String cardNo;
    private String idNo;
    private String cardName;
    private String daughterType;
    private Date operateDate;
    private String psamNo;
    private String orgName;
    private String orgCode;
    private String businessType;
    private String cardType;
    private String cardStatus;
    private String operateStatus;
    private Date updateDate;

    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false, precision = 0)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TRADE_SERIAL", nullable = true, length = 32)
    public String getTradeSerial() {
        return tradeSerial;
    }

    public void setTradeSerial(String tradeSerial) {
        this.tradeSerial = tradeSerial;
    }

    @Basic
    @Column(name = "CHIP_SERIAL", nullable = true, length = 32)
    public String getChipSerial() {
        return chipSerial;
    }

    public void setChipSerial(String chipSerial) {
        this.chipSerial = chipSerial;
    }

    @Basic
    @Column(name = "CARD_SERIAL", nullable = true, length = 32)
    public String getCardSerial() {
        return cardSerial;
    }

    public void setCardSerial(String cardSerial) {
        this.cardSerial = cardSerial;
    }

    @Basic
    @Column(name = "CARD_NO", nullable = true, length = 32)
    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
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
    @Column(name = "CARD_NAME", nullable = true, length = 32)
    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    @Basic
    @Column(name = "DAUGHTER_TYPE", nullable = true, length = 32)
    public String getDaughterType() {
        return daughterType;
    }

    public void setDaughterType(String daughterType) {
        this.daughterType = daughterType;
    }

    @Basic
    @Column(name = "OPERATE_DATE", nullable = true)
    public Date getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
    }

    @Basic
    @Column(name = "PSAM_NO", nullable = true, length = 32)
    public String getPsamNo() {
        return psamNo;
    }

    public void setPsamNo(String psamNo) {
        this.psamNo = psamNo;
    }

    @Basic
    @Column(name = "ORG_NAME", nullable = true, length = 32)
    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Basic
    @Column(name = "ORG_CODE", nullable = true, length = 32)
    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    @Basic
    @Column(name = "BUSINESS_TYPE", nullable = true, length = 2)
    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    @Basic
    @Column(name = "CARD_TYPE", nullable = true, length = 2)
    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Basic
    @Column(name = "CARD_STATUS", nullable = true, length = 2)
    public String getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }

    @Basic
    @Column(name = "OPERATE_STATUS", nullable = true, length = 2)
    public String getOperateStatus() {
        return operateStatus;
    }

    public void setOperateStatus(String operateStatus) {
        this.operateStatus = operateStatus;
    }

    @Basic
    @Column(name = "UPDATE_DATE", nullable = true)
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogRecordEntity entity = (LogRecordEntity) o;

        if (id != entity.id) return false;
        if (tradeSerial != null ? !tradeSerial.equals(entity.tradeSerial) : entity.tradeSerial != null) return false;
        if (chipSerial != null ? !chipSerial.equals(entity.chipSerial) : entity.chipSerial != null) return false;
        if (cardSerial != null ? !cardSerial.equals(entity.cardSerial) : entity.cardSerial != null) return false;
        if (cardNo != null ? !cardNo.equals(entity.cardNo) : entity.cardNo != null) return false;
        if (idNo != null ? !idNo.equals(entity.idNo) : entity.idNo != null) return false;
        if (cardName != null ? !cardName.equals(entity.cardName) : entity.cardName != null) return false;
        if (daughterType != null ? !daughterType.equals(entity.daughterType) : entity.daughterType != null)
            return false;
        if (operateDate != null ? !operateDate.equals(entity.operateDate) : entity.operateDate != null) return false;
        if (psamNo != null ? !psamNo.equals(entity.psamNo) : entity.psamNo != null) return false;
        if (orgName != null ? !orgName.equals(entity.orgName) : entity.orgName != null) return false;
        if (orgCode != null ? !orgCode.equals(entity.orgCode) : entity.orgCode != null) return false;
        if (businessType != null ? !businessType.equals(entity.businessType) : entity.businessType != null)
            return false;
        if (cardType != null ? !cardType.equals(entity.cardType) : entity.cardType != null) return false;
        if (cardStatus != null ? !cardStatus.equals(entity.cardStatus) : entity.cardStatus != null) return false;
        if (operateStatus != null ? !operateStatus.equals(entity.operateStatus) : entity.operateStatus != null)
            return false;
        if (updateDate != null ? !updateDate.equals(entity.updateDate) : entity.updateDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (tradeSerial != null ? tradeSerial.hashCode() : 0);
        result = 31 * result + (chipSerial != null ? chipSerial.hashCode() : 0);
        result = 31 * result + (cardSerial != null ? cardSerial.hashCode() : 0);
        result = 31 * result + (cardNo != null ? cardNo.hashCode() : 0);
        result = 31 * result + (idNo != null ? idNo.hashCode() : 0);
        result = 31 * result + (cardName != null ? cardName.hashCode() : 0);
        result = 31 * result + (daughterType != null ? daughterType.hashCode() : 0);
        result = 31 * result + (operateDate != null ? operateDate.hashCode() : 0);
        result = 31 * result + (psamNo != null ? psamNo.hashCode() : 0);
        result = 31 * result + (orgName != null ? orgName.hashCode() : 0);
        result = 31 * result + (orgCode != null ? orgCode.hashCode() : 0);
        result = 31 * result + (businessType != null ? businessType.hashCode() : 0);
        result = 31 * result + (cardType != null ? cardType.hashCode() : 0);
        result = 31 * result + (cardStatus != null ? cardStatus.hashCode() : 0);
        result = 31 * result + (operateStatus != null ? operateStatus.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        return result;
    }
}
