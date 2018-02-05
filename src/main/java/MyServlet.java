import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
@WebServlet("/My")
public class MyServlet extends HttpServlet
{
    public static DataSource getMysqlDataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
    
        // Set dataSource Properties
        dataSource.setServerName("localhost");
        dataSource.setPortNumber(3306);
        dataSource.setDatabaseName("venkat");
        dataSource.setUser("root");
        dataSource.setPassword("");
        return dataSource;
      }
    
      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id1");
        String name = request.getParameter("name1");
        String desc = request.getParameter("desc1");
        String price = request.getParameter("price1");
        try {
    
          Connection con = getMysqlDataSource().getConnection();
          PreparedStatement ps = con.prepareStatement("insert into product values(?,?,?,?)");
    
          ps.setString(1, id);
          ps.setString(2, name);
          ps.setString(3, desc);
          ps.setString(4, price);
          int i = ps.executeUpdate();
    
        
            out.println("Data Sucessfully Entered");
          
    
        } catch (Exception se) {
          se.printStackTrace();
        }
    
      }
}