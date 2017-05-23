package com.ai.emm.domain;

import javax.persistence.*;
import java.sql.Time;
import java.util.*;

/**
 * Created by lenovo on 2017/1/3.
 */
@Entity
@Table(name = "CARD_RECORD", schema = "EMM", catalog = "")
public class CardRecordEntity {
    private long id;
    private String zipFileName;
    private String txtFileName;
    private String batchNum;
    private String receiveAddr;
    private String creatorName;
    private String creatorCode;
    private Date createTime;
    private List<CardDataEntity> cardDataEntities = new ArrayList<CardDataEntity>();
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CARD_RECORD_ID")
    @SequenceGenerator(name = "CARD_RECORD_ID", sequenceName = "SEQ_CARD_RECORD", allocationSize=1)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ZIP_FILE_NAME", nullable = true, length = 128)
    public String getZipFileName() {
        return zipFileName;
    }

    public void setZipFileName(String zipFileName) {
        this.zipFileName = zipFileName;
    }

    @Basic
    @Column(name = "TXT_FILE_NAME", nullable = true, length = 128)
    public String getTxtFileName() {
        return txtFileName;
    }

    public void setTxtFileName(String txtFileName) {
        this.txtFileName = txtFileName;
    }

    @Basic
    @Column(name = "BATCH_NUM", nullable = true, length = 128)
    public String getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(String batchNum) {
        this.batchNum = batchNum;
    }

    @Basic
    @Column(name = "RECEIVE_ADDR", nullable = true, length = 255)
    public String getReceiveAddr() {
        return receiveAddr;
    }

    public void setReceiveAddr(String receiveAddr) {
        this.receiveAddr = receiveAddr;
    }

    @Basic
    @Column(name = "CREATOR_NAME", nullable = true, length = 64)
    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    @Basic
    @Column(name = "CREATOR_CODE", nullable = true, length = 64)
    public String getCreatorCode() {
        return creatorCode;
    }

    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode;
    }

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_TIME", nullable = true, length = 64)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.ALL},mappedBy = "cardRecordEntity")
    public List<CardDataEntity> getCardDataEntities() {
        return cardDataEntities;
    }

    public void setCardDataEntities(List<CardDataEntity> cardDataEntities) {
        this.cardDataEntities = cardDataEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardRecordEntity that = (CardRecordEntity) o;

        if (id != that.id) return false;
        if (zipFileName != null ? !zipFileName.equals(that.zipFileName) : that.zipFileName != null) return false;
        if (txtFileName != null ? !txtFileName.equals(that.txtFileName) : that.txtFileName != null) return false;
        if (batchNum != null ? !batchNum.equals(that.batchNum) : that.batchNum != null) return false;
        if (receiveAddr != null ? !receiveAddr.equals(that.receiveAddr) : that.receiveAddr != null) return false;
        if (creatorName != null ? !creatorName.equals(that.creatorName) : that.creatorName != null) return false;
        if (creatorCode != null ? !creatorCode.equals(that.creatorCode) : that.creatorCode != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (zipFileName != null ? zipFileName.hashCode() : 0);
        result = 31 * result + (txtFileName != null ? txtFileName.hashCode() : 0);
        result = 31 * result + (batchNum != null ? batchNum.hashCode() : 0);
        result = 31 * result + (receiveAddr != null ? receiveAddr.hashCode() : 0);
        result = 31 * result + (creatorName != null ? creatorName.hashCode() : 0);
        result = 31 * result + (creatorCode != null ? creatorCode.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
