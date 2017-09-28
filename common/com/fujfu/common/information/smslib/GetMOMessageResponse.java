
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
 *         &lt;element name="GetMOMessageResult" type="{http://www.139130.net}ArrayOfMOMsg" minOccurs="0"/>
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
    "getMOMessageResult"
})
@XmlRootElement(name = "GetMOMessageResponse")
public class GetMOMessageResponse {

    @XmlElement(name = "GetMOMessageResult")
    protected ArrayOfMOMsg getMOMessageResult;

    /**
     * Gets the value of the getMOMessageResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMOMsg }
     *     
     */
    public ArrayOfMOMsg getGetMOMessageResult() {
        return getMOMessageResult;
    }

    /**
     * Sets the value of the getMOMessageResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMOMsg }
     *     
     */
    public void setGetMOMessageResult(ArrayOfMOMsg value) {
        this.getMOMessageResult = value;
    }

}
