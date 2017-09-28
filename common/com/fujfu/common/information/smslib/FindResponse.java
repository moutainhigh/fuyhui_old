
package com.fujfu.common.information.smslib;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="account" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="batchid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mobile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pageindex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="flag" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "account",
    "password",
    "batchid",
    "mobile",
    "pageindex",
    "flag"
})
@XmlRootElement(name = "FindResponse")
public class FindResponse {

    protected String account;
    protected String password;
    protected String batchid;
    protected String mobile;
    protected int pageindex;
    protected int flag;

    /**
     * Gets the value of the account property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccount() {
        return account;
    }

    /**
     * Sets the value of the account property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccount(String value) {
        this.account = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the batchid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBatchid() {
        return batchid;
    }

    /**
     * Sets the value of the batchid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBatchid(String value) {
        this.batchid = value;
    }

    /**
     * Gets the value of the mobile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Sets the value of the mobile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobile(String value) {
        this.mobile = value;
    }

    /**
     * Gets the value of the pageindex property.
     * 
     */
    public int getPageindex() {
        return pageindex;
    }

    /**
     * Sets the value of the pageindex property.
     * 
     */
    public void setPageindex(int value) {
        this.pageindex = value;
    }

    /**
     * Gets the value of the flag property.
     * 
     */
    public int getFlag() {
        return flag;
    }

    /**
     * Sets the value of the flag property.
     * 
     */
    public void setFlag(int value) {
        this.flag = value;
    }

}
