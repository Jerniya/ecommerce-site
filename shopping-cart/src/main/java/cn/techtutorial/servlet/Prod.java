package cn.techtutorial.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.techtutorial.connection.DbCon;
import cn.techtutorial.dao.ProductDao;
import cn.techtutorial.model.Cart;
import cn.techtutorial.model.Product;



/**
 * Servlet implementation class Prod
 */
public class Prod extends HttpServlet {
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prod() {
        super();
        // TODO Auto-generated constructor stub
    }

	/*
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
    
ProductDao pd=new ProductDao(DbCon.getConnection());
            List<Product> pList = new ArrayList<>();
           Product prod = new Product();
           prod.setName(request.getParameter("name"));
            prod.setImage(request.getParameter("url"));
            prod.setPrice(Double.valueOf(request.getParameter("price")));
            prod.setCategory(request.getParameter("category"));
           
           
          
           
            List<Product> p_list = pd.getAllProducts();
            
           
             

                boolean exist = false;
                for (Product c : p_list) {
                    if (c.getName() == prod.getName()) {
                        exist = true;
                        out.println("<h3 style='color:crimson; text-align: center'>Item Already in Products. <a href='prod.jsp'>GO to ADDPRODUCT Page</a></h3>");
                    }
                }

                if (!exist) {

    	            query = "insert into products(name, category, price,image) values(?,?,?,?)";
    	            Connection con=DbCon.getConnection();
    	            pst = con.prepareStatement(query);
    	            pst.setString(1,prod.getName());
    	            pst.setString(2, prod.getCategory());
    	            pst.setDouble(3, prod.getPrice());
    	            pst.setString(4, prod.getImage());
     	           
    	            pst.executeUpdate();
                	
                	response.sendRedirect("prod.jsp");
                }
            }
        
        catch(Exception e) {
        	e.printStackTrace();
        }
        }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
