package com.santidev.selectpaymentmethod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    PayManager payManager = new PayManager(new MasterCard());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        Button    btnPay = (Button) findViewById(R.id.btnPay);
        RelativeLayout main = (RelativeLayout) findViewById(R.id.main);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                RadioButton payOption = (RadioButton) findViewById(checkedId);

                switch (payOption.getId()){
                    case R.id.paypal:
                        payManager = new PayManager(new PayPal());
                        break;
                    case R.id.visa:
                        payManager = new PayManager(new Visa());
                        break;
                    case R.id.master_card:
                        payManager = new PayManager(new MasterCard());
                        break;
                }
            }
        });

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String messagePay = payManager.doPay(299.99);
                Snackbar.make(view, messagePay, BaseTransientBottomBar.LENGTH_SHORT).show();
            }
        });

       /* RadioButton rbPaypal = (RadioButton) findViewById(R.id.paypal);
        RadioButton rbVisa = (RadioButton) findViewById(R.id.visa);
        RadioButton rbMaster = (RadioButton) findViewById(R.id.master_card); */



    }
}