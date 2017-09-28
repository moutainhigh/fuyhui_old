
package com.fujfu.common.information.smslib;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AccountInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccountInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Account" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Identify" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BizNames" type="{http://www.139130.net}ArrayOfString" minOccurs="0"/>
 *         &lt;element name="Userbrief" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Balance" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Reserve" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountInfo", propOrder = {
    "account",
    "name",
    "identify",
    "bizNames",
    "userbrief",
    "balance",
    "reserve"
})
public class AccountInfo {

    @XmlElement(name = "Account")
    protected String account;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Identify")
    protected String identify;
    @XmlElement(name = "BizNames")
    protected ArrayOfString bizNames;
    @XmlElement(name = "Userbrief")
    protected String userbrief;
    @XmlElement(name = "Balance", required = true)
    protected BigDecimal balance;
    @XmlElement(name = "Reserve")
    protected String reserve;

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
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the identify property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentify() {
        return identify;
    }

    /**
     * Sets the value of the identify property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentify(String value) {
        this.identify = value;
    }

    /**
     * Gets the value of the bizNames property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getBizNames() {
        return bizNames;
    }

    /**
     * Sets the value of the bizNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setBizNames(ArrayOfString value) {
        this.bizNames = value;
    }

    /**
     * Gets the value of the userbrief property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserbrief() {
        return userbrief;
    }

    /**
     * Sets the value of the userbrief property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserbrief(String value) {
        this.userbrief = value;
    }

    /**
     * Gets the value of the balance property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * Sets the value of the balance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBalance(BigDecimal value) {
        this.balance = value;
    }

    /**
     * Gets the value of the reserve property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReserve() {
        return reserve;
    }

    /**
     * Sets the value of the reserve property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReserve(String value) {
        this.reserve = value;
    }

}
