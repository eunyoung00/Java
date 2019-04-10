package kr.co.sist.exam.service;

import java.util.List;

import kr.co.sist.exam.dao.CarDAO;
import kr.co.sist.exam.domain.CarModel;

public class CarService {
	
	private CarDAO cd;
	public CarService() {
		cd=new CarDAO();
	}//CarService
	
	public List<String> searchMaker(String country){
		List<String> list=null;
		//CarDAO cd=new CarDAO();
		list=cd.selectMaker(country);
		return list;
	}//searchMaker
	
	public List<String> searchModel(String maker){
		List<String> list=null;
		list=cd.selectModel(maker);
		return list;
	}//searchModel
	
	public List<CarModel> searchDetailModel(String model){
		List<CarModel> list=null;
		list=cd.selectDetailModel(model);
		return list;
	}//searchDetailModel
	
}//class
