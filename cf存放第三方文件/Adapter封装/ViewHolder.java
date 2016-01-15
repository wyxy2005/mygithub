package com.example.zhy_baseadapterhelper;  
  
import android.content.Context;  
import android.util.Log;  
import android.util.SparseArray;  
import android.view.LayoutInflater;  
import android.view.View;  
import android.view.ViewGroup;  

public class ViewHolder
{
    private final SparseArray<View> mViews;
    private View mConvertView;
    
    private ViewHolder(Context context, ViewGroup parent, int layoutId,
		       int position)
    {
	this.mViews = new SparseArray<View>();
	mConvertView = LayoutInflater.from(context).inflate(layoutId, parent,
							    false);
	// setTag
	mConvertView.setTag(this);
    }

    /** �õ�һ��ViewHolder���� */
    public static ViewHolder get(Context context, View convertView,
				 ViewGroup parent, int layoutId, int position)
    {
	if(convertView == null)
	    {
		return new ViewHolder(context, parent, layoutId, position);
	    }
	return (ViewHolder)convertView.getTag();
    }

    /** ͨ���ؼ���ID��ȡ���ڵĿؼ�, ���û�������views */
    public <T extends View> T getView(int viewId) {
	View view = mViews.get(viewId);
	if(view == null) {
	    view = mConvertView.findViewById(viewId);
	    mViews.put(viewId, view);
	}
	return (T) view;
    } 

    public View getConvertView(){
	return mCovertView;
    }


    /** ΪTextView�����ַ��� */
    public ViewHolder setText(int viewId, String text){
	TextView view = getView(viewId);
	view.setText(text);
	return this;
    }

    /** ΪImageView����ͼƬ */
    public ViewHolder setImageResource(int viewId, int drawableId){
	ImageView view = getView(viewId);
	view.setImageResource(drawableId);
	return this;
    }

    /** ΪImageView����ͼƬ */
    public ViewHolder setImageResource(int viewId Bitmap bm){
	ImageView = getView(viewId);
	view.setImageBitmap(bm);
	return this;
    }

    public ViewHolder setImageByUrl(int viewId, String url){
	ImageLoader.getInstance(3, Type.LIFO).loadImage(url,
							(ImageView)getView(viewId);
    }


	    public int getPostion(){
	    return mPosition;
	}


}
