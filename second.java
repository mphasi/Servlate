
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet.*;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/second")
public class second extends GenericServlet 
{
public void init() 
{
	System.out.println("init");
}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String a=req.getParameter("t1");
		String b=req.getParameter("t2");
		String c=req.getParameter("t3");
		String d=req.getParameter("t4");
		
		pw.println("the name is  "+   a);
		pw.println("the address is"+  b);
		pw.println("the email is"+  c);
		pw.println("the phone is"+  d);
		//PrintWriter pw1 = res.getWriter();
	//	pw1.write("name=" +a+ "address=" +b+ "email=" +c+ "phone no=" +c);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // load the driver into the memory
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			PreparedStatement st=con.prepareStatement("insert into employee1 values(?,?,?,?)");
			st.setString(1,a);st.setString(2,b);st.setString(3,c);st.setString(4,d);
			st.execute();
			pw.print("row inserted");
		}
		
		catch(Exception ae)
		{
			ae.printStackTrace();
		}
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // load the driver into the memory
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			PreparedStatement st=con.prepareStatement("delete from employee1 where name=sanada");
			st.setString(1,a);st.setString(2,b);st.setString(3,c);st.setString(4,d);
			st.execute();
			pw.print("row delete");
		}
		
		catch(Exception ae)
		{
			ae.printStackTrace();
		}
	}
	public void destroy() 
	{
	System.out.println("destroy");	
	}

}
