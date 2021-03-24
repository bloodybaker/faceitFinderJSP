package company.model.parsers;

import company.model.beans.Championship;
import company.model.beans.FaceitUser;
import company.model.beans.Rank;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParserJSON {
    public FaceitUser createSearchedUser(String json) throws ParseException {
        Object obj = new JSONParser().parse(json);
        JSONObject jo = (JSONObject) obj;
        JSONObject temp = (JSONObject) jo.get("games");
        JSONObject gameObj = (JSONObject) temp.get("csgo");
        JSONObject languageObj = (JSONObject) jo.get("settings");
        return new FaceitUser(
                (String)jo.get("nickname"),
                (String)jo.get("avatar"),
                (String)jo.get("country"),
                Math.toIntExact((Long) gameObj.get("skill_level")),
                Math.toIntExact((Long) gameObj.get("faceit_elo")),
                (String)gameObj.get("game_player_name"),
                (String)languageObj.get("language"),
                (String)gameObj.get("game_player_id"));
    }

    public List<Championship> getChampionships(String json) throws ParseException {
        List<Championship> list = new ArrayList<>();
        Object obj = new JSONParser().parse(json);
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray content = (JSONArray) jsonObject.get("items");
        Iterator i = content.iterator();
        while (i.hasNext()) {
            JSONObject object = (JSONObject) i.next();
            JSONObject join = (JSONObject) object.get("join_checks");
            list.add(new Championship(
                    (String) object.get("name"),
                    (String) object.get("status"),
                    (String) object.get("region"),
                    String.valueOf((long) object.get("slots")),
                    (long) object.get("checkin_start"),
                    String.valueOf((long) join.get("min_skill_level")),
                    String.valueOf((long) join.get("max_skill_level"))
            ));

        }
        return list;
    }
    public List<Rank> getranks(String json) throws ParseException {
        List<Rank> list = new ArrayList<>();
        Object obj = new JSONParser().parse(json);
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray content = (JSONArray) jsonObject.get("items");
        Iterator i = content.iterator();
        while (i.hasNext()) {
            JSONObject object = (JSONObject) i.next();
            list.add(new Rank(
                    String.valueOf((long)object.get("position")),
                    (String)object.get("nickname"),
                    String.valueOf((long)object.get("game_skill_level")),
                    String.valueOf((long)object.get("faceit_elo")),
                    (String)object.get("country")
            ));

        }
        return list;
    }
}
