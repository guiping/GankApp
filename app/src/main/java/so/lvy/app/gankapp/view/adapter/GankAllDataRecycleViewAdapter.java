package so.lvy.app.gankapp.view.adapter;

import android.content.Context;
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
import so.lvy.app.gankapp.utils.ImageLoaderUtils;

/**
 * @author gping  email: gping.vip@gmail.com
 * @date Created by 2016/4/20.19:44
 * @filename GankAllDataRecycleViewAdapter.class
 * @description
 * @TODO
 */
public class GankAllDataRecycleViewAdapter extends RecyclerView.Adapter<GankAllDataRecycleViewAdapter.ViewHolder> {
    private List<GankAppEntity> mList;
    private LayoutInflater mInflater;
    private Context mContext;

    public GankAllDataRecycleViewAdapter(Context context, List<GankAppEntity> list) {
        super();
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
        this.mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mInflater.inflate(R.layout.item_gankapp_alldata, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        GankAppEntity gankAppEntity = mList.get(position);
        Log.e("TAG--",gankAppEntity.getDesc()+"---"+gankAppEntity.getWho());
        holder.descTv.setText(gankAppEntity.getDesc()+"   @"+gankAppEntity.getWho());
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView descTv;
        public ViewHolder(View itemView) {
            super(itemView);
            descTv = (TextView) itemView.findViewById(R.id.tv_desc);
        }
    }
}
