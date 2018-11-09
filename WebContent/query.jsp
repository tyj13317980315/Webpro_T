<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>商品查询</title>
</head>
<body>
	<form action="/Webpro_T/ProductServlet" method="get">
		    商品名称:<input type="text" name="keyword"/><br />
		 <button type="submit">给我搜</button>
		 <input type="hidden" name="type" value="query"/>
	</form>
	<!--<%=request.getAttribute("products") %> -->
	<!-- jsp目前不推荐使用%（可维护性差），可以采用jstl标签来显示数据 -->
	<table border="1" width="700">
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>价格</th>
			<th>备注</th>
			<th>操作</th>
		</tr>
		<!-- item是标签的属性,接受集合或者数组  EL表达式，可以获取request session application数据 -->
		<!-- 集合中每个对象都存储在var变量中 -->
		<c:forEach items="${requestScope.products}" var="product">
			<tr>
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.price}</td>
				<td>${product.remark}</td>
				<td><a href="/Webpro_T/ProductServlet?type=getById&id=${product.id}">更新</a>|
				   <a href="/Webpro_T/ProductServlet?type=delete&id=${product.id}">删除</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>