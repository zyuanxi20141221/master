package com.xzxx.decorate.o2o.master;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by zf on 2018/7/15.
 * 个人中心页面
 */
public class PersonalCenterActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout rl_personal_orders;
    private RelativeLayout rl_personal_wallet;
    private RelativeLayout rl_personal_setting;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_personal);
        rl_personal_orders = findViewById(R.id.rl_personal_orders);
        rl_personal_wallet = findViewById(R.id.rl_personal_wallet);
        rl_personal_setting = findViewById(R.id.rl_personal_setting);
        initEvent();
    }

    private void initEvent() {
        rl_personal_orders.setOnClickListener(this);
        rl_personal_wallet.setOnClickListener(this);
        rl_personal_setting.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_personal_orders:

                break;
            case R.id.rl_personal_wallet:

                break;
            case R.id.rl_personal_setting:

                break;
        }
    }
}
