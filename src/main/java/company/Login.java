package company;

import company.data.DAO;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(DAO.getInstance().login(username,password,"users")){
            Cookie usernameCookie = new Cookie("username",username);
            Cookie firstNameCookie = new Cookie("first_name",DAO.getInstance().getFirstName(username,"users"));
            Cookie lastNameCookie = new Cookie("last_name",DAO.getInstance().getLastName(username,"users"));
            resp.addCookie(usernameCookie);
            resp.addCookie(firstNameCookie);
            resp.addCookie(lastNameCookie);
            resp.sendRedirect("home.jsp");
        }else {
            resp.setStatus(403);
            System.out.println("did not auth");
            resp.sendRedirect("index.jsp");
        }

    }
}
