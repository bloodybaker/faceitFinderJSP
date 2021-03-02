package company.controller.api;

import org.steambuff.SteamApi;
import org.steambuff.exception.SteamApiException;
import org.steambuff.method.SteamId;
import org.steambuff.method.steamuser.entity.PlayerSummaries;

import java.util.NoSuchElementException;

public class SteamAPIController {
   /* public void getSteamData() throws SteamApiException, NoSuchElementException {
        SteamApi steamApi = SteamApi.getInstance("KEY");
        SteamId steamId = new SteamId(76561198201241926);
        PlayerSummaries playerSummaries = steamApi.getSteamUserInterface()
                .getPlayerSummaries(steamId).orElseThrow();
        System.out.println("Result: " + playerSummaries.getDisplayName());
    }

    */
}
