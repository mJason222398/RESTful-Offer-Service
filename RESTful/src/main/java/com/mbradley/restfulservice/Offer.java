package com.mbradley.restfulservice;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "offer")
public class Offer {

	private String offerID;
	private String offerDesc;
	private String currencyCd;
	private Double offerPrice;
	private Date startDtTm;
	private Date endDtTm;
	private boolean isCancelled = false;

	
	public Offer()
	{
	}
	
	public Offer(String offerID, String offerDesc, String currencyCd, double offerPrice, Date startDtTm, Date endDtTm)
	{
		this.offerID = offerID;
		this.offerDesc = offerDesc;
		this.currencyCd = currencyCd;
		this.offerPrice = offerPrice;
		this.startDtTm = startDtTm;
		this.endDtTm = endDtTm;
	}
	
	public String getOfferID() {
		return offerID;
	}

	@XmlElement
	public void setOfferID(String offerID) {
		this.offerID = offerID;
	}

	public String getOfferDesc() {
		return offerDesc;
	}

	@XmlElement
	public void setOfferDesc(String offerDesc) {
		this.offerDesc = offerDesc;
	}
	
	public String getCurrencyCd() {
		return currencyCd;
	}

	@XmlElement
	public void setCurrencyCd(String currencyCd) {
		this.currencyCd = currencyCd;
	}

	public Double getOfferPrice() {
		return offerPrice;
	}

	@XmlElement
	public void setOfferPrice(Double offerPrice) {
		this.offerPrice = offerPrice;
	}

	public Date getStartDtTm() {
		return startDtTm;
	}

	@XmlElement
	public void setStartDtTm(Date startDtTm) {
		this.startDtTm = startDtTm;
	}

	public Date getEndDtTm() {
		return endDtTm;
	}

	@XmlElement
	public void setEndDtTm(Date endDtTm) {
		this.endDtTm = endDtTm;
	}

	public boolean isCancelled() {
		return isCancelled;
	}

	@XmlElement
	public void setCancelled(boolean isCancelled) {
		this.isCancelled = isCancelled;
	}
	
	@Override
	public String toString() {
		return new StringBuffer(" Offer ID : ").append(this.offerID)
				.append(", Offer Desc : ").append(this.offerDesc)
				.append(", Offer Price : ").append(this.offerPrice)
				.append(", Offer Start Date : ").append(this.startDtTm)
				.append(", Offer End Date : ").append(this.endDtTm)
				.toString();
	}

}
