package jdbc;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/registration")
public class registration extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String latitude = request.getParameter("latitude");
        String longitude = request.getParameter("longitude");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        try{

            String sql = "INSERT INTO registration(latitude,longitude,name,password) VALUE (?,?,?,?)";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/location", "root", "");

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,latitude);
            ps.setString(2,longitude);
            ps.setString(3,name);
            ps.setString(4,password);
            ps.executeUpdate();

            if(latitude.isEmpty() || longitude.isEmpty() || name.isEmpty() ||
                    password.isEmpty())
            {
                RequestDispatcher req = request.getRequestDispatcher("registration.jsp");
                req.include(request, response);
            }
            else
            {
                RequestDispatcher req = request.getRequestDispatcher("login.jsp");
                req.forward(request, response);
            }



        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
