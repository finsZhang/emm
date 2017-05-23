package com.ai.emm.domain;

import javax.persistence.*;

/**
 * Created by lenovo on 2017/1/3.
 */
@Entity
@Table(name = "CARD_DATA", schema = "EMM", catalog = "")
public class CardDataEntity {
    private long id;
    private String orgName;
    private String orgCode;
    private String cityCode;
    private String cardSerial;
    private String cardNo;
    private String chipSerial;
    private String masterType;
    private String daughterType;
    private String name;
    private String sex;
    private String idNo;
    private String phoneNo;
    private String address;
    private String status;
    private CardRecordEntity cardRecordEntity;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CARD_DATA_ID")
    @SequenceGenerator(name = "CARD_DATA_ID", sequenceName = "SEQ_CARD_DATA", allocationSize=1)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ORG_NAME", nullable = true, length = 64)
    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Basic
    @Column(name = "ORG_CODE", nullable = true, length = 64)
    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    @Basic
    @Column(name = "CITY_CODE", nullable = true, length = 20)
    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    @Basic
    @Column(name = "CARD_SERIAL", nullable = true, length = 20)
    public String getCardSerial() {
        return cardSerial;
    }

    public void setCardSerial(String cardSerial) {
        this.cardSerial = cardSerial;
    }

    @Basic
    @Column(name = "CARD_NO", nullable = true, length = 20)
    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
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
    @Column(name = "MASTER_TYPE", nullable = true, length = 32)
    public String getMasterType() {
        return masterType;
    }

    public void setMasterType(String masterType) {
        this.masterType = masterType;
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
    @Column(name = "NAME", nullable = true, length = 32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "SEX", nullable = true, length = 2)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "ID_NO", nullable = true, length = 20)
    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    @Basic
    @Column(name = "PHONE_NO", nullable = true, length = 16)
    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Basic
    @Column(name = "ADDRESS", nullable = true, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "STATUS", nullable = true, length = 32)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @JoinColumn(name="CARD_RECORD_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    public CardRecordEntity getCardRecordEntity() {
        return cardRecordEntity;
    }

    public void setCardRecordEntity(CardRecordEntity cardRecordEntity) {
        this.cardRecordEntity = cardRecordEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardDataEntity that = (CardDataEntity) o;

        if (id != that.id) return false;
        if (orgName != null ? !orgName.equals(that.orgName) : that.orgName != null) return false;
        if (orgCode != null ? !orgCode.equals(that.orgCode) : that.orgCode != null) return false;
        if (cityCode != null ? !cityCode.equals(that.cityCode) : that.cityCode != null) return false;
        if (cardSerial != null ? !cardSerial.equals(that.cardSerial) : that.cardSerial != null) return false;
        if (cardNo != null ? !cardNo.equals(that.cardNo) : that.cardNo != null) return false;
        if (chipSerial != null ? !chipSerial.equals(that.chipSerial) : that.chipSerial != null) return false;
        if (masterType != null ? !masterType.equals(that.masterType) : that.masterType != null) return false;
        if (daughterType != null ? !daughterType.equals(that.daughterType) : that.daughterType != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (idNo != null ? !idNo.equals(that.idNo) : that.idNo != null) return false;
        if (phoneNo != null ? !phoneNo.equals(that.phoneNo) : that.phoneNo != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (orgName != null ? orgName.hashCode() : 0);
        result = 31 * result + (orgCode != null ? orgCode.hashCode() : 0);
        result = 31 * result + (cityCode != null ? cityCode.hashCode() : 0);
        result = 31 * result + (cardSerial != null ? cardSerial.hashCode() : 0);
        result = 31 * result + (cardNo != null ? cardNo.hashCode() : 0);
        result = 31 * result + (chipSerial != null ? chipSerial.hashCode() : 0);
        result = 31 * result + (masterType != null ? masterType.hashCode() : 0);
        result = 31 * result + (daughterType != null ? daughterType.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (idNo != null ? idNo.hashCode() : 0);
        result = 31 * result + (phoneNo != null ? phoneNo.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
