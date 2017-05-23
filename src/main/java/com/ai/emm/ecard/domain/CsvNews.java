package com.ai.emm.ecard.domain;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by lenovo on 2016/12/27.
 */
@Entity
@Table(name = "CSV_NEWS", schema = "ECARD", catalog = "")
public class CsvNews {
    private String id;
    private String newsType;
    private String title;
    private String source;
    private String pv;
    private String editor;
    private String summary;
    private String tags;
    private String isPaging;
    private String lineNum;
    private String imagePath;
    private String creatorName;
    private String creatorUsername;
    private Time created;
    private String modifierName;
    private String modifierUsername;
    private Time modified;
    private String deleted;
    private String contentPath;
    private String deployStatus;
    private Time lastDeployTime;
    private Time lastCancelTime;
    private String isLoop;
    private String isShow;
    private String newIndex;

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NEWS_TYPE")
    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }

    @Basic
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "SOURCE")
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Basic
    @Column(name = "PV")
    public String getPv() {
        return pv;
    }

    public void setPv(String pv) {
        this.pv = pv;
    }

    @Basic
    @Column(name = "EDITOR")
    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    @Basic
    @Column(name = "SUMMARY")
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Basic
    @Column(name = "TAGS")
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Basic
    @Column(name = "IS_PAGING")
    public String getIsPaging() {
        return isPaging;
    }

    public void setIsPaging(String isPaging) {
        this.isPaging = isPaging;
    }

    @Basic
    @Column(name = "LINE_NUM")
    public String getLineNum() {
        return lineNum;
    }

    public void setLineNum(String lineNum) {
        this.lineNum = lineNum;
    }

    @Basic
    @Column(name = "IMAGE_PATH")
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Basic
    @Column(name = "CREATOR_NAME")
    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    @Basic
    @Column(name = "CREATOR_USERNAME")
    public String getCreatorUsername() {
        return creatorUsername;
    }

    public void setCreatorUsername(String creatorUsername) {
        this.creatorUsername = creatorUsername;
    }

    @Basic
    @Column(name = "CREATED")
    public Time getCreated() {
        return created;
    }

    public void setCreated(Time created) {
        this.created = created;
    }

    @Basic
    @Column(name = "MODIFIER_NAME")
    public String getModifierName() {
        return modifierName;
    }

    public void setModifierName(String modifierName) {
        this.modifierName = modifierName;
    }

    @Basic
    @Column(name = "MODIFIER_USERNAME")
    public String getModifierUsername() {
        return modifierUsername;
    }

    public void setModifierUsername(String modifierUsername) {
        this.modifierUsername = modifierUsername;
    }

    @Basic
    @Column(name = "MODIFIED")
    public Time getModified() {
        return modified;
    }

    public void setModified(Time modified) {
        this.modified = modified;
    }

    @Basic
    @Column(name = "DELETED")
    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    @Basic
    @Column(name = "CONTENT_PATH")
    public String getContentPath() {
        return contentPath;
    }

    public void setContentPath(String contentPath) {
        this.contentPath = contentPath;
    }

    @Basic
    @Column(name = "DEPLOY_STATUS")
    public String getDeployStatus() {
        return deployStatus;
    }

    public void setDeployStatus(String deployStatus) {
        this.deployStatus = deployStatus;
    }

    @Basic
    @Column(name = "LAST_DEPLOY_TIME")
    public Time getLastDeployTime() {
        return lastDeployTime;
    }

    public void setLastDeployTime(Time lastDeployTime) {
        this.lastDeployTime = lastDeployTime;
    }

    @Basic
    @Column(name = "LAST_CANCEL_TIME")
    public Time getLastCancelTime() {
        return lastCancelTime;
    }

    public void setLastCancelTime(Time lastCancelTime) {
        this.lastCancelTime = lastCancelTime;
    }

    @Basic
    @Column(name = "IS_LOOP")
    public String getIsLoop() {
        return isLoop;
    }

    public void setIsLoop(String isLoop) {
        this.isLoop = isLoop;
    }

    @Basic
    @Column(name = "IS_SHOW")
    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    @Basic
    @Column(name = "NEW_INDEX")
    public String getNewIndex() {
        return newIndex;
    }

    public void setNewIndex(String newIndex) {
        this.newIndex = newIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CsvNews csvNews = (CsvNews) o;

        if (id != null ? !id.equals(csvNews.id) : csvNews.id != null) return false;
        if (newsType != null ? !newsType.equals(csvNews.newsType) : csvNews.newsType != null) return false;
        if (title != null ? !title.equals(csvNews.title) : csvNews.title != null) return false;
        if (source != null ? !source.equals(csvNews.source) : csvNews.source != null) return false;
        if (pv != null ? !pv.equals(csvNews.pv) : csvNews.pv != null) return false;
        if (editor != null ? !editor.equals(csvNews.editor) : csvNews.editor != null) return false;
        if (summary != null ? !summary.equals(csvNews.summary) : csvNews.summary != null) return false;
        if (tags != null ? !tags.equals(csvNews.tags) : csvNews.tags != null) return false;
        if (isPaging != null ? !isPaging.equals(csvNews.isPaging) : csvNews.isPaging != null) return false;
        if (lineNum != null ? !lineNum.equals(csvNews.lineNum) : csvNews.lineNum != null) return false;
        if (imagePath != null ? !imagePath.equals(csvNews.imagePath) : csvNews.imagePath != null) return false;
        if (creatorName != null ? !creatorName.equals(csvNews.creatorName) : csvNews.creatorName != null) return false;
        if (creatorUsername != null ? !creatorUsername.equals(csvNews.creatorUsername) : csvNews.creatorUsername != null)
            return false;
        if (created != null ? !created.equals(csvNews.created) : csvNews.created != null) return false;
        if (modifierName != null ? !modifierName.equals(csvNews.modifierName) : csvNews.modifierName != null)
            return false;
        if (modifierUsername != null ? !modifierUsername.equals(csvNews.modifierUsername) : csvNews.modifierUsername != null)
            return false;
        if (modified != null ? !modified.equals(csvNews.modified) : csvNews.modified != null) return false;
        if (deleted != null ? !deleted.equals(csvNews.deleted) : csvNews.deleted != null) return false;
        if (contentPath != null ? !contentPath.equals(csvNews.contentPath) : csvNews.contentPath != null) return false;
        if (deployStatus != null ? !deployStatus.equals(csvNews.deployStatus) : csvNews.deployStatus != null)
            return false;
        if (lastDeployTime != null ? !lastDeployTime.equals(csvNews.lastDeployTime) : csvNews.lastDeployTime != null)
            return false;
        if (lastCancelTime != null ? !lastCancelTime.equals(csvNews.lastCancelTime) : csvNews.lastCancelTime != null)
            return false;
        if (isLoop != null ? !isLoop.equals(csvNews.isLoop) : csvNews.isLoop != null) return false;
        if (isShow != null ? !isShow.equals(csvNews.isShow) : csvNews.isShow != null) return false;
        if (newIndex != null ? !newIndex.equals(csvNews.newIndex) : csvNews.newIndex != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (newsType != null ? newsType.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (pv != null ? pv.hashCode() : 0);
        result = 31 * result + (editor != null ? editor.hashCode() : 0);
        result = 31 * result + (summary != null ? summary.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        result = 31 * result + (isPaging != null ? isPaging.hashCode() : 0);
        result = 31 * result + (lineNum != null ? lineNum.hashCode() : 0);
        result = 31 * result + (imagePath != null ? imagePath.hashCode() : 0);
        result = 31 * result + (creatorName != null ? creatorName.hashCode() : 0);
        result = 31 * result + (creatorUsername != null ? creatorUsername.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (modifierName != null ? modifierName.hashCode() : 0);
        result = 31 * result + (modifierUsername != null ? modifierUsername.hashCode() : 0);
        result = 31 * result + (modified != null ? modified.hashCode() : 0);
        result = 31 * result + (deleted != null ? deleted.hashCode() : 0);
        result = 31 * result + (contentPath != null ? contentPath.hashCode() : 0);
        result = 31 * result + (deployStatus != null ? deployStatus.hashCode() : 0);
        result = 31 * result + (lastDeployTime != null ? lastDeployTime.hashCode() : 0);
        result = 31 * result + (lastCancelTime != null ? lastCancelTime.hashCode() : 0);
        result = 31 * result + (isLoop != null ? isLoop.hashCode() : 0);
        result = 31 * result + (isShow != null ? isShow.hashCode() : 0);
        result = 31 * result + (newIndex != null ? newIndex.hashCode() : 0);
        return result;
    }
}
