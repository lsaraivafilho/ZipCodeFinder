/**
 * Leonardo Saraiva Filho - lsaraivafilho
 * 202102 CIS171 26657
 * 12/10/2021
 */
package main;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import storagepkg.searchedStorage;

public class zipCode {

    private String CSVFile = "uszips.csv";// Reading CSV File
    private BufferedReader br = null; // Inserting the File
    private String line = "";
    private String csvDiv = ","; // break line
    searchedStorage searchedStorageObj = new searchedStorage();

    public String getOutput() {
        return output;
    }

    private String output = "";

    // search zip
    public Object findZip(String cityFinder){
        boolean found = false;
        try {

            br = new BufferedReader(new FileReader(CSVFile));

            // while to read each line
            while ((line = br.readLine()) != null) {

                String[] data = line.split(csvDiv);// reading line separatede by ","
                data[3] = data[3].replace("\"", ""); //delete ""
                data[4] = data[4].replace("\"", "");
                data[5] = data[5].replace("\"", "");

                //check if the name of the city is the same as the current line in the file
                if(data[3].equalsIgnoreCase(String.valueOf(cityFinder))){
                    output = "[City= " + data[3] + " , State Id: " + data[4] + " , State: " + data[5]
                            + " , Zip Code=" + data[0] + "]";
                    searchedStorageObj.addToList(output);
                    JOptionPane.showMessageDialog(null,output);
                    found = true; // gets true to not show the message from city not found
                }

            }
            // check if there was an error in the execution of the file
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
            // close the app
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        // enter here if you can't find any city
        if(!found){
            JOptionPane.showMessageDialog(null,"No records found!");
        }
        return null;
    }

    public Object searchCity(String zipFinder){
        boolean found = false;
        try {

            br = new BufferedReader(new FileReader(CSVFile));
            // while to read each line
            while ((line = br.readLine()) != null) {

                String[] data = line.split(csvDiv);// reading line separatede by ","
                data[0] = data[0].replace("\"", "");//delete ""
                data[3] = data[3].replace("\"", "");//delete ""
                data[4] = data[4].replace("\"", "");//delete ""
                data[5] = data[5].replace("\"", "");//delete ""

                //check if the name of the city is the same as the current line in the file
                if(data[0].equalsIgnoreCase(zipFinder)){
                    output = "[Zip Code= " + data[0]
                            + " , City=" + data[3] + " , State Id: " + data[4] + " , State: " + data[5]+ "]";
                    searchedStorageObj.addToList(output);
                    JOptionPane.showMessageDialog(null,output);
                    found = true;// gets true to not show the message from city not found
                }
            }
// check if there was an error in the execution of the file
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        if(!found){
            JOptionPane.showMessageDialog(null,"No Records found!");
        }
        return zipFinder;
    }
    public searchedStorage getSearchedStorageObj(){
        return searchedStorageObj;
    }
}

