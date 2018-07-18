package com.xzxx.decorate.o2o.master;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

/**
 * Created by zf on 2018/7/18.
 * 提现记录
 */
public class BalanceRecordActivity extends AppCompatActivity {

    private ListView lv_balance_record;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lv_balance_record = findViewById(R.id.lv_balance_record);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private class RecordAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }
    }
}
