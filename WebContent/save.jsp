<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
程序员
<form action="/Webpro_T//ProductServlet"method="post")>
         商品名称：<input type="text" name="name"/><br />
         商品价格：<input type="text" name="price"/><br />
         商品备注：<input type="text" name="remark"/><br />
   <button type="submit">提交</button>      
   <input type="hidden" name="type" value="save"/>
	

</form>
<%=request.getAttribute("products") %>
</body>
</html>