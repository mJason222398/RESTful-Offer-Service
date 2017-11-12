package com.mbradley.restfulservice;

import java.util.HashMap;

public class OffersList {
	
	private HashMap<String, Offer> offerList = null;
	
	public OffersList()
	{
		offerList = new HashMap<String, Offer>();
	}
	
	public Offer getOffer(String id)
	{
		return offerList.get(id);
	}
	
	public void addOffer(Offer offer)
	{
		offerList.put(offer.getOfferID(), offer);
	}
	
	public Offer cancelOffer(String id)
	{
		Offer offer = offerList.get(id);
		if (offer != null)
			offer.setCancelled(true);
		
		return offer;
	}
	
	public boolean offerExists(String id)
	{
		return offerList.containsKey(id);
	}

}
