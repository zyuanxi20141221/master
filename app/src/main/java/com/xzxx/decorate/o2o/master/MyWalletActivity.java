package com.xzxx.decorate.o2o.master;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.phillipcalvin.iconbutton.IconButton;

/**
 * Created by zf on 2018/7/18.
 * 我的钱包页面
 */
public class MyWalletActivity extends AppCompatActivity implements View.OnClickListener {

    private IconButton btn_my_wallet_balance;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_my_wallet);
        btn_my_wallet_balance = findViewById(R.id.btn_my_wallet_balance);

        initEvent();
    }

    private void initEvent() {
        btn_my_wallet_balance.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_my_wallet_balance:
                Intent balanceIntent = new Intent(this, BalanceActivity.class);
                startActivity(balanceIntent);
                break;
        }
    }
}
