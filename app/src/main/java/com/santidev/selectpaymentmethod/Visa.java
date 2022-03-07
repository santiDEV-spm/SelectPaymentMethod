package com.santidev.selectpaymentmethod;


public class Visa extends Pay{
    @Override
    public String pay(double price) {
        return "Pay " + price +"$ by Visa";
    }
}
