
package com.fujfu.common.information.smslib;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MessageData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MessageData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Phone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Content" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vipFlag" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="customMsgID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="medias" type="{http://www.139130.net}ArrayOfMediaItems" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MessageData", propOrder = {
    "phone",
    "content",
    "vipFlag",
    "customMsgID",
    "medias"
})
public class MessageData {

    @XmlElement(name = "Phone")
    protected String phone;
    @XmlElement(name = "Content")
    protected String content;
    protected boolean vipFlag;
    protected String customMsgID;
    protected ArrayOfMediaItems medias;

    /**
     * Gets the value of the phone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the value of the phone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhone(String value) {
        this.phone = value;
    }

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContent(String value) {
        this.content = value;
    }

    /**
     * Gets the value of the vipFlag property.
     * 
     */
    public boolean isVipFlag() {
        return vipFlag;
    }

    /**
     * Sets the value of the vipFlag property.
     * 
     */
    public void setVipFlag(boolean value) {
        this.vipFlag = value;
    }

    /**
     * Gets the value of the customMsgID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomMsgID() {
        return customMsgID;
    }

    /**
     * Sets the value of the customMsgID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomMsgID(String value) {
        this.customMsgID = value;
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

}
