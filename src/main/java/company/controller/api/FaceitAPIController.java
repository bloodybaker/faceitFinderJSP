package company.controller.api;

import company.model.beans.Championship;
import company.model.beans.FaceitUser;
import company.model.data.Constants;
import company.model.parsers.ParserJSON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class FaceitAPIController extends Constants {
   private static FaceitAPIController faceitAPIController;
   private ParserJSON parserJSON = new ParserJSON();

   public FaceitUser getUser(String user) throws Exception{
      URL url = new URL("https://open.faceit.com/data/v4/players?nickname="+ user);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();

      conn.setRequestProperty("Authorization","Bearer " + API_KEY);
      conn.setRequestProperty("Content-Type","application/json");
      conn.setRequestMethod("GET");

      BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      String output;

      StringBuffer response = new StringBuffer();
      while ((output = in.readLine()) != null) {
         response.append(output);
      }
      in.close();
      return parserJSON.createSearchedUser(response.toString());
   }

   public List<Championship> championshipsViewer() throws Exception{

      URL url = new URL("https://open.faceit.com/data/v4/championships?game=csgo");
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();

      conn.setRequestProperty("Authorization","Bearer " + API_KEY);
      conn.setRequestProperty("Content-Type","application/json");
      conn.setRequestMethod("GET");

      BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      String output;

      StringBuffer response = new StringBuffer();
      while ((output = in.readLine()) != null) {
         response.append(output);
      }
      in.close();
      System.out.println("Connected");
      return parserJSON.getChampionships(response.toString());
   }



   public static FaceitAPIController faceitAPIController(){
      if(faceitAPIController == null){
         faceitAPIController = new FaceitAPIController();
      }
      return faceitAPIController;
   }


}
