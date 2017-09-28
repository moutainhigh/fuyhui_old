
package com.fujfu.common.information.smslib;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BindChannel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BindChannel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ChannelNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Carrier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SendType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BindChannel", propOrder = {
    "channelNum",
    "carrier",
    "sendType"
})
public class BindChannel {

    @XmlElement(name = "ChannelNum")
    protected String channelNum;
    @XmlElement(name = "Carrier")
    protected String carrier;
    @XmlElement(name = "SendType")
    protected String sendType;

    /**
     * Gets the value of the channelNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChannelNum() {
        return channelNum;
    }

    /**
     * Sets the value of the channelNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChannelNum(String value) {
        this.channelNum = value;
    }

    /**
     * Gets the value of the carrier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarrier() {
        return carrier;
    }

    /**
     * Sets the value of the carrier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarrier(String value) {
        this.carrier = value;
    }

    /**
     * Gets the value of the sendType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSendType() {
        return sendType;
    }

    /**
     * Sets the value of the sendType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSendType(String value) {
        this.sendType = value;
    }

}
