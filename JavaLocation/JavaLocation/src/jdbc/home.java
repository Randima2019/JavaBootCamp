package jdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/home")
public class home extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Float lat1 = Float.parseFloat(request.getParameter("latitude1"));
        Float longi1 = Float.parseFloat(request.getParameter("longitude1"));
        Float lat2 = Float.parseFloat(request.getParameter("latitude2"));
        Float longi2 = Float.parseFloat(request.getParameter("longitude2"));


        PrintWriter out = response.getWriter();

        if ((lat1 == lat2) && (longi1 == longi2)) {
            out.println("Same Location");
        } else {
            double theta = longi1 - longi2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            dist = dist * 1.609344;
            out.println("Distance is "+dist+"km");
            dist = dist * 1000;
            out.println("Distance is "+dist+"m");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}
