package company.model.beans;

public class FaceitUser {
    private String nickname;
    private String avatarURL;
    private String country;
    private int skillLevel;
    private int ELO;
    private String gamePlayerName;
    private String language;

    public FaceitUser(String nickname, String avatarURL, String country, int skillLevel, int ELO, String gamePlayerName, String language) {
        this.nickname = nickname;
        this.avatarURL = avatarURL;
        this.country = country;
        this.skillLevel = skillLevel;
        this.ELO = ELO;
        this.gamePlayerName = gamePlayerName;
        this.language = language;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    public int getELO() {
        return ELO;
    }

    public void setELO(int ELO) {
        this.ELO = ELO;
    }

    public String getGamePlayerName() {
        return gamePlayerName;
    }

    public void setGamePlayerName(String gamePlayerName) {
        this.gamePlayerName = gamePlayerName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
