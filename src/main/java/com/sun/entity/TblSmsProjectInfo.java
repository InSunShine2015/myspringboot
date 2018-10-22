package com.sun.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author sunxg
 * @since 2018-10-22
 */
public class TblSmsProjectInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 工程编号
     */
    private String appId;

    /**
     * 工程名称
     */
    private String projectName;

    private Integer validMinutes;

    /**
     * 状态：1 生效 0 失效
     */
    private Boolean status;

    private Integer limitCount;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public Integer getValidMinutes() {
        return validMinutes;
    }

    public void setValidMinutes(Integer validMinutes) {
        this.validMinutes = validMinutes;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getLimitCount() {
        return limitCount;
    }

    public void setLimitCount(Integer limitCount) {
        this.limitCount = limitCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "TblSmsProjectInfo{" +
        "appId=" + appId +
        ", projectName=" + projectName +
        ", validMinutes=" + validMinutes +
        ", status=" + status +
        ", limitCount=" + limitCount +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
