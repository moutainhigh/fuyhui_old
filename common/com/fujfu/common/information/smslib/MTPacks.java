
package com.fujfu.common.information.smslib;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MTPacks complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MTPacks">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="uuid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="batchID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="batchName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sendType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="msgType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="medias" type="{http://www.139130.net}ArrayOfMediaItems" minOccurs="0"/>
 *         &lt;element name="msgs" type="{http://www.139130.net}ArrayOfMessageData" minOccurs="0"/>
 *         &lt;element name="bizType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="distinctFlag" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="scheduleTime" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deadline" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MTPacks", propOrder = {
    "uuid",
    "batchID",
    "batchName",
    "sendType",
    "msgType",
    "medias",
    "msgs",
    "bizType",
    "distinctFlag",
    "scheduleTime",
    "remark",
    "customNum",
    "deadline"
})
public class MTPacks {

    @XmlElement(required = true)
    protected String uuid;
    @XmlElement(required = true)
    protected String batchID;
    protected String batchName;
    protected int sendType;
    protected int msgType;
    protected ArrayOfMediaItems medias;
    protected ArrayOfMessageData msgs;
    protected int bizType;
    protected boolean distinctFlag;
    protected long scheduleTime;
    protected String remark;
    protected String customNum;
    protected long deadline;

    /**
     * Gets the value of the uuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Sets the value of the uuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUuid(String value) {
        this.uuid = value;
    }

    /**
     * Gets the value of the batchID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBatchID() {
        return batchID;
    }

    /**
     * Sets the value of the batchID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBatchID(String value) {
        this.batchID = value;
    }

    /**
     * Gets the value of the batchName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBatchName() {
        return batchName;
    }

    /**
     * Sets the value of the batchName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBatchName(String value) {
        this.batchName = value;
    }

    /**
     * Gets the value of the sendType property.
     * 
     */
    public int getSendType() {
        return sendType;
    }

    /**
     * Sets the value of the sendType property.
     * 
     */
    public void setSendType(int value) {
        this.sendType = value;
    }

    /**
     * Gets the value of the msgType property.
     * 
     */
    public int getMsgType() {
        return msgType;
    }

    /**
     * Sets the value of the msgType property.
     * 
     */
    public void setMsgType(int value) {
        this.msgType = value;
    }

    /**
     * Gets the value of the medias property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMediaItems }
     *     
     */
    public ArrayOfMediaItems getMedias() {
        return medias;
    }

    /**
     * Sets the value of the medias property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMediaItems }
     *     
     */
    public void setMedias(ArrayOfMediaItems value) {
        this.medias = value;
    }

    /**
     * Gets the value of the msgs property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMessageData }
     *     
     */
    public ArrayOfMessageData getMsgs() {
        return msgs;
    }

    /**
     * Sets the value of the msgs property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMessageData }
     *     
     */
    public void setMsgs(ArrayOfMessageData value) {
        this.msgs = value;
    }

    /**
     * Gets the value of the bizType property.
     * 
     */
    public int getBizType() {
        return bizType;
    }

    /**
     * Sets the value of the bizType property.
     * 
     */
    public void setBizType(int value) {
        this.bizType = value;
    }

    /**
     * Gets the value of the distinctFlag property.
     * 
     */
    public boolean isDistinctFlag() {
        return distinctFlag;
    }

    /**
     * Sets the value of the distinctFlag property.
     * 
     */
    public void setDistinctFlag(boolean value) {
        this.distinctFlag = value;
    }

    /**
     * Gets the value of the scheduleTime property.
     * 
     */
    public long getScheduleTime() {
        return scheduleTime;
    }

    /**
     * Sets the value of the scheduleTime property.
     * 
     */
    public void setScheduleTime(long value) {
        this.scheduleTime = value;
    }

    /**
     * Gets the value of the remark property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemark() {
        return remark;
    }

    /**
     * Sets the value of the remark property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemark(String value) {
        this.remark = value;
    }

    /**
     * Gets the value of the customNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomNum() {
        return customNum;
    }

    /**
     * Sets the value of the customNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomNum(String value) {
        this.customNum = value;
    }

    /**
     * Gets the value of the deadline property.
     * 
     */
    public long getDeadline() {
        return deadline;
    }

    /**
     * Sets the value of the deadline property.
     * 
     */
    public void setDeadline(long value) {
        this.deadline = value;
    }

}
