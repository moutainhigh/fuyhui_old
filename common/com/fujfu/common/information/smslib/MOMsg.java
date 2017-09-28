
package com.fujfu.common.information.smslib;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for MOMsg complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MOMsg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Phone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Content" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MsgType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="SpecNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ServiceType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReceiveTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Reserve" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MOMsg", propOrder = {
    "phone",
    "content",
    "msgType",
    "specNumber",
    "serviceType",
    "receiveTime",
    "reserve"
})
public class MOMsg {

    @XmlElement(name = "Phone")
    protected String phone;
    @XmlElement(name = "Content")
    protected String content;
    @XmlElement(name = "MsgType")
    protected int msgType;
    @XmlElement(name = "SpecNumber")
    protected String specNumber;
    @XmlElement(name = "ServiceType")
    protected String serviceType;
    @XmlElement(name = "ReceiveTime", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar receiveTime;
    @XmlElement(name = "Reserve")
    protected String reserve;

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
     * Gets the value of the specNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecNumber() {
        return specNumber;
    }

    /**
     * Sets the value of the specNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecNumber(String value) {
        this.specNumber = value;
    }

    /**
     * Gets the value of the serviceType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceType() {
        return serviceType;
    }

    /**
     * Sets the value of the serviceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceType(String value) {
        this.serviceType = value;
    }

    /**
     * Gets the value of the receiveTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReceiveTime() {
        return receiveTime;
    }

    /**
     * Sets the value of the receiveTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReceiveTime(XMLGregorianCalendar value) {
        this.receiveTime = value;
    }

    /**
     * Gets the value of the reserve property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReserve() {
        return reserve;
    }

    /**
     * Sets the value of the reserve property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReserve(String value) {
        this.reserve = value;
    }

}
