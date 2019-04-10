package kr.co.sist.exam.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.sist.exam.domain.CarModel;

public class CarDAO {
	public List<String> selectMaker(String country){
		List<String> list=null;
		//4.Handler얻기
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		
		list=ss.selectList("selectCarCountry", country);
		
		ss.close();
		return list;
	}//selectMaker
	
	public List<String> selectModel(String maker){
		List<String> list=null;
		//4.Handler얻기
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		
		list=ss.selectList("selectCarMaker", maker);
		
		ss.close();
		return list;
	}//selectModel
	
	public List<CarModel> selectDetailModel(String model){
		List<CarModel> list=null;
		//4.Handler얻기
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		
		list=ss.selectList("selectCarModel", model);
		
		ss.close();
		return list;
	}//selectDetailModel
	
	public static void main(String[] args) {
		CarDAO md=new CarDAO();
		//md.selectMaker("국산");
		//md.selectModel("BMW");
		md.selectDetailModel("아반테");
	}//main
	
}//class
