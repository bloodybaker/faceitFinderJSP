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

    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException {
        String username = req.getParameter("name");
        try {
            faceitUser = FaceitAPIController.faceitAPIController().getUser(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        List<String> userdata = new ArrayList<>();
        userdata.add(faceitUser.getNickname());
        userdata.add(faceitUser.getAvatarURL());
        userdata.add(faceitUser.getCountry());
        userdata.add(String.valueOf(faceitUser.getSkillLevel()));
        userdata.add(String.valueOf(faceitUser.getELO()));
        userdata.add(faceitUser.getGamePlayerName());
        userdata.add(faceitUser.getLanguage());
        PrintWriter out = response.getWriter();
        out.print(gson.toJson(userdata));
        out.flush();
        out.close();
    }
}
