
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
 *         &lt;element name="PostGroupResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "postGroupResult"
})
@XmlRootElement(name = "PostGroupResponse")
public class PostGroupResponse {

    @XmlElement(name = "PostGroupResult")
    protected int postGroupResult;

    /**
     * Gets the value of the postGroupResult property.
     * 
     */
    public int getPostGroupResult() {
        return postGroupResult;
    }

    /**
     * Sets the value of the postGroupResult property.
     * 
     */
    public void setPostGroupResult(int value) {
        this.postGroupResult = value;
    }

}
