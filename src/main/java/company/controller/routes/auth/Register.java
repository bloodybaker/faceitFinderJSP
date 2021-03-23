package company.controller.routes.auth;

import company.model.data.DAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Register extends HttpServlet{
    private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException, IOException {
        String firstName = req.getParameter("first_name");
        String lastName = req.getParameter("last_name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(!firstName.isEmpty() && !lastName.isEmpty() && !username.isEmpty() &&
                !password.isEmpty())
        {
            if(DAO.getInstance().register(firstName,lastName,username,password,"users")){
                response.sendRedirect("index.jsp");
            }else{
                response.sendRedirect("register.jsp");
            }
        }
    }

}
