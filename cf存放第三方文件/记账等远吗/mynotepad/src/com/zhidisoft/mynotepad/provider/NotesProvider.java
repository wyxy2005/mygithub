package com.zhidisoft.mynotepad.provider;

import java.util.regex.Matcher;









import com.zhidisoft.mynotepad.database.DBOpenHelper;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class NotesProvider extends ContentProvider{

	//����һ��urimatcherƥ�����
	public  static UriMatcher matcher=new UriMatcher(UriMatcher.NO_MATCH);
    //�����ȡȫ�����±����ݳɹ��ı�ʾ
	public static final int NOTES=1;
	//�����ȡ�������²����ݳɹ��ı�ʾ
	public static final int NOTE=2;
	//���徲̬����飬���ע������ƥ���uri
	/**
	 * ����1������д��Ҫ���ŵı�׼��
	 * ����2����׼��Ӧ�ı���
	 * ����3��ƥ��ɹ��󷵻صı�ʾ��#����ͨ���
	 */
	static{
		matcher.addURI("com.zhidisoft.mynotepad.noteprovider", "note", NOTES);
		matcher.addURI("com.zhidisoft.mynotepad.noteprovider", "note/#", NOTE);
	}
	
	private DBOpenHelper dbopenhelper;
	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		dbopenhelper=new DBOpenHelper(this.getContext(), "", null, 1);
		return false;
	}

	/**
	 * 5-4����ѯ��¼
	 * ע��db.query()������Ӧ��������
	 * ���и��ֲ�����˼���£��������ĳ�����������ã�����ָ��Ϊnull����
����   	table���������൱��select���from�ؼ��ֺ���Ĳ��֡�����Ƕ�����ϲ�ѯ�������ö��Ž����������ֿ���<br>
����    	columns��Ҫ��ѯ�������������൱��select���select�ؼ��ֺ���Ĳ��֡�<br>
����		selection����ѯ�����Ӿ䣬�൱��select���where�ؼ��ֺ���Ĳ��֣��������Ӿ�����ʹ��ռλ��"?"<br>
����		selectionArgs����Ӧ��selection�����ռλ����ֵ��ֵ�������е�λ����ռλ��������е�λ�ñ���һ�£�����ͻ����쳣��<br>
����		groupBy���൱��select���groupby�ؼ��ֺ���Ĳ���<br>
        having���൱��select���having�ؼ��ֺ���Ĳ���<br>
       	orderBy���൱��select���orderby�ؼ��ֺ���Ĳ���<br>
       	limit��ָ��ƫ�����ͻ�ȡ�ļ�¼�����൱��select���limit�ؼ��ֺ���Ĳ���<br>
	 * 
	 */
	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		SQLiteDatabase db=dbopenhelper.getWritableDatabase();
		switch (matcher.match(uri)) {
		case NOTES:
			return db.query("note", null, null, null, null, null, null);
			
		case NOTE:
			long id=ContentUris.parseId(uri);
			String where="id= "+id;
			return db.query("note", null, where, null, null, null, null);
			
		

		default:
			throw new IllegalArgumentException("Unkwon Uri:" + uri.toString());
		}
		
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		switch (matcher.match(uri)) {
		case NOTES:
			   return "vnd.android.cursor.dir/note";  
		case NOTE:
			 return "vnd.android.cursor.item/note";  
		
		default:
			 throw new IllegalArgumentException("Unkwon Uri:" + uri.toString());  
		}
		
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		SQLiteDatabase db=dbopenhelper.getWritableDatabase();
		switch (matcher.match(uri)) {
		case NOTES:
			long row=db.insert("note", null, values);
			Uri newUri=ContentUris.withAppendedId(uri, row);
			return newUri;
		case NOTE:
			long row2=db.insert("note", null, values);
			String stUri=uri.toString();
			stUri=stUri.substring(0, stUri.lastIndexOf("/"))+row2;
			return Uri.parse(stUri);
		default:
			 throw new IllegalArgumentException("Unkwon Uri:" + uri.toString());  
		}
		
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		SQLiteDatabase db=dbopenhelper.getWritableDatabase();
		switch (matcher.match(uri)) {
		case NOTES:
			return db.delete("note", null, null);
		case NOTE:
			long id=ContentUris.parseId(uri);
			String where="id= "+id;
			int e=db.delete("note", where, null);
			return e;

		default:
			throw new IllegalArgumentException("Unkwon Uri:" + uri.toString());
		}
		
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		SQLiteDatabase db=dbopenhelper.getWritableDatabase();
		switch (matcher.match(uri)) {
		case NOTES:
			return db.update("note", values, null, null);
		case NOTE:
			String where="id= "+ContentUris.parseId(uri);
			int e=db.update("note", values, where, null);
			return e;
		default:
			throw new IllegalArgumentException("Unkwon Uri:" + uri.toString());
		}
		
	}

}
