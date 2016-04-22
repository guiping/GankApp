package so.lvy.app.gankapp.view.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import so.lvy.app.gankapp.R;
import so.lvy.app.gankapp.bean.GankAppEntity;
import so.lvy.app.gankapp.utils.DataUtils;
import so.lvy.app.gankapp.utils.ImageLoaderUtils;

/**
 * @author gping  email: gping.vip@gmail.com
 * @date Created by 2016/4/20.19:44
 * @filename GankAllDataRecycleViewAdapter.class
 * @description
 * @TODO
 */
public class GankAllDataRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<GankAppEntity> mList;
    private LayoutInflater mInflater;
    private Context mContext;

    public enum SHOW_TYPE {
        TYPE_VIDEO, TYPE_IMG, TYPE_TEXT
    }

    public static final int VIDEOTYPE = SHOW_TYPE.TYPE_VIDEO.ordinal();
    public static final int IMGTYPE = SHOW_TYPE.TYPE_IMG.ordinal();
    public static final int TEXTTYPE = SHOW_TYPE.TYPE_TEXT.ordinal();

    public GankAllDataRecycleViewAdapter(Context context, List<GankAppEntity> list) {
        super();
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
        this.mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == SHOW_TYPE.TYPE_IMG.ordinal()) {   //加载图片
            return new ImgViewHolder(mInflater.inflate(R.layout.item_gankapp_img, parent, false));
        } else if (viewType == SHOW_TYPE.TYPE_VIDEO.ordinal()) {   //带视频的Item
            return null
                    ;
        } else {
            return new TextViewHolder(mInflater.inflate(R.layout.item_gankapp_text, parent, false));
        }
    }

    private int showType() {
        return SHOW_TYPE.TYPE_TEXT.ordinal();
    }

    @Override
    public int getItemViewType(int position) {
        GankAppEntity gae = mList.get(position);
        if (gae.getType().contains("休息视频")) {
            return SHOW_TYPE.TYPE_VIDEO.ordinal();
        } else if (gae.getType().contains("福利")) {
            return SHOW_TYPE.TYPE_IMG.ordinal();
        } else {
            return SHOW_TYPE.TYPE_TEXT.ordinal();
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final GankAppEntity gankAppEntity = mList.get(position);
        if (holder instanceof TextViewHolder) {
            TextViewHolder textHolder = (TextViewHolder) holder;
            Log.e("TAG--", gankAppEntity.getDesc() + "---" + gankAppEntity.getWho());
            textHolder.descTv.setText(gankAppEntity.getDesc());
            textHolder.whoTv.setText("@" + gankAppEntity.getWho());
            textHolder.publishedAtTv.setText(DataUtils.toDateString(gankAppEntity.getPublishedAt()));
//            if (Build.VERSION.SDK_INT >= 23) {
//                textHolder.cardView.setOnContextClickListener(new View.OnContextClickListener() {
//                    @Override
//                    public boolean onContextClick(View v) {
//                        if (itemRecycleViewListener != null) {
//                            Log.e("TAG","图片区点击事件---》》》");
//                            itemRecycleViewListener.onItemRecycleViewListener(SHOW_TYPE.TYPE_TEXT.ordinal(), gankAppEntity);
//                        }
//                        return true;
//                    }
//                });
//            } else {
                textHolder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (itemRecycleViewListener != null) {
                            Log.e("TAG","图片区点击事件-2222222222222--》》》");
                            itemRecycleViewListener.onItemRecycleViewListener(SHOW_TYPE.TYPE_TEXT.ordinal(), gankAppEntity);
                        }
                    }
                });
//            }
        } else if (holder instanceof ImgViewHolder) {
            ImgViewHolder imgHolder = (ImgViewHolder) holder;
            Log.e("TAG--", gankAppEntity.getDesc() + "---" + gankAppEntity.getWho());
            imgHolder.descTv.setText(gankAppEntity.getDesc());
            imgHolder.whoTv.setText("@" + gankAppEntity.getWho());
            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);
            imgHolder.itemIv.setBackgroundColor(Color.argb(204, red, green, blue));
            imgHolder.itemIv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemRecycleViewListener != null) {
                        itemRecycleViewListener.onItemRecycleViewListener(SHOW_TYPE.TYPE_IMG.ordinal(), gankAppEntity);
                    }
                }
            });
            ImageLoaderUtils.imageLoader(mContext, imgHolder.itemIv, gankAppEntity.getUrl());
            imgHolder.publishedAtTv.setText(DataUtils.toDateString(gankAppEntity.getPublishedAt()));
        }
    }


    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public class TextViewHolder extends RecyclerView.ViewHolder {
        private TextView descTv;
        private TextView whoTv;
        private TextView publishedAtTv;
        private CardView cardView;

        public TextViewHolder(View itemView) {
            super(itemView);
            descTv = (TextView) itemView.findViewById(R.id.tv_desc);
            whoTv = (TextView) itemView.findViewById(R.id.tv_who);
            publishedAtTv = (TextView) itemView.findViewById(R.id.tv_publishedAt);
            cardView = (CardView) itemView.findViewById(R.id.item_alldate_cardview);
        }
    }

    public class ImgViewHolder extends RecyclerView.ViewHolder {
        private TextView descTv;
        private TextView whoTv;
        private TextView publishedAtTv;
        private ImageView itemIv;

        public ImgViewHolder(View itemView) {
            super(itemView);

            descTv = (TextView) itemView.findViewById(R.id.tv_desc);
            whoTv = (TextView) itemView.findViewById(R.id.tv_who);
            publishedAtTv = (TextView) itemView.findViewById(R.id.tv_publishedAt);
            itemIv = (ImageView) itemView.findViewById(R.id.item_iv);

        }
    }

    public interface OnItemRecycleViewListener {
        void onItemRecycleViewListener(int type, GankAppEntity gankAppEntity);
    }

    private OnItemRecycleViewListener itemRecycleViewListener;

    public void setOnItemRecycleViewListener(OnItemRecycleViewListener onItemRecycleViewListener) {
        this.itemRecycleViewListener = onItemRecycleViewListener;
    }
}
