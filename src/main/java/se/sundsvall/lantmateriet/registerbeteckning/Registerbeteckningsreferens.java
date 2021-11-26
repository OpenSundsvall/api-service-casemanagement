package se.sundsvall.lantmateriet.registerbeteckning;

public class Registerbeteckningsreferens {

    @Override
    public String toString() {
        return "Registerbeteckningsreferens [beteckning=" + beteckning + ", beteckningsid=" + beteckningsid
                + ", registerenhet=" + registerenhet + "]";
    }

    private String beteckningsid;
    private String registerenhet;
    private String beteckning;

    public String getBeteckningsid() {
        return beteckningsid;
    }

    public void setBeteckningsid(String beteckningsid) {
        this.beteckningsid = beteckningsid;
    }

    public String getRegisterenhet() {
        return registerenhet;
    }

    public void setRegisterenhet(String registerenhet) {
        this.registerenhet = registerenhet;
    }

    public String getBeteckning() {
        return beteckning;
    }

    public void setBeteckning(String beteckning) {
        this.beteckning = beteckning;
    }

}
