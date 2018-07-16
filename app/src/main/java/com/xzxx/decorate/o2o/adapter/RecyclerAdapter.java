package com.xzxx.decorate.o2o.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xzxx.decorate.o2o.bean.Order;
import com.xzxx.decorate.o2o.master.R;
import java.util.List;

/**
 * Created by zf on 2018/7/16
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> implements View.OnClickListener {

    @Override
    public void onClick(View v) {

    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private List<Order> list;
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;

    private LinearLayout ll_all_order_just_pay; //立即支付
    private LinearLayout ll_all_order_contact;  //联系师傅
    private LinearLayout ll_order_just_comment; //立即评价
    private LinearLayout ll_order_look_comment; //查看评价
    private LinearLayout ll_order_cancel;       //取消订单
    private LinearLayout ll_order_start_chat;   //发起微聊

    public RecyclerAdapter(Context context, List<Order> data) {
        mContext = context;
        list = data;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_listview_allorder, parent, false);

        return new RecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        if (list != null && list.size() > 0) {
            Order order = list.get(position);
            if (order != null) {
                holder.master_name_text.setText(order.getMaster_name());
//                Glide.with(mContext)
//                        .load(order.getMaster_photo())
//                        .into(holder.master_photo_image);
                holder.master_title_text.setText(order.getMaster_title());
                if (order.getOrder_state() == 0) { //待服务

                } else if (order.getOrder_state() == 1) { //服务中

                } else if (order.getOrder_state() == 2) { //待支付

                } else if (order.getOrder_state() == 3) { //已完成 未评价

                } else if (order.getOrder_state() == 4) {  //已完成 已评价

                } else if(order.getOrder_state() == 5) {  //售后服务已申请

                } else if(order.getOrder_state() == 6) {  //售后服务处理中

                } else if(order.getOrder_state() == 7) {  //售后服务退款中

                } else if(order.getOrder_state() == 8) { //售后服务已完成

                }
                holder.order_name_text.setText(order.getOrder_name());
                holder.order_date_text.setText(order.getOrder_date());
                holder.order_address_text.setText(order.getOrder_address());
                holder.order_price_text.setText(order.getOrder_price() + "");

                holder.itemView.setTag(position);

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mOnItemClickListener.onItemClick(position);
                    }
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView master_name_text;
        private ImageView master_photo_image;
        private TextView master_title_text;
        private TextView order_name_text;
        private TextView order_date_text;
        private TextView order_address_text;
        private TextView order_price_text;

        private LinearLayout ll_all_order_delete; //已完成，删除订单
        private LinearLayout ll_all_order_in_service; //订单服务中
        private LinearLayout ll_all_order_send_to_headquarters; //发给总部
        private LinearLayout ll_all_order_completed; //服务完成


        public ViewHolder(View itemView) {
            super(itemView);
            master_name_text = itemView.findViewById(R.id.id_master_name);
            master_photo_image = itemView.findViewById(R.id.id_master_photo);
            master_title_text = itemView.findViewById(R.id.id_master_title);
            order_name_text = itemView.findViewById(R.id.order_name);
            order_date_text = itemView.findViewById(R.id.order_date);
            order_address_text = itemView.findViewById(R.id.order_address);
            order_price_text = itemView.findViewById(R.id.order_price);

            ll_all_order_delete = itemView.findViewById(R.id.ll_all_order_delete);
            ll_all_order_in_service = itemView.findViewById(R.id.ll_all_order_in_service);
            ll_all_order_send_to_headquarters = itemView.findViewById(R.id.ll_all_order_send_to_headquarters);
            ll_all_order_completed = itemView.findViewById(R.id.ll_all_order_completed);
        }
    }
}
