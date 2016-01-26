package com.zhidisoft.mynotepad.activity;


import com.zdp.aseo.content.AseoZdpAseo;
import com.zhidisoft.mynotepad.R;
import com.zhidisoft.mynotepad.R.id;
import com.zhidisoft.mynotepad.R.layout;
import com.zhidisoft.mynotepad.otheresactivity.UserRegist;
import com.zhidisoft.mynotepad.user.UserInterface;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	private Button directlogin_btn;
	
	private TextView nonum_text;
	private EditText name_text,password_text;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.directlogin_btn:
			Intent intent=new Intent(MainActivity.this, UserInterface.class);
			MainActivity.this.startActivity(intent);
			break;
		case R.id.nonum_text:
			Intent intents=new Intent(MainActivity.this, UserRegist.class);
			MainActivity.this.startActivity(intents);
			break;

		default:
			break;
		}
	}


	private void init(){
		AseoZdpAseo.initFinalTimer(this, AseoZdpAseo.BOTH_TYPE);
		directlogin_btn=(Button)findViewById(R.id.directlogin_btn);
		directlogin_btn.setOnClickListener(this);
		nonum_text=(TextView) findViewById(R.id.nonum_text);
		nonum_text.setOnClickListener(this);
	}
	@Override
	public void onBackPressed() 
	{
		AseoZdpAseo.init(this, AseoZdpAseo.SCREEN_TYPE);
		Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.addCategory(Intent.CATEGORY_HOME);
		startActivity(intent);
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==1){
			switch (resultCode) {
			case RESULT_OK:
				Toast.makeText(MainActivity.this, "第二个页面返回的文件名：" + data.getStringExtra("fname"), Toast.LENGTH_SHORT).show();
				break;

			default:
				break;
			}
		}
		
	}
}
