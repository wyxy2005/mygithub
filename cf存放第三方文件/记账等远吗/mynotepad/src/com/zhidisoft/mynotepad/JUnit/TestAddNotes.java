package com.zhidisoft.mynotepad.JUnit;

import com.zhidisoft.mynotepad.dbservice.UserService;
import com.zhidisoft.mynotepad.entity.ListViewEntity;

import android.test.AndroidTestCase;

public class TestAddNotes extends AndroidTestCase {

	private UserService service;
	public void testaddNotes(){
		service=new UserService(this.getContext());
		ListViewEntity ete = new ListViewEntity(
				"����", "����","djsks");
		service.insertNote(ete);
		
	}
}
