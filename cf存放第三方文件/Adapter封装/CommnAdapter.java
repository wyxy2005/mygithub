package com.*;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;

public abstract class CommonAdapter<T> extends BaseAdapter{
    protected LayoutInflater mInflater;
    protected Context mContext;
    protected List<T> mDatas;

    public CommonAdapter(Context context, List<T> mDatas){
	mInflater = LayoutInflater.from(context);
	this.mContext = context;
	this.mDatas = mDatas;
    }

    @Override public int getCount(){
	return mDatas.size;
    }

    @Override Object getItem(int position){
	return mDatas.get(position);
    }

    @Override long getItemId(int position){
	return position;
    }

    @Override public View getView(int position, View convertView
				  ,ViewGroup parent){
	final ViewHolder viewHolder = 
	    getViewHolder(posiiton, convertView,parent);
	convert(viewHolder, getItem(position));
	return viewHolder.getContentView();
    }

    public abstract void convert(ViewHolder helper, T item);

    private ViewHolder getViewHolder(int position, View convertView,
				     ViewGroup parent){
	return ViewHolder.get(mContext, covertView, mItemLayoutId, position);
    }
	

}