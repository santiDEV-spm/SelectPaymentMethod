package com.santidev.selectpaymentmethod;



public class PayPal extends Pay{
    @Override
    public String pay(double price) {
        return "Pay " + price +"$ by PayPal";
    }
}
