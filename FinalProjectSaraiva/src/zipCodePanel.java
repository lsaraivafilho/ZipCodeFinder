/**
 * Leonardo Saraiva Filho - lsaraivafilho
 * 202102 CIS171 26657
 * 12/10/2021
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.zipCode;

public class zipCodePanel extends JPanel {
    private main.zipCode zip;
    private JTextField insertCity;
    private JTextField insertzip;
    private JButton findZipCodeButton;
    private JButton findCityButton;
    private JButton searchButton;
    private JButton close;

    public zipCodePanel(zipCode zip) {
        this.zip = zip;
        insertCity = new JTextField(20);
        insertzip = new JTextField(20);
        findCityButton = new JButton("Find Zip Code");
        findZipCodeButton = new JButton("Find City");
        searchButton = new JButton("Last searched");
        close = new JButton("Close");
// Creating the Buttons
        zipCodeFinderClickListener z = new zipCodeFinderClickListener();
        findZipCodeButton.addActionListener(z);
        cityFinderClickListener c = new cityFinderClickListener();
        findCityButton.addActionListener(c);
        searchStorageList s = new searchStorageList();
        searchButton.addActionListener(s);
        CloseListener e = new CloseListener();
        close.addActionListener(e);
// Creating the JPanel
        JPanel panel = new JPanel();
        panel.add(findZipCodeButton);
        panel.add(insertCity);
        panel.add(findCityButton);
        panel.add(insertzip);
        panel.add(searchButton);
        panel.add(close);

        add(panel);
        setSize(900, 200);
    }
    //Creating the function of each button and what class or method they are using
    class zipCodeFinderClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            String zipFinder = insertCity.getText().trim();
            try {
                zip.searchCity(zipFinder);
                // JOptionPane.showMessageDialog(null, main.zipCode.searchCity(zipFinder));
            } catch (Exception exc) {
                JOptionPane.showMessageDialog(null, "not a city");
            }
        }
    }
    class cityFinderClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            String cityFinder = insertzip.getText().trim();
            try {
                zip.findZip(cityFinder);
            } catch (Exception exc) {
                JOptionPane.showMessageDialog(null, "not a number in text box");
            }
        }
    }
    class CloseListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
    class searchStorageList implements  ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
//            String search = searchButton;
            zip.getSearchedStorageObj().printSearch();
        }
    }

}
