package cn.web.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.GroupLayout.Alignment;
import javax.xml.transform.Templates;

import cn.web.model.Product;
import cn.web.service.ProductServiceImpl;


@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
    //doget只能接受get请求
	ProductServiceImpl productService =new ProductServiceImpl();
	//String keyword = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		doPost(request, response);
	}
	//doget只能接受post请求
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		// 根据不同的type的值,来进行不同的判断操作
		HttpSession session = request.getSession();
		System.out.println("session" + session.getId());
		String type = request.getParameter("type");
		if (type.equals("save")) {
			// 前端的所有请求数据,都被封装到request对象中(体现了封装的思想)
			// request可以通过form表单里面指定的名称来获取数据
			String name = request.getParameter("name");
			String price = request.getParameter("price");
			String remark = request.getParameter("remark");
			Product product = new Product();
			product.setName(name);
			product.setPrice(new BigDecimal(price));
			product.setRemark(remark);
			productService.save(product);
			// 返回页面(1:重定向,2:跳转)
			response.sendRedirect("/Webpro_T/query.jsp");
		} else if (type.equals("query")) {
			// 1:获取前端数据
			String keyword = null;
			keyword = request.getParameter("keyword");
			// 2:调用业务逻辑
			List<Product> products = productService.queryByName(keyword);
			// System.out.println(proList.size());
			// 3: 返回页面(结果数据)
			// 1: web中提供了 request,session,application用来存储数据
			request.setAttribute("products", products);
			session.setAttribute("keyword", keyword);
			// 2: 如果重定向则不能共享request中的数据,但是转发可以,转发默认自带工程名
			// response.sendRedirect("/webpro/query.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/query.jsp");
			// 在转发过程中,共用了之前request,repseon
			dispatcher.forward(request, response);
		} else if (type.equals("getById")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Product product = productService.getById(id);
			// 把查询的结果保存到request中,并跳转到update.jsp页面(原始数据要回显)
			request.setAttribute("product", product);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/update.jsp");
			dispatcher.forward(request, response);
		} else if (type.equals("update")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String price = request.getParameter("price");
			String remark = request.getParameter("remark");
			Product product = new Product();
			product.setName(name);
			product.setPrice(new BigDecimal(price));
			product.setRemark(remark);
			product.setId(id); // 如果没有指定id则默认id=0 不会报错但是更新失败
			productService.update(product);
			// 跳转到目标页面
			response.sendRedirect("/Webpro_T/query.jsp");
		} else if (type.equals("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			productService.Delete(id);
			String keyword = (String) session.getAttribute("keyword");
			System.out.println("实现删除功能,删除成功后按照原来的关键字进行查询操作!");
			List<Product> products = productService.queryByName(keyword);
			request.setAttribute("products", products);
			// 2: 如果重定向则不能共享request中的数据,但是转发可以,转发默认自带工程名
			// response.sendRedirect("/webpro/query.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/query.jsp");
			dispatcher.forward(request, response);
			
		}
	}

}
