package kr.co.sist.dao;

import org.springframework.stereotype.Component;

import kr.co.sist.domain.ItemDomain;

@Component
public class ItemDAOImpl implements ItemDAO {

	@Override
	public ItemDomain selectItem(String name) throws NumberFormatException {
		return new ItemDomain("IT_T001",name+"자신감있는 태도, 해박한 전문지식, 출신대학+포장기술");
	}//selectItem

}//class
