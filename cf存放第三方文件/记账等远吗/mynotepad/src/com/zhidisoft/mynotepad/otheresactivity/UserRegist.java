package com.zhidisoft.mynotepad.otheresactivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



import com.zdp.aseo.content.AseoZdpAseo;
import com.zhidisoft.mynotepad.R;

public class UserRegist extends Activity {

	private EditText regist_ID, re_password, rer_password;
	private Button regist_btn;
	// ע����ip
	private static final String URLS ="http://192.168.1.252:8080/mymoney/index.do?m=user&a=reg";
     
	String result="";
	int code;
	String mess;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.useregist);
		init();
		regist_btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final Handler handler=new Handler(){
					@Override
					public void handleMessage(Message msg) {
						// TODO Auto-generated method stub
						super.handleMessage(msg);
						switch (msg.what) {
						case 1:
							parser(result);
							if(code==1){
								
								Toast.makeText(UserRegist.this, mess, Toast.LENGTH_LONG).show();
							}
							else {
								Toast.makeText(UserRegist.this, mess, Toast.LENGTH_LONG).show();
								
							}
							break;

						default:
							break;
						}
					}
				};
				
				new Thread(){
					public void run() {
						getContent();
						Message mes=new Message();
						mes.what=1;
						handler.sendMessage(mes);
					};
				}.start();
			}
		});
	}

	

	private void init() {
		regist_btn = (Button) findViewById(R.id.regist_btn);
		regist_ID = (EditText) findViewById(R.id.regist_ID);
		re_password = (EditText) findViewById(R.id.re_password);
		AseoZdpAseo.initType(this, AseoZdpAseo.INSERT_TYPE);
	}

	private void getContent() {
		OutputStream out=null;
		InputStreamReader in = null;
		HttpURLConnection conn=null;
		try {
			URL url=new URL(URLS);
			//��url������HttpURLConnection�����Ӷ���
			conn=(HttpURLConnection) url.openConnection();
			//��������ʽ
			conn.setRequestMethod("POST");
			//ϵͳĬ��������������Ϣ��
			conn.setDoInput(true);
			//�������������Ϣ��
			conn.setDoOutput(true);
			//������������ʣ���Ϣ���ݵ�����
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			 //�������ݵı����ʽ
            conn.setRequestProperty("Charset", "utf-8");
            String data = "username=" + URLEncoder.encode(regist_ID.getText().toString().trim(), "UTF-8")  
                    + "&password=" + URLEncoder.encode(re_password.getText().toString().trim(), "UTF-8");//���ݵ�����
            //����������Ϣ�����鳤��
            conn.setRequestProperty("Content-Length",String.valueOf(data.getBytes().length)); 
            //5����ȡ����� 
           out=conn.getOutputStream();
           out.write(data.getBytes());
           out.flush();
           
           
           /**
            * ��ȡ��Ӧ�ĵ���Ϣ
            */
           //��ȡ��Ӧ��Ϣ��������ת�����ַ�����
           in=new InputStreamReader(conn.getInputStream());
           BufferedReader reader=new BufferedReader(in);
           String st="";
           while ((st=reader.readLine())!=null) {
			result=result+st;
		}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				conn.disconnect();
			}
		}
	}

	private void parser(String result) {

		try {
			JSONObject obj= new JSONObject(result);
			 code=Integer.valueOf(obj.getString("code").toString());
			 mess=obj.getString("msg").toString();
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
