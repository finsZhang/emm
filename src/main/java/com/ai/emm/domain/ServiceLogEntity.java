package com.ai.emm.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Walter on 2017/1/10.
 */
@Entity
@Table(name = "SERVICE_LOG", schema = "EMM", catalog = "")
public class ServiceLogEntity {
    private long serviceId;
    private String serviceName;
    private String serviceReq;
    private String serviceResp;
    private Timestamp startTime;
    private Timestamp endTime;
    private String totalTime;

    @Id
    @Column(name = "SERVICE_ID", nullable = false, precision = 0)
    public long getServiceId() {
        return serviceId;
    }

    public void setServiceId(long serviceId) {
        this.serviceId = serviceId;
    }

    @Basic
    @Column(name = "SERVICE_NAME", nullable = true, length = 100)
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Basic
    @Column(name = "SERVICE_REQ", nullable = true, length = 4000)
    public String getServiceReq() {
        return serviceReq;
    }

    public void setServiceReq(String serviceReq) {
        this.serviceReq = serviceReq;
    }

    @Basic
    @Column(name = "SERVICE_RESP", nullable = true, length = 4000)
    public String getServiceResp() {
        return serviceResp;
    }

    public void setServiceResp(String serviceResp) {
        this.serviceResp = serviceResp;
    }

    @Basic
    @Column(name = "START_TIME", nullable = true)
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "END_TIME", nullable = true)
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "TOTAL_TIME", nullable = true, length = 100)
    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceLogEntity that = (ServiceLogEntity) o;

        if (serviceId != that.serviceId) return false;
        if (serviceName != null ? !serviceName.equals(that.serviceName) : that.serviceName != null) return false;
        if (serviceReq != null ? !serviceReq.equals(that.serviceReq) : that.serviceReq != null) return false;
        if (serviceResp != null ? !serviceResp.equals(that.serviceResp) : that.serviceResp != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (totalTime != null ? !totalTime.equals(that.totalTime) : that.totalTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (serviceId ^ (serviceId >>> 32));
        result = 31 * result + (serviceName != null ? serviceName.hashCode() : 0);
        result = 31 * result + (serviceReq != null ? serviceReq.hashCode() : 0);
        result = 31 * result + (serviceResp != null ? serviceResp.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (totalTime != null ? totalTime.hashCode() : 0);
        return result;
    }
}
