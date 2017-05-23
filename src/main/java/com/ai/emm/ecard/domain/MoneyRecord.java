package com.ai.emm.ecard.domain;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhangfz3
 * Date: 2017/3/29
 * Time: 11:25
 * Tel:18665598790
 * Email:zhangfz3@asiainfo.com
 */
@Entity
@Table(name = "MONEY_RECORD", schema = "ECARD", catalog = "")
public class MoneyRecord {
    private String moneyRecordId;
    private String moneyRecordSerial;
    private String cardNo;
    private String tradeTime;
    private String terminalNo;
    private String name;
    private String idno;
    private String mainTradeType;
    private String subTradeType;
    private Long mainTradeAmt;
    private Long subTradeAmt;
    private Long totalTradeAmt;
    private String moneyStatus;
    private String tradeStatus;
    private String mainSerial;
    private String subSerial;
    private String chipSerial;

    @Id
    @Column(name = "MONEY_RECORD_ID", nullable = false, length = 32)
    public String getMoneyRecordId() {
        return moneyRecordId;
    }

    public void setMoneyRecordId(String moneyRecordId) {
        this.moneyRecordId = moneyRecordId;
    }

    @Basic
    @Column(name = "MONEY_RECORD_SERIAL", nullable = true, length = 64)
    public String getMoneyRecordSerial() {
        return moneyRecordSerial;
    }

    public void setMoneyRecordSerial(String moneyRecordSerial) {
        this.moneyRecordSerial = moneyRecordSerial;
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
    @Column(name = "TRADE_TIME", nullable = true, length = 32)
    public String getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }

    @Basic
    @Column(name = "TERMINAL_NO", nullable = true, length = 32)
    public String getTerminalNo() {
        return terminalNo;
    }

