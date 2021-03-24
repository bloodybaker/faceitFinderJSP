package company.model.beans;

public class Rank {
    private String position;
    private String nickname;
    private String lvl;
    private String faceitElo;
    private String country;

    public Rank(String position, String nickname, String lvl, String faceitElo, String country) {
        this.position = position;
        this.nickname = nickname;
        this.lvl = lvl;
        this.faceitElo = faceitElo;
        this.country = country;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLvl() {
        return lvl;
    }

    public void setLvl(String lvl) {
        this.lvl = lvl;
    }

    public String getFaceitElo() {
        return faceitElo;
    }

    public void setFaceitElo(String faceitElo) {
        this.faceitElo = faceitElo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
