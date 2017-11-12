package com.mbradley.restfulservice;

public class Validator {
	
	private Offer offerToValidate = null;

	public Validator(Offer offer)
	{
		this.offerToValidate = offer;
	}
	
	public String validateOffer()
	{
		String error = null;
		
		if (offerToValidate.getOfferID() == null)
			error = "You must specify the 'offerID'!";
		else if (offerToValidate.getOfferDesc() == null)
			error = "You must specify the 'offerDesc'!";
		else if (offerToValidate.getCurrencyCd() == null)
			error = "You must specify the 'currencyCd'!";
		else if (offerToValidate.getOfferPrice() == null)
			error = "You must specify the 'offerPrice'!";
		else if (offerToValidate.getStartDtTm() == null)
			error = "You must specify the 'startDtTm'!";
		else if (offerToValidate.getEndDtTm() == null)
			error = "You must specify the 'endDtTm'!";
		else if (offerToValidate.getStartDtTm().after(offerToValidate.getEndDtTm()))
			error = "The 'startDtTm' must not be after the 'endDtTm'";
		
		return error;
	}
	
}
