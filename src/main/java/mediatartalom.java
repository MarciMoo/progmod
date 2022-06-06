public class mediatartalom {
    private String azonosito;
    private String kreator;
    private String name;
    private String ev;
    private MediaTipusEnum tipus;

    public mediatartalom(String azonosito, String kreator, String name, String ev, MediaTipusEnum a) {
        this.azonosito = azonosito;
        this.kreator = kreator;
        this.name = name;
        this.ev = ev;
        tipus = a;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getKreator() {
        return kreator;
    }

    public void setKreator(String kreator) {
        this.kreator = kreator;
    }

    public String getEv() {
        return ev;
    }

    public void setEv(String ev) {
        this.ev = ev;
    }

    public String getID() {
        return azonosito;
    }

    public void setID(String taj) {
        this.azonosito = taj;
    }
    public String getTipus() {
        return tipus.name();
    }

    public void setTipus(int a) {
        switch (a){
            case 1 : tipus = MediaTipusEnum.AUDIO;break;
            case 2 : tipus = MediaTipusEnum.VISUAL;break;
            case 3 : tipus = MediaTipusEnum.AUDIOVISUAL;break;
        }
    }

}
