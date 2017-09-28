
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
 *         &lt;element name="GetResponseResult" type="{http://www.139130.net}ArrayOfMTResponse" minOccurs="0"/>
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
    "getResponseResult"
})
@XmlRootElement(name = "GetResponseResponse")
public class GetResponseResponse {

    @XmlElement(name = "GetResponseResult")
    protected ArrayOfMTResponse getResponseResult;

    /**
     * Gets the value of the getResponseResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMTResponse }
     *     
     */
    public ArrayOfMTResponse getGetResponseResult() {
        return getResponseResult;
    }

    /**
     * Sets the value of the getResponseResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMTResponse }
     *     
     */
    public void setGetResponseResult(ArrayOfMTResponse value) {
        this.getResponseResult = value;
    }

}
