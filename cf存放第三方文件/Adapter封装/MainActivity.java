package *.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.app.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity{
    private ListView mListView;
    private List<String> mDatas = 
	new ArrayList<String>(Arrays.asList("Hello","world","Welcome"));
    private MyAdapter mAdapter;

    @Override protected void onCreate(Bundle savedInstanceState){
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	mListView = (ListView) findViewById(R.id.id_lv_main);
	
	mListView.setAdapter(mAdapter = 
	  new CommonAdapter<String>(getApplicationContext(),
			       mDatas, R.layout.item_single_str){
				 Textview view = viewHolder.getView(R.id.id_tv_title);
				 view.setTextView(item);	 


       }							      

    }

}