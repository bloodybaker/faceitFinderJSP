package company;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Register extends HttpServlet{
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException, IOException {
        String first_name = req.getParameter("first_name");
        String last_name = req.getParameter("last_name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(!first_name.isEmpty() && !last_name.isEmpty() && !username.isEmpty() &&
                !password.isEmpty())
        {
            System.out.println(first_name + " " + last_name + " " + username + " " + password);
            RequestDispatcher reqD = req.getRequestDispatcher("home.jsp");
            reqD.include(req, response);
            response.sendRedirect("home.jsp");
        }
    }

}
