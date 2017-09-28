
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
 *         &lt;element name="SetMediasResult" type="{http://www.139130.net}ArrayOfMediaItems" minOccurs="0"/>
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
    "setMediasResult"
})
@XmlRootElement(name = "SetMediasResponse")
public class SetMediasResponse {

    @XmlElement(name = "SetMediasResult")
    protected ArrayOfMediaItems setMediasResult;

    /**
     * Gets the value of the setMediasResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMediaItems }
     *     
     */
    public ArrayOfMediaItems getSetMediasResult() {
        return setMediasResult;
    }

    /**
     * Sets the value of the setMediasResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMediaItems }
     *     
     */
    public void setSetMediasResult(ArrayOfMediaItems value) {
        this.setMediasResult = value;
    }

}
