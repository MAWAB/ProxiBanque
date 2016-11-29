package com.cdyne.ws;

public class ClassTestWebService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DelayedStockQuote stub =new DelayedStockQuote();
		DelayedStockQuoteSoap service=  stub.getDelayedStockQuoteSoap();
		System.out.println(service.getQuote("ac", "0"));
	}

}