    public void setTerminalNo(String terminalNo) {
        this.terminalNo = terminalNo;
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
    @Column(name = "IDNO", nullable = true, length = 32)
    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    @Basic
    @Column(name = "MAIN_TRADE_TYPE", nullable = true, length = 2)
    public String getMainTradeType() {
        return mainTradeType;
    }

    public void setMainTradeType(String mainTradeType) {
        this.mainTradeType = mainTradeType;
    }

    @Basic
    @Column(name = "SUB_TRADE_TYPE", nullable = true, length = 2)
    public String getSubTradeType() {
        return subTradeType;
    }

    public void setSubTradeType(String subTradeType) {
        this.subTradeType = subTradeType;
    }

    @Basic
    @Column(name = "MAIN_TRADE_AMT", nullable = true, precision = 2)
    public Long getMainTradeAmt() {
        return mainTradeAmt;
    }

    public void setMainTradeAmt(Long mainTradeAmt) {
        this.mainTradeAmt = mainTradeAmt;
    }

    @Basic
    @Column(name = "SUB_TRADE_AMT", nullable = true, precision = 2)
    public Long getSubTradeAmt() {
        return subTradeAmt;
    }

    public void setSubTradeAmt(Long subTradeAmt) {
        this.subTradeAmt = subTradeAmt;
    }

    @Basic
    @Column(name = "TOTAL_TRADE_AMT", nullable = true, precision = 2)
    public Long getTotalTradeAmt() {
        return totalTradeAmt;
    }

    public void setTotalTradeAmt(Long totalTradeAmt) {
        this.totalTradeAmt = totalTradeAmt;
    }

    @Basic
    @Column(name = "MONEY_STATUS", nullable = true, length = 2)
    public String getMoneyStatus() {
        return moneyStatus;
    }

    public void setMoneyStatus(String moneyStatus) {
        this.moneyStatus = moneyStatus;
    }

    @Basic
    @Column(name = "TRADE_STATUS", nullable = true, length = 2)
    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    @Basic
    @Column(name = "MAIN_SERIAL", nullable = true, length = 64)
    public String getMainSerial() {
        return mainSerial;
    }

    public void setMainSerial(String mainSerial) {
        this.mainSerial = mainSerial;
    }

    @Basic
    @Column(name = "SUB_SERIAL", nullable = true, length = 64)
    public String getSubSerial() {
        return subSerial;
    }

    public void setSubSerial(String subSerial) {
        this.subSerial = subSerial;
    }

    @Basic
    @Column(name = "CHIP_SERIAL", nullable = true, length = 64)
    public String getChipSerial() {
        return chipSerial;
    }

    public void setChipSerial(String chipSerial) {
        this.chipSerial = chipSerial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MoneyRecord that = (MoneyRecord) o;

        if (moneyRecordId != null ? !moneyRecordId.equals(that.moneyRecordId) : that.moneyRecordId != null)
            return false;
        if (moneyRecordSerial != null ? !moneyRecordSerial.equals(that.moneyRecordSerial) : that.moneyRecordSerial != null)
            return false;
        if (cardNo != null ? !cardNo.equals(that.cardNo) : that.cardNo != null) return false;
        if (tradeTime != null ? !tradeTime.equals(that.tradeTime) : that.tradeTime != null) return false;
        if (terminalNo != null ? !terminalNo.equals(that.terminalNo) : that.terminalNo != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (idno != null ? !idno.equals(that.idno) : that.idno != null) return false;
        if (mainTradeType != null ? !mainTradeType.equals(that.mainTradeType) : that.mainTradeType != null)
            return false;
        if (subTradeType != null ? !subTradeType.equals(that.subTradeType) : that.subTradeType != null) return false;
        if (mainTradeAmt != null ? !mainTradeAmt.equals(that.mainTradeAmt) : that.mainTradeAmt != null) return false;
        if (subTradeAmt != null ? !subTradeAmt.equals(that.subTradeAmt) : that.subTradeAmt != null) return false;
        if (totalTradeAmt != null ? !totalTradeAmt.equals(that.totalTradeAmt) : that.totalTradeAmt != null)
            return false;
        if (moneyStatus != null ? !moneyStatus.equals(that.moneyStatus) : that.moneyStatus != null) return false;
        if (tradeStatus != null ? !tradeStatus.equals(that.tradeStatus) : that.tradeStatus != null) return false;
        if (mainSerial != null ? !mainSerial.equals(that.mainSerial) : that.mainSerial != null) return false;
        if (subSerial != null ? !subSerial.equals(that.subSerial) : that.subSerial != null) return false;
        if (chipSerial != null ? !chipSerial.equals(that.chipSerial) : that.chipSerial != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = moneyRecordId != null ? moneyRecordId.hashCode() : 0;
        result = 31 * result + (moneyRecordSerial != null ? moneyRecordSerial.hashCode() : 0);
        result = 31 * result + (cardNo != null ? cardNo.hashCode() : 0);
        result = 31 * result + (tradeTime != null ? tradeTime.hashCode() : 0);
        result = 31 * result + (terminalNo != null ? terminalNo.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (idno != null ? idno.hashCode() : 0);
        result = 31 * result + (mainTradeType != null ? mainTradeType.hashCode() : 0);
        result = 31 * result + (subTradeType != null ? subTradeType.hashCode() : 0);
        result = 31 * result + (mainTradeAmt != null ? mainTradeAmt.hashCode() : 0);
        result = 31 * result + (subTradeAmt != null ? subTradeAmt.hashCode() : 0);
        result = 31 * result + (totalTradeAmt != null ? totalTradeAmt.hashCode() : 0);
        result = 31 * result + (moneyStatus != null ? moneyStatus.hashCode() : 0);
        result = 31 * result + (tradeStatus != null ? tradeStatus.hashCode() : 0);
        result = 31 * result + (mainSerial != null ? mainSerial.hashCode() : 0);
        result = 31 * result + (subSerial != null ? subSerial.hashCode() : 0);
        result = 31 * result + (chipSerial != null ? chipSerial.hashCode() : 0);
        return result;
    }
}
