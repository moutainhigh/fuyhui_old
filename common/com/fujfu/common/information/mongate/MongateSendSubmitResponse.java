
package com.fujfu.common.information.mongate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MongateSendSubmitResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "mongateSendSubmitResult"
})
@XmlRootElement(name = "MongateSendSubmitResponse")
public class MongateSendSubmitResponse {

    @XmlElement(name = "MongateSendSubmitResult")
    protected String mongateSendSubmitResult;

    /**
     * Gets the value of the mongateSendSubmitResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMongateSendSubmitResult() {
        return mongateSendSubmitResult;
    }

    /**
     * Sets the value of the mongateSendSubmitResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMongateSendSubmitResult(String value) {
        this.mongateSendSubmitResult = value;
    }

}
