<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>添加商品</title>
</head>
<body>
	<form action="/Webpro_T/ProductServlet" method="post">
		    商品名称:<input type="text" name="name" value="${product.name}"/><br />
		    商品价格:<input type="text" name="price" value="${product.price}" /><br />
		    商品备注:<input type="text" name="remark" value="${product.remark}"/><br />
		 <button type="submit">更新</button>
		 <input type="hidden" name="type" value="update" />
		 <!-- request如果获取不到数据,则才会去session,最后到application. 如果都没有则返回""字符串 -->
		 <input type="hidden" name="id" value="${requestScope.product.id}" />		 
	</form>
</body>
</html>