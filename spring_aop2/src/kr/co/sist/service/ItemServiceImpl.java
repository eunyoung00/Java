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

}//class
