package com.xzxx.decorate.o2o.master;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by zf on 2018/7/13.
 * 首页
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout rl_pause_receipt;
    private ImageView image_personal_center;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rl_pause_receipt = findViewById(R.id.rl_pause_receipt);
        image_personal_center = findViewById(R.id.image_personal_center);
        initEvent();
    }

    private void initEvent() {
        rl_pause_receipt.setOnClickListener(this);
        image_personal_center.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_pause_receipt:
                final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.show();
                alertDialog.setContentView(R.layout.dialog_suspend_receipt);
                Window window = alertDialog.getWindow();
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawableResource(android.R.color.white);
                window.setGravity(Gravity.BOTTOM);
                window.setWindowAnimations(R.style.AlertDialog_AppCompat);
                break;
            case R.id.image_personal_center:
                Intent personalIntent = new Intent(this,PersonalCenterActivity.class);
                startActivity(personalIntent);
                break;
        }
    }
}
