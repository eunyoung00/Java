package kr.co.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.ItemDAO;
import kr.co.sist.domain.ItemDomain;

@Component
public class ItemServiceImpl implements ItemService{
	@Autowired
	private ItemDAO i_dao;
	
	@Override
	public ItemDomain searchItem(String name) {
		System.out.println("------------searchItem 호출되었습니다.");
		return i_dao.selectItem(name);
	}//searchItem

	@Override
	public String getName() {
		String name="김정윤";
		System.out.println("getName///"+name);
		return name;
	}//getName
	
	@Override
	public String getAddr() {
		String addr="서울시 강남구 역삼동";
		
		System.out.println("---DAO---"+i_dao.getDbName());
		System.out.println("getAddr ///////"+addr);
		return addr;
	}//getAddr
	
	@Override
	public int getAge() {
		int age=20;
		System.out.println("getAge-----------"+age);
		return age;
	}//getAge

	@Override
	public ItemDomain searchData(String name) {
		return new ItemDomain("IO_O001", name+" 애벌래,크런커,,,");
	}//searchData

}//class
