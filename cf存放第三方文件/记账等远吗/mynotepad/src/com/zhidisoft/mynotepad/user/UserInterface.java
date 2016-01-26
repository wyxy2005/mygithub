package com.zhidisoft.mynotepad.user;

import java.text.ChoiceFormat;
import java.util.ArrayList;
import java.util.List;

import com.zhidisoft.mynotepad.R;
import com.zhidisoft.mynotepad.R.layout;
import com.zhidisoft.mynotepad.adapter.ViewPagerAdapter;
import com.zhidisoft.mynotepad.fg.FgAccount;
import com.zhidisoft.mynotepad.fg.FgBill;
import com.zhidisoft.mynotepad.fg.FgNoteBook;

import android.R.color;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class UserInterface extends FragmentActivity {

	
	/**
	 * viewpager��س�Ա����
	 */
	private ViewPager viewpager;
	private ViewPagerAdapter viewadapter;
	private List<Fragment> list;
	private FragmentManager fm;
	private FgAccount faccount;
	private FgBill fbill;
	private FgNoteBook fnotebook;
	/**
	 * userinfo-bottom��س�Ա����
	 */
	private View xian_account,xian_bill,xian_note;
	private RelativeLayout notebook_layout,bill_layout,account_layout;
	private TextView text_notebook,text_account,text_bill;
	
	
	private MypagerLister pagerlister;
	private MyReLayoutLister relayoutlister;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_interface);
		initView();
		init();
		initState();
		
	}
	/**
	 * ʵ����userinfo
	 */
	
	private void initView(){
		viewpager=(ViewPager)findViewById(R.id.viewpager);
		notebook_layout=(RelativeLayout)findViewById(R.id.notebook_layout);
		bill_layout=(RelativeLayout)findViewById(R.id.bill_layout);
		account_layout=(RelativeLayout)findViewById(R.id.account_layout);
		text_notebook=(TextView)findViewById(R.id.text_notebook);
		text_account=(TextView)findViewById(R.id.text_account);
		text_bill=(TextView)findViewById(R.id.text_bill);
		xian_account=findViewById(R.id.xian_account);
		xian_bill=findViewById(R.id.xian_bill);
		xian_note=findViewById(R.id.xian_note);
		/**
		 * �����ע���Զ��������
		 */
		pagerlister=new MypagerLister();
		viewpager.setOnPageChangeListener(pagerlister);
		relayoutlister=new MyReLayoutLister();
		notebook_layout.setOnClickListener(relayoutlister);
		bill_layout.setOnClickListener(relayoutlister);
		account_layout.setOnClickListener(relayoutlister);
		
		
	}
	/**
	 * ʵ����fragment
	 */
	private void init(){
		fm=getSupportFragmentManager();
		faccount=new FgAccount();
		fbill=new FgBill();
		fnotebook=new FgNoteBook();
		list=new ArrayList<Fragment>();
		list.add(fnotebook);
		list.add(fbill);
		list.add(faccount);
		viewadapter=new ViewPagerAdapter(fm, list);
		viewpager.setAdapter(viewadapter);
	}
	
	private void initState(){
		 text_notebook.setTextColor(text_notebook.getResources().getColor(R.color.black));
		 xian_note.setBackgroundColor(xian_note.getResources().getColor(R.color.blues));
		 viewpager.setCurrentItem(0);
	}
	
	
	private class MypagerLister implements OnPageChangeListener{

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
			if(arg0==2){
				int resourceAndVnum=viewpager.getCurrentItem();
				clearChoicked();
				changechoicked(resourceAndVnum);
			}
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onPageSelected(int arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	private  class MyReLayoutLister implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			clearChoicked();
			changechoicked(v.getId());
		}
		
	}
	
	
     private  void clearChoicked(){
    	 text_notebook.setTextColor(text_notebook.getResources().getColor(R.color.black));
    	 text_bill.setTextColor(text_bill.getResources().getColor(R.color.black));
    	 text_account.setTextColor(text_account.getResources().getColor(R.color.black));
    	 xian_note.setBackgroundColor(xian_note.getResources().getColor(R.color.btom_line));
    	 xian_bill.setBackgroundColor(xian_bill.getResources().getColor(R.color.btom_line));
    	 xian_account.setBackgroundColor(xian_account.getResources().getColor(R.color.btom_line));
	}

	public void changechoicked(int resourceAndVnum) {
		
		switch (resourceAndVnum) {
		case R.id.notebook_layout:case 0:
			text_notebook.setTextColor(text_notebook.getResources().getColor(R.color.blues));
			xian_note.setBackgroundColor(xian_note.getResources().getColor(R.color.blues));
			viewpager.setCurrentItem(0);
			break;
		case R.id.bill_layout:case 1:
			text_bill.setTextColor(text_bill.getResources().getColor(R.color.blues));
			xian_bill.setBackgroundColor(xian_note.getResources().getColor(R.color.blues));
			viewpager.setCurrentItem(1);
			break;
		case R.id.account_layout:case 2:
			text_account.setTextColor(text_account.getResources().getColor(R.color.blues));
			xian_account.setBackgroundColor(xian_note.getResources().getColor(R.color.blues));
			viewpager.setCurrentItem(2);
			break;

		default:
			break;
		}
	}
	
 
	
	
}
