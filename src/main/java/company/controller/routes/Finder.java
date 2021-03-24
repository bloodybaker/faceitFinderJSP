package company.controller.routes;

import com.google.gson.Gson;
import company.controller.api.FaceitAPIController;
import company.model.beans.FaceitUser;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/finder")
public class Finder extends HttpServlet {
    private FaceitUser faceitUser;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException {
        System.out.println("Executed");
        String username = req.getParameter("name");
        try {
            faceitUser = FaceitAPIController.faceitAPIController().getUser(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> userdata = new ArrayList<>();
        userdata.add(faceitUser.getNickname());
        userdata.add(faceitUser.getAvatarURL());
        userdata.add(faceitUser.getCountry());
        userdata.add(String.valueOf(faceitUser.getSkillLevel()));
        userdata.add(String.valueOf(faceitUser.getELO()));
        userdata.add(faceitUser.getGamePlayerName());
        userdata.add(faceitUser.getLanguage());
        userdata.add(faceitUser.getSteamLink());

        String json = new Gson().toJson(userdata);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
