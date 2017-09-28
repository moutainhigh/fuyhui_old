
package com.fujfu.common.information.smslib;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for MTReport complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MTReport">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="batchID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="phone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="msgID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customMsgID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="total" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="submitTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="doneTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="originResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reserve" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MTReport", propOrder = {
    "id",
    "batchID",
    "phone",
    "msgID",
    "customMsgID",
    "state",
    "total",
    "number",
    "submitTime",
    "doneTime",
    "originResult",
    "reserve"
})
public class MTReport {

    protected long id;
    protected String batchID;
    protected String phone;
    protected String msgID;
    protected String customMsgID;
    protected int state;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer total;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer number;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar submitTime;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar doneTime;
    protected String originResult;
    protected String reserve;

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
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
     * Gets the value of the msgID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgID() {
        return msgID;
    }

    /**
     * Sets the value of the msgID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgID(String value) {
        this.msgID = value;
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
     * Gets the value of the total property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * Sets the value of the total property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTotal(Integer value) {
        this.total = value;
    }

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumber(Integer value) {
        this.number = value;
    }

    /**
     * Gets the value of the submitTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSubmitTime() {
        return submitTime;
    }

    /**
     * Sets the value of the submitTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSubmitTime(XMLGregorianCalendar value) {
        this.submitTime = value;
    }

    /**
     * Gets the value of the doneTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDoneTime() {
        return doneTime;
    }

    /**
     * Sets the value of the doneTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDoneTime(XMLGregorianCalendar value) {
        this.doneTime = value;
    }

    /**
     * Gets the value of the originResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginResult() {
        return originResult;
    }

    /**
     * Sets the value of the originResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginResult(String value) {
        this.originResult = value;
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
