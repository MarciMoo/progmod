import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.Scanner;
import static java.lang.System.out;

public class Main {
    static int kilepes = 10;
    static ArrayList<mediatartalom> media = readMediaFromXml("src/main/resources/mediatartalmak.xml");
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] a) {
        lehetosegek();
    }
    public static void lehetosegek(){
        out.println("\nLehetőségek:" +
                " \n1: Médiatartalmak listázása." +
                "\n2: Médiatartalom felvétele." +
                "\n3: Médiatartalom törlése." +
                "\n4: Médiatartalom módosítás." +
                "\n5: Médiatartalom keresés." +
                "\n6: Médiatartalom szűrés típus alapján." +
                "\n7: Mentés." +
                "\n8: Mentés és Kilépés." +
                "\n9: Bázisolt jelentése.\n");
        out.print("Választás: ");
        String a = sc.nextLine();
        if(a.equals("1")){
            listazas();
        }
        else if(a.equals("2")){
            hozzaad();
        }
        else if(a.equals("3")){
            torles();
        }
        else if(a.equals("4")){
            frissites();
        }
        else if(a.equals("5")){
            kereses();
        }
        else if(a.equals("7")){
            saveMediaToXml(media, "src/main/resources/mediatartalmak.xml");
        }
        else if(a.equals("8")){
            kilepes = 65;
            saveMediaToXml(media, "src/main/resources/mediatartalmak.xml");
        }
        else if(a.equals("9")){
            based();
        }
        else if(a.equals("6")){
            csoport();}
        else {
            out.println("\nA LEHETŐSÉGEK KÖZÜL KELL VÁLASZTANI!\n");
            enter();
            lehetosegek();
        }
    }
    public static void based(){
        out.print("\nbased\n\n" +
                "A word used when you agree with something; or when you want to\n " +
                " recognize someone for being themselves, i.e. courageous \n" +
                " and unique or not caring what others think. Especially common in online political slang.\n" +
                "\n" +
                "The opposite of cringe, some times the opposite of biased.\n" +
                "\n" +
                "The latter usage is the original use as coined by rapper Lil B,\n" +
                " and the word originally took off on the meta-ironic website 4Chan\n" +
                " with the latter meaning. For that reason the word is largely used \n" +
                " meta-ironically (without context you can't tell if it's being used ironically\n" +
                " or sincerely as it's used in both ways) and was popularized in\n" +
                " online political slang of conservatives and the political right\n" +
                " before being adopted into mainstream online political slang\n" +
                " (likely through shitposting websites or subreddits such as r/politicalcompass memes\n" +
                " that are similar to 4chan in their meta-irony and edginess\n" +
                " but contain a wider variety of political beliefs) and\n" +
                " eventually adopted into general online vernacular.\n" +
                "\n" +
                "When used in online political language it can mean based in fact\n" +
                " or the opposite of biased due to the number of people who saw it being\n" +
                " first used seriously by the online political right and came to the conclusion\n" +
                " that is was related to the phrase destroyed with facts and logic\n" +
                " in reference to right wing personality Ben Shapiro.\n\n" +
                "Example 1: meta-ironic\n" +
                "\n" +
                "Shitposter: Posts gif of funny monkey Return to monke\n" +
                "Commentor: Based\n" +
                "\n" +
                "Example 2: meta-ironic\n" +
                "4chan Anon 1: I'm going to commit hate crimes\n" +
                "4chan Anon 2: Based\n" +
                "\n" +
                "Example 3: Politics\n" +
                "Leftist 1: There is no ethical consumption under capitalism.\n" +
                "Leftist 2: Based.\n" +
                "by leftistmonke November 25, 2020\n\n");
        enter();
        lehetosegek();
    }
    public static void enter(){
        System.out.println("Nyomja le az ENTER-t a folytatáshoz...");
        try{System.in.read();}
        catch(Exception e){}
    }
    public static void listazas(){
        int i = 0;
        while(i != media.size()){
            mediatartalom medium = media.get(i);
            out.printf("\n%d. médiatartalom: \n", i+1);
            out.println("Azonosítója: " + medium.getID() + "\nKreátora: " + medium.getKreator()+"\nNeve: " + medium.getName()+ "\nKreálás éve: " + medium.getEv() + "\nTípusa: " + medium.getTipus() + "\n");
            i++;
        }
        enter();
        lehetosegek();
    }
    public static void hozzaad(){
        out.print("Médiatartalom azonosítója: ");
        String azonosito = sc.nextLine();
        out.print("Médiatartalom kreátora: ");
        String kreator = sc.nextLine();
        out.print("Médiatartalom neve: ");
        String nev = sc.nextLine();
        out.print("Médiatartalom kreálás éve: ");
        String ev = sc.nextLine();
        out.print("(1: AUDIO 2: VIZUÁLIS 3: AUDIOVIZUÁLIS)\nMédiatartalom típusa: ");
        String a = sc.nextLine();
        if(a.equals("1") || a.equals("2") ||a.equals("3")) {
            int b = Integer.valueOf(a);
            if(b == 1){
                MediaTipusEnum t = MediaTipusEnum.AUDIO;
                mediatartalom medium = new mediatartalom(azonosito, kreator, nev, ev, t);
                media.add(medium);
                out.println("\nMÉDIATARTALOM SIKERESEN FELVÉVE!\n");
                enter();
                lehetosegek();
            }
            if(b == 2){
                MediaTipusEnum t = MediaTipusEnum.VISUAL;
                mediatartalom medium = new mediatartalom(azonosito, kreator, nev, ev, t);
                media.add(medium);
                out.println("\nMÉDIATARTALOM SIKERESEN FELVÉVE!\n");
                enter();
                lehetosegek();
            }
            if(b == 3){
                MediaTipusEnum t = MediaTipusEnum.AUDIOVISUAL;
                mediatartalom medium = new mediatartalom(azonosito, kreator, nev, ev, t);
                media.add(medium);
                out.println("\nMÉDIATARTALOM SIKERESEN FELVÉVE!\n");
                enter();
                lehetosegek();
            }

        }
        else {
            out.println("\nMÉDIATARTALOM SIKERTELENÜL FELVÉVE!\n");
            enter();
            lehetosegek();
        }
    }
    public static void torles(){
        out.println("Eltávolítandó médiatartalom azonosítója: ");
        String i = sc.nextLine();
        int k = 0;
        for(int j = 0; j < media.size(); j++){
            if(media.get(j).getID().equals(i)){
                media.remove(j);
                k = 1;
                out.println("\nMÉDIATARTALOM SIKERESEN ELTÁVOLÍTVA!\n");
                enter();
                lehetosegek();
            }
            else if(j == (media.size()-1) && k != 1){
                out.println("\nMÉDIATARTALOM SIKERTELENÜL ELTÁVOLÍTVA!\n");
                enter();
                lehetosegek();
            }
        }
    }
    public static void frissites(){
        out.print("\nFrissítendő médiatartalom azonosítója: ");
        String i = sc.nextLine();
        int k = 0;
        for(int j = 0; j < media.size(); j++){
            if(media.get(j).getID().equals(i)) {
                mediatartalom medium = media.get(j);
                out.print("\nA médiartalom frissíthető adatai: \n 1: Azonosítója\n 2: Kreátora\n 3: Neve\n 4: Kreálás éve\n 5: Típusa\nVálasztás: ");
                String b = sc.nextLine();
                if(b.equals("1")){
                    out.print("A módosítás: ");
                    String x = sc.nextLine();
                    medium.setID(x);
                    enter();
                    lehetosegek();
                }
                else if(b.equals("3")){
                    out.print("A módosítás: ");
                    String x = sc.nextLine();
                    medium.setName(x);
                    enter();
                    lehetosegek();
                }
                else if(b.equals("4")){
                    out.print("A módosítás: ");
                    String x = sc.nextLine();
                    medium.setEv(x);
                    enter();
                    lehetosegek();
                }
                else if(b.equals("2")){
                    out.print("A módosítás: ");
                    String x = sc.nextLine();
                    medium.setKreator(x);
                    enter();
                    lehetosegek();
                }
                else if(b.equals("5")){
                    out.print("(1: AUDIO 2: VIZUÁLIS 3: AUDIOVIZUÁLIS)\nA módosítás: ");
                    String x = sc.nextLine();
                    if(x.equals("1") || x.equals("2") ||x.equals("3")){
                        int a = Integer.valueOf(x);
                        medium.setTipus(a);
                        enter();
                        lehetosegek();
                    }
                    else {
                        out.println("\nA LEHETŐSÉGEK KÖZÜL KELL VÁLASZTANI!\n");
                        enter();
                        lehetosegek();
                    }
                }
                else{
                    out.println("\nA LEHETŐSÉGEK KÖZÜL KELL VÁLASZTANI!\n");enter();lehetosegek();
                }
            }
            else if(j == (media.size()-1) && k != 1){
                out.println("\nMÉDIATARTALOM SIKERTELENÜL MÓDOSÍTVA!\nNINCS TALÁLAT A MÉDIATARTALOMRA.\n");
                enter();
                lehetosegek();
            }
        }

    }
    public static void kereses(){
        out.println("Keresett médiatartalom azonosítója: ");
        String i = sc.nextLine();
        int k = 0;
        for(int j = 0; j < media.size(); j++){
            if(media.get(j).getID().equals(i)){
                k = 1;
                mediatartalom medium = media.get(j);
                out.print("\nMÉDIATARTALOM MEGTALÁLVA!\n");
                out.println("\nAzonosítója: " + medium.getID() + "\nKreátora: " + medium.getKreator()+"\nNeve: " + medium.getName()+ "\nKreálás éve: " + medium.getEv() + "\nTípusa: " + medium.getTipus() + "\n");
            }
            else if(j == (media.size()-1) && k != 1){
                out.printf("\nA KERESETT MÉDIATARTALOM NINCS A LISTÁN!\n");
            }
        }
        enter();
        lehetosegek();
    }

    public static void csoport(){
        out.println("Kiválasztás a típus alapján (AUDIO, VISUAL, AUDIOVISUAL): ");
        String s = sc.nextLine();
        if(s.equals("AUDIO") || s.equals("VISUAL") || s.equals("AUDIOVISUAL")){
            for (int i = 0; i < media.size(); i++){
                if(media.get(i).getTipus().equals(s)){
                    mediatartalom medium = media.get(i);
                    out.println("\nAzonosítója: " + medium.getID() + "\nKreátora: " + medium.getKreator()+"\nNeve: " + medium.getName()+ "\nKreálás éve: " + medium.getEv() + "\nTípusa: " + medium.getTipus() + "\n");
                }
            }
        }
        enter();
        lehetosegek();
    }

    public static ArrayList<mediatartalom> readMediaFromXml(String filepath) {
        ArrayList<mediatartalom> media = new ArrayList<>();
        try{
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(filepath);
            Element rootElement = document.getDocumentElement();
            NodeList childNodesList = rootElement.getChildNodes();
            Node node;
            for (int i = 0; i < childNodesList.getLength(); i++) {
                node = childNodesList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    NodeList childNodesOfUserTag = node.getChildNodes();
                    String azonosito = "", kreator = "",name = "", ev = "", tipus = "";
                    for (int j = 0; j < childNodesOfUserTag.getLength(); j++) {
                        if (childNodesOfUserTag.item(j).getNodeType() == Node.ELEMENT_NODE) {
                            switch (childNodesOfUserTag.item(j).getNodeName()) {
                                case "azonosito" : azonosito = childNodesOfUserTag.item(j).getTextContent();
                                case "kreator" : kreator = childNodesOfUserTag.item(j).getTextContent();
                                case "name" : name = childNodesOfUserTag.item(j).getTextContent();
                                case "ev" : ev = childNodesOfUserTag.item(j).getTextContent();
                                case "tipus" : tipus = childNodesOfUserTag.item(j).getTextContent();
                            }
                        }
                    }
                    media.add(new mediatartalom(azonosito, kreator, name, ev, MediaTipusEnum.valueOf(tipus)));
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return media;
    }

    public static void saveMediaToXml(ArrayList<mediatartalom> media, String filepath) {
        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element rootElement = document.createElement("media");
            document.appendChild(rootElement);
            for (mediatartalom medium1 : media) {
                Element medium = document.createElement("media");
                rootElement.appendChild(medium);
                createChildElement(document, medium, "azonosito", medium1.getID());
                createChildElement(document, medium, "kreator", medium1.getKreator());
                createChildElement(document, medium, "name", medium1.getName());
                createChildElement(document, medium, "ev",medium1.getEv());
                createChildElement(document, medium, "tipus",medium1.getTipus());
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new FileOutputStream(filepath));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.println("\nSIKERES MENTÉS!\n");
        if(kilepes == 65){
            System.exit(68);
        }
        else {
            enter();
            lehetosegek();
        }
    }

    private static void createChildElement(Document document, Element parent, String tagName, String value) {
        Element element = document.createElement(tagName);
        element.setTextContent(value);
        parent.appendChild(element);
    }
}
