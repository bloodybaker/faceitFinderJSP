package company.model.parsers;

import company.model.beans.Championship;
import company.model.beans.FaceitUser;
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
        return new FaceitUser(
                (String)jo.get("nickname"),
                (String)jo.get("avatar"),
                (String)jo.get("country"),
                4,
                1490,
                "With love",
                "ru");
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
                    (String)object.get("name"),
                    (String)object.get("status"),
                    (String)object.get("region"),
                    String.valueOf((long)object.get("slots")),
                    String.valueOf((long)object.get("checkin_start")),
                    String.valueOf((long)join.get("min_skill_level")),
                    String.valueOf((long)join.get("max_skill_level"))
            ));

        }
        return list;
    }
}
