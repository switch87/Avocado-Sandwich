package be.pellingert.avocadoSandwich.model;

/**
 * Created by gp on 3/06/15.
 */

import java.io.*;
import java.util.ArrayList;

public class KernKwadrant {
    private static String ioFile = "kernkwadranten";

    public String kwaliteit;
    public String valkuil;
    public String allergie;
    public String uitdaging;

    public KernKwadrant(String kwaliteit, String valkuil, String uitdaging, String afstandelijkheid) {
        this.kwaliteit = kwaliteit;
        this.valkuil = valkuil;
        this.allergie = uitdaging;
        this.uitdaging = afstandelijkheid;
    }

    public static void SaveKwadrants(ArrayList<KernKwadrant> kwadrants) {
        try {
            FileWriter fileWriter =
                    new FileWriter(ioFile);
            BufferedWriter writer =
                    new BufferedWriter(fileWriter);
            for (KernKwadrant kwadrant : kwadrants) {
                writer.write(kwadrant.kwaliteit + " " + kwadrant.valkuil + " " + kwadrant.allergie + " " + kwadrant.uitdaging);
                writer.newLine();
            }
            writer.close();
        } catch (IOException ex) {
            System.out.println("Error writing to file " + ioFile + "'");
        }
    }

    public static ArrayList<KernKwadrant> loadKwadrants(){
        ArrayList<KernKwadrant> kwadrants = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(ioFile);
            BufferedReader reader = new BufferedReader(fileReader);
            String nextKwadrant;
            while ((nextKwadrant = reader.readLine()) != null){
                String[] kwadrantProps = nextKwadrant.split(" ");
                if (kwadrantProps.length == 4) {
                    kwadrants.add(new KernKwadrant(kwadrantProps[0], kwadrantProps[1], kwadrantProps[2], kwadrantProps[3]));
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return kwadrants;
    }

}
