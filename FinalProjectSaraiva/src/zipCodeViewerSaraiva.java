/**
 * Leonardo Saraiva Filho - lsaraivafilho
 * 202102 CIS171 26657
 * 12/10/2021
 */
import main.zipCode;

import javax.swing.*;
import java.awt.*;

public class zipCodeViewerSaraiva {
    public static void main(String[] args) {
        //Leonardo Saraiva Filho
        zipCode zip = new zipCode();
        JPanel panel = new zipCodePanel(zip);
        JFrame frame = new JFrame("ZipCode Finder");
        frame.setSize(new Dimension(700, 200));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
