package com.cafe24.bookmall.test;

import java.util.List;

import com.cafe24.bookmall.dao.MemberDao;
import com.cafe24.bookmall.vo.MemberVo;

public class MemberDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		insertTest("ABC", "010-1111-1111", "rk@rk.com", "rk");
		insertTest("DEF", "010-2222-2222", "sk@sk.com", "sk");
		getListTest();
	}
	
	private static void insertTest(String name, String phone, String email, String passwd) {
		MemberVo vo = new MemberVo();
		vo.setName(name);
		vo.setPhone(phone);
		vo.setEmail(email);
		vo.setPasswd(passwd);
		
		new MemberDao().insert(vo);
	}
	
	private static void getListTest() {
		List<MemberVo> list = new MemberDao().getList();
		
		for(MemberVo vo : list) {
			System.out.println(vo);
		}
	}
}
