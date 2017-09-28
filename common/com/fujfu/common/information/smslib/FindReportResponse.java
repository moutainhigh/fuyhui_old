
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
 *         &lt;element name="FindReportResult" type="{http://www.139130.net}ArrayOfMTReport" minOccurs="0"/>
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
    "findReportResult"
})
@XmlRootElement(name = "FindReportResponse")
public class FindReportResponse {

    @XmlElement(name = "FindReportResult")
    protected ArrayOfMTReport findReportResult;

    /**
     * Gets the value of the findReportResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMTReport }
     *     
     */
    public ArrayOfMTReport getFindReportResult() {
        return findReportResult;
    }

    /**
     * Sets the value of the findReportResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMTReport }
     *     
     */
    public void setFindReportResult(ArrayOfMTReport value) {
        this.findReportResult = value;
    }

}
