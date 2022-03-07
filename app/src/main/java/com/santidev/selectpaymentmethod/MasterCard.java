package com.santidev.selectpaymentmethod;



public class MasterCard extends Pay{
    @Override
    public String pay(double price) {
        return "Pay " + price +"$ by MasterCard";
    }
}
