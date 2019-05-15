package kr.co.sist;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	@GetMapping(value="/")
	public String indexMove() {
		return "redirect:index.html"; 
	}
	@GetMapping(value="/index")
	public String index() {
		return "index"; 
	}
	@GetMapping(value="/method/get")
	public String getProcess(String name) {
		System.out.println("get방식의 요청"+name);
		return "get"; 
	}
	@PostMapping(value="/method/post")
	public String postProcess() {
		System.out.println("post방식의 요청");
		return "post"; 
	}
	@ResponseBody
	@PutMapping(value="/method/put/{id}", produces="application/json;charset=UTF-8")
	public String putProcess(@RequestBody String param_json) {
		System.out.println("put방식의 요청");
		System.out.println(param_json);
		
//		try {
//			param=(JSONObject) jp.
//		}
		
		JSONObject json=new JSONObject();
		json.put("id", "kim");
		json.put("password", "1234");
		json.put("name", "노진경");
		
		return json.toJSONString(); 
	}
	
}
