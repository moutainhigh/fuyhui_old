
package com.fujfu.common.information.smslib;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfMessageData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfMessageData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MessageData" type="{http://www.139130.net}MessageData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfMessageData", propOrder = {
    "messageData"
})
public class ArrayOfMessageData {

    @XmlElement(name = "MessageData", nillable = true)
    protected List<MessageData> messageData;

    /**
     * Gets the value of the messageData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the messageData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessageData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MessageData }
     * 
     * 
     */
    public List<MessageData> getMessageData() {
        if (messageData == null) {
            messageData = new ArrayList<MessageData>();
        }
        return this.messageData;
    }

}
