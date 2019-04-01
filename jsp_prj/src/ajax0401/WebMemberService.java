package ajax0401;

import java.sql.SQLException;

import org.json.simple.JSONObject;

public class WebMemberService {
	//업무로직 처리
	public JSONObject searchId(String id) {
		JSONObject json=new JSONObject();
		
		WebMemberDAO wm_dao=WebMemberDAO.getInstance();
		
		boolean flag=false;
		try {
			flag=wm_dao.selectId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
		//DB조회 결과를 JSONObject에 추가
		json.put("idResult", flag);
		
		return json;
	}//searchId
}//class
