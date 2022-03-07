package com.santidev.selectpaymentmethod;

import android.content.Context;
import android.view.View;

public class PayManager {

    private Pay payMethod;

    public PayManager(Pay payMethod){
        this.payMethod = payMethod;
    }

    public String doPay(double price){
        return this.payMethod.pay(price);
    }
}
