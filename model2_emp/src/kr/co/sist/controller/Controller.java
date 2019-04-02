package kr.co.sist.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	//HttpServletRequest 를 줌으로 일반 클래스에서도 관계유지 (파일다운, 파라메터 처리) 가 가능하게 된다.
	/**
	 * 요청, 응답처리, 관계유지 객체(Session-서버의 메모리에 저장해 다 저장가능, Cookie-접속자의 정보를 접속자의 HDD에 저장)의 사용
	 * @param request 웹 파라메터 요청처리
	 * @param response 응답처리
	 * @throws ServletException
	 * @throws IOException
	 */
	public void execute(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException;
	
	/**
	 * 처리한 결과를 보여줄 JSP명을 반환
	 * @return
	 */
	public String moveURL();
	/**
	 * 처리한 결과를 보여줄 JSP, HTML로 이동하는 이동 방식을 선정.
	 * @return
	 */
	public boolean isForward();
	
}
