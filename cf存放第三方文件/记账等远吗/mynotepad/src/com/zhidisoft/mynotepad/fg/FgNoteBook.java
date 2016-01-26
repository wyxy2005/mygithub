package com.zhidisoft.mynotepad.fg;


import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.zhidisoft.mynotepad.R;
import com.zhidisoft.mynotepad.adapter.ListViewAdapter;
import com.zhidisoft.mynotepad.dbservice.UserService;
import com.zhidisoft.mynotepad.entity.ListViewEntity;
import com.zhidisoft.mynotepad.otheresactivity.AddNoteBook;
import com.zhidisoft.mynotepad.otheresactivity.LookNote;
import com.zhidisoft.mynotepad.xlistviewutil.XListView.IXListViewListener;

public class FgNoteBook extends Fragment implements OnClickListener ,IXListViewListener{

	//�޹ر���
  private static final String LOG_TAG="<<<<<<��־>>>>>>";
	
	private ListView listview;
	private Button add_btn_of_notebook;
	private List<ListViewEntity> list;
	
	private ListViewAdapter adapter;
	private View view;
	private long e;
	
	private MyItemOnClick myItemOnClick;
/**
 * ������ݿ�note������������ñ���
 */
	private UserService service;
	/**
	 * ͨѶ��صı�������
	 */
	private static final int Code_Note = 1;
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		Log.e(LOG_TAG, "����fg��onAttach1=======");
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.e(LOG_TAG, "����fg��onCreate2=======");
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		Log.e(LOG_TAG, "����fg��onActivityCreated4=======");
	}
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.e(LOG_TAG, "����fg��onResume6=======");
	}
	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.e(LOG_TAG, "����fg��onPause7=======");
	}
	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.e(LOG_TAG, "����fg��onStop8=======");
	}
	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
		Log.e(LOG_TAG, "����fg��onDestroyView9=======");
	}
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		init();
		list=findNote();
		adapter = new ListViewAdapter(getActivity(), list);
		listview.setAdapter(adapter);
		Log.e(LOG_TAG, "����fg��onstart5=======");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.fgnotebook, container, false);
		Log.e(LOG_TAG, "����fg��onCreateView3=======");
		return view;
	}

	private void init() {

		listview = (ListView) view.findViewById(R.id.listview);
		add_btn_of_notebook = (Button) view
				.findViewById(R.id.add_btn_of_notebook);
		add_btn_of_notebook.setOnClickListener(this);
		myItemOnClick=new MyItemOnClick();
		listview.setOnItemClickListener(myItemOnClick);
		

	}
	private class MyItemOnClick implements OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			Intent intent =new Intent(getActivity(),LookNote.class);
			Bundle bundle=new Bundle();
			bundle.putSerializable("data", list.get(position));
			intent.putExtras(bundle);
			getActivity().startActivity(intent);
			
		}
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.add_btn_of_notebook:
			Intent intent = new Intent(getActivity(), AddNoteBook.class);
			getActivity().startActivity(intent);

			break;

		default:
			break;
		}
	}

	private List<ListViewEntity> findNote(){
		service=new UserService(getActivity());
		list=service.findAll();
		return list;
		
	}
	private long delNote(String id){
		service=new UserService(getActivity());
		e=service.delect(id);
		
		return e;
		
	}
	
	@Override
	public void onRefresh() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onLoadMore() {
		// TODO Auto-generated method stub
		
	}
}
