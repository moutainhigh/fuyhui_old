
package com.fujfu.common.information.smslib;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BusinessType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BusinessType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Priority" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="StartTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EndTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExtendFlag" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="bindChs" type="{http://www.139130.net}ArrayOfBindChannel" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusinessType", propOrder = {
    "id",
    "name",
    "priority",
    "startTime",
    "endTime",
    "extendFlag",
    "state",
    "bindChs"
})
public class BusinessType {

    @XmlElement(name = "Id")
    protected int id;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Priority")
    protected int priority;
    @XmlElement(name = "StartTime")
    protected String startTime;
    @XmlElement(name = "EndTime")
    protected String endTime;
    @XmlElement(name = "ExtendFlag")
    protected boolean extendFlag;
    protected int state;
    protected ArrayOfBindChannel bindChs;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the priority property.
     * 
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     * 
     */
    public void setPriority(int value) {
        this.priority = value;
    }

    /**
     * Gets the value of the startTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * Sets the value of the startTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartTime(String value) {
        this.startTime = value;
    }

    /**
     * Gets the value of the endTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * Sets the value of the endTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndTime(String value) {
        this.endTime = value;
    }

    /**
     * Gets the value of the extendFlag property.
     * 
     */
    public boolean isExtendFlag() {
        return extendFlag;
    }

    /**
     * Sets the value of the extendFlag property.
     * 
     */
    public void setExtendFlag(boolean value) {
        this.extendFlag = value;
    }

    /**
     * Gets the value of the state property.
     * 
     */
    public int getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     */
    public void setState(int value) {
        this.state = value;
    }

    /**
     * Gets the value of the bindChs property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfBindChannel }
     *     
     */
    public ArrayOfBindChannel getBindChs() {
        return bindChs;
    }

    /**
     * Sets the value of the bindChs property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfBindChannel }
     *     
     */
    public void setBindChs(ArrayOfBindChannel value) {
        this.bindChs = value;
    }

}
