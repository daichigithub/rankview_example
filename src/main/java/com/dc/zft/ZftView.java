package com.dc.zft;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/4/26 0026.
 */

public class ZftView extends RelativeLayout {
    Context mContext;
    View root;
    ZftConfig zftConfig;
    ViewHolder holder;
    public void setZftConfig(ZftConfig zftConfig) {
        this.zftConfig = zftConfig;
    }

    public ZftConfig getZftConfig() {
        return zftConfig;
    }


    public ZftView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public ZftView(Context context,ZftConfig zftConfig/*, int id*/) {
        super(context);
        this.mContext = context;
        setZftConfig(zftConfig);
        init();
    }

    public ZftView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
    }

    public ZftView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        init();
    }

    public void init(){
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        root = mInflater.inflate(R.layout.kh_item, this, false);
        addView(root);

        if (holder == null) {
            holder = new ViewHolder();
        }
        holder.tvRank = (TextView) findViewById(R.id.rankTitle);
        holder.tvValue = (TextView) findViewById(R.id.valueTitle);


        if (zftConfig != null){
            holder.tvRank.setText(zftConfig.rankTitle);
            holder.tvValue.setText(""+zftConfig.value);

            holder.subView = new ZftSubView(mContext, zftConfig);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, 120);
            layoutParams.setMargins(120, 20, 20, 0);
            layoutParams.addRule(RelativeLayout.RIGHT_OF, holder.tvRank.getId());
            holder.subView.setLayoutParams(layoutParams);
            addView(holder.subView);
        }
    }

    class ViewHolder{
        TextView tvRank;
        TextView tvValue;
        ZftSubView subView;
    }
}
