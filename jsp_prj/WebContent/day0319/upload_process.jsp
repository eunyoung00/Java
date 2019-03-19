<%@page import="org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException"%>
<%@page import="kr.co.sist.util.HangulConv"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/main_v190130.css"/>
<style type="text/css">
#wrap{margin:0px auto;width:800px; height:860px;}
#header{width:800px; height:140px; background:#FFFFFF url(http://localhost:8080/jsp_prj/common/images/header_bg.png) repeat-x;
		position: relative; }
#headerTitle{font-family: HY견고딕,고딕; font-size:35px; font-weight:bold; text-align:center; 
			/* padding-top: 35px */ position:absolute; top:40px; left:290px; }
#container{width:800px; height:600px; }
#footer{width:800px; height:120px; }
#footerTitle{float: right; font-size:15px; padding-top:20px; padding-right:20px; }
</style>
</head>
<body>
<div id="wrap">
	<div id="header">
		<div id="headerTitle">SIST Class4</div>
	</div>
	<div id="container">
	<!-- enctype="multipart/form-data"인 경우 parameter를 받을 수 없다. -->
	<%-- 이름 : <%=request.getParameter("uploader") %><br/>
	나이 : <%=request.getParameter("age") %> --%>
	<%
	request.setCharacterEncoding("UTF-8");//post방식의 한글처리->파라메터는 영향을 받지 않지만! 파일명에 필요!
	// 파일 업로드에 적합한 요청인지를 얻는다.
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	if(isMultipart){//파일 업로드에 적합한 요청
		File repository=new File("C:/dev/workspace/jsp_prj/WebContent/upload");
		
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// 업로드 파일이 메모리에 저장되는 최대 크기
		factory.setSizeThreshold(1024*1024*1);
		factory.setRepository(repository);

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// 업로드 파일의 최대 크기 설정
		upload.setSizeMax(1024*1024*5);
		
		try{//파일이 너무크면 여기서 에러 발생.
		// Parse the request
		List<FileItem> items = upload.parseRequest(request);
		
		// Process the uploaded items
		// for보다 빠르기 때문
		Iterator<FileItem> iter = items.iterator();
		String uploader="",age="";
		String fieldName="",fileName="",contentType="";
	    long sizeInBytes=0;
		
		while (iter.hasNext()) {
		    FileItem item = iter.next();

		    if (item.isFormField()) {//일반 HTML Form Control인지? <input type="file"이 아닌것>
		    	String controlName = item.getFieldName();
	    	    String controlValue = item.getString();
	    	    /* out.println("컨트롤명 : "+controlName);
	    	    out.println("컨트롤값 : "+HangulConv.toUTF(controlValue)+"<br/>"); */
	    	   	if("uploader".equals(controlName)){
	    	   		uploader=HangulConv.toUTF(controlValue);
	    	   	}//end if
	    	   	if("age".equals(controlName)){
	    	   		age=controlValue;
	    	   	}//end if
	    	    
		    } else {//File Upload Control인지? <input type="file">
	    		fieldName = item.getFieldName();//File Control명
	    	    fileName = item.getName();//File Control값
	    	    contentType = item.getContentType();//업로드한 파일의 종류
	    	    sizeInBytes = item.getSize();//크기
	    	    
	    	    File selectFile=new File(fileName);
	    	    File uploadedFile = new File(repository.getAbsolutePath()+"/"+selectFile.getName());//업로드파일의 저장경로와 파일명을 설정
	    	    item.write(uploadedFile);//설정된 파일을 업로드
	    	    
		    }//end else
		}//end while
		%>
		파일업로드 성공<br/>
		업로더명 : <%=uploader %><br/>
		연령대 : <%=age %><br/>
		업로드 파일명 : <%=fieldName %><br/>
		<%-- file control값 : <%=fileName %><br/>
		업로드 파일 형식 : <%=contentType %><br/> --%>
		크기 : <%=sizeInBytes%>byte<br/>
		<a href="upload_form.jsp">업로드</a><br/>
		<a href="file_list.jsp">파일리스트</a><br/>
		<%
		
		}catch(SizeLimitExceededException slee){
			//브라우저로 출력이 되지 않는다.
			out.println("예외!!!");
		}//end catch
	}else{//파일 업로드에 부적합한 요청(직접->get방식)
		response.sendRedirect("upload_form.jsp");
	}//end else
	%>
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class 4.</div>
	</div>
</div>
</body>
</html>