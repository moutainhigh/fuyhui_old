
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
 *         &lt;element name="PostResult" type="{http://www.139130.net}GsmsResponse" minOccurs="0"/>
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
    "postResult"
})
@XmlRootElement(name = "PostResponse")
public class PostResponse {

    @XmlElement(name = "PostResult")
    protected GsmsResponse postResult;

    /**
     * Gets the value of the postResult property.
     * 
     * @return
     *     possible object is
     *     {@link GsmsResponse }
     *     
     */
    public GsmsResponse getPostResult() {
        return postResult;
    }

    /**
     * Sets the value of the postResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GsmsResponse }
     *     
     */
    public void setPostResult(GsmsResponse value) {
        this.postResult = value;
    }

}
