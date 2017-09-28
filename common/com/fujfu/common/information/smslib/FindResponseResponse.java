
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
 *         &lt;element name="FindResponseResult" type="{http://www.139130.net}ArrayOfMTResponse" minOccurs="0"/>
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
    "findResponseResult"
})
@XmlRootElement(name = "FindResponseResponse")
public class FindResponseResponse {

    @XmlElement(name = "FindResponseResult")
    protected ArrayOfMTResponse findResponseResult;

    /**
     * Gets the value of the findResponseResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMTResponse }
     *     
     */
    public ArrayOfMTResponse getFindResponseResult() {
        return findResponseResult;
    }

    /**
     * Sets the value of the findResponseResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMTResponse }
     *     
     */
    public void setFindResponseResult(ArrayOfMTResponse value) {
        this.findResponseResult = value;
    }

}
