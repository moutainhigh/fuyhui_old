
package com.fujfu.common.information.smslib;

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
 *         &lt;element name="GetBusinessTypeResult" type="{http://www.139130.net}ArrayOfBusinessType" minOccurs="0"/>
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
    "getBusinessTypeResult"
})
@XmlRootElement(name = "GetBusinessTypeResponse")
public class GetBusinessTypeResponse {

    @XmlElement(name = "GetBusinessTypeResult")
    protected ArrayOfBusinessType getBusinessTypeResult;

    /**
     * Gets the value of the getBusinessTypeResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfBusinessType }
     *     
     */
    public ArrayOfBusinessType getGetBusinessTypeResult() {
        return getBusinessTypeResult;
    }

    /**
     * Sets the value of the getBusinessTypeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfBusinessType }
     *     
     */
    public void setGetBusinessTypeResult(ArrayOfBusinessType value) {
        this.getBusinessTypeResult = value;
    }

}
