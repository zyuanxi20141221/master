package com.xzxx.decorate.o2o.master;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.xzxx.decorate.o2o.bean.BandCard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zf on 2018/7/18.
 * 余额提现
 */
public class BalanceActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView id_balance_band_card;
    private TextView id_balance_record;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_balance);
        id_balance_band_card = findViewById(R.id.id_balance_band_card);
        id_balance_record = findViewById(R.id.id_balance_record);

        initEvent();
    }

    private void initEvent() {
        id_balance_band_card.setOnClickListener(this);
        id_balance_record.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_balance_band_card:
                final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.show();
                alertDialog.setContentView(R.layout.dialog_select_to_band_card);
                Window window = alertDialog.getWindow();
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawableResource(android.R.color.white);
                window.setGravity(Gravity.BOTTOM);
                window.setWindowAnimations(R.style.AlertDialog_AppCompat);
                ListView listView = alertDialog.findViewById(R.id.lv_band_card);

                List<BandCard> list = new ArrayList<>();
                BandCard card1 = new BandCard();
                card1.setBandcardname("中国银行");
                card1.setBandcardnumber("3362");
                list.add(card1);

                BandCard card2 = new BandCard();
                card2.setBandcardname("建设银行");
                card2.setBandcardnumber("3609");
                list.add(card2);

                BandCardAdapter adapter = new BandCardAdapter(BalanceActivity.this, list);
                listView.setAdapter(adapter);
                break;
            case R.id.id_balance_record:

                break;
        }
    }

    private class BandCardAdapter extends BaseAdapter {

        private List<BandCard> list;
        private Context mContext;

        public BandCardAdapter(Context context, List<BandCard> list) {
            this.list = list;
            this.mContext = context;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if(convertView == null) {
                viewHolder = new ViewHolder();
                LayoutInflater inflater = LayoutInflater.from(mContext);
                convertView = inflater.inflate(R.layout.item_band_card, null);
                viewHolder.image_bandicon = convertView.findViewById(R.id.item_band_icon);
                viewHolder.text_bandname = convertView.findViewById(R.id.item_band_name);
                viewHolder.text_bandnumber = convertView.findViewById(R.id.item_band_tail_number);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            BandCard bandCard = (BandCard) getItem(position);
            viewHolder.text_bandname.setText(bandCard.getBandcardname());
            viewHolder.text_bandnumber.setText(bandCard.getBandcardnumber());
            return convertView;
        }
    }

    private class ViewHolder {
        private ImageView image_bandicon;
        private TextView text_bandname;
        private TextView text_bandnumber;
    }
}
