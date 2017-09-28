
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
 *         &lt;element name="GetAccountInfoResult" type="{http://www.139130.net}AccountInfo" minOccurs="0"/>
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
    "getAccountInfoResult"
})
@XmlRootElement(name = "GetAccountInfoResponse")
public class GetAccountInfoResponse {

    @XmlElement(name = "GetAccountInfoResult")
    protected AccountInfo getAccountInfoResult;

    /**
     * Gets the value of the getAccountInfoResult property.
     * 
     * @return
     *     possible object is
     *     {@link AccountInfo }
     *     
     */
    public AccountInfo getGetAccountInfoResult() {
        return getAccountInfoResult;
    }

    /**
     * Sets the value of the getAccountInfoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountInfo }
     *     
     */
    public void setGetAccountInfoResult(AccountInfo value) {
        this.getAccountInfoResult = value;
    }

}
