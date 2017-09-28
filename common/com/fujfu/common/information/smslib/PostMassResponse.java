
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
 *         &lt;element name="PostMassResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "postMassResult"
})
@XmlRootElement(name = "PostMassResponse")
public class PostMassResponse {

    @XmlElement(name = "PostMassResult")
    protected int postMassResult;

    /**
     * Gets the value of the postMassResult property.
     * 
     */
    public int getPostMassResult() {
        return postMassResult;
    }

    /**
     * Sets the value of the postMassResult property.
     * 
     */
    public void setPostMassResult(int value) {
        this.postMassResult = value;
    }

}
