package company.controller.auth;

import company.model.data.DAO;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(DAO.getInstance().login(username,password,"users")){
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            resp.sendRedirect("home.jsp");
        }else {
            resp.setStatus(403);
            resp.sendRedirect("index.jsp");
        }

    }
}
