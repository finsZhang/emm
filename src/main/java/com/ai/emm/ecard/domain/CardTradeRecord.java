package com.ai.emm.ecard.domain;

/**
 * Created by lenovo on 2016/12/27.
 */
public class CardTradeRecord {
    private String tradeRecordId;
    private String userId;
    private float amount;

    public CardTradeRecord(String tradeRecordId, String userId) {
        this.tradeRecordId = tradeRecordId;
        this.userId = userId;
    }

    public String getTradeRecordId() {
        return tradeRecordId;
    }

    public void setTradeRecordId(String tradeRecordId) {
        this.tradeRecordId = tradeRecordId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
