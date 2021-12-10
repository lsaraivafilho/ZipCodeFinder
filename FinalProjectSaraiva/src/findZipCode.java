/**
 * Leonardo Saraiva Filho - lsaraivafilho
 * 202102 CIS171 26657
 * 12/10/2021
 */
import java.util.Scanner;

public class findZipCode {

    public static void main(String[] args) {
        String cityFinder = "";
        String zipFinder = "";
        main.zipCode c = new main.zipCode(); // Create an object of class city
        Boolean aux = true; //Variable to help the infinite loop until typing 0
        while (aux){
            System.out.println("Menu: ");
            System.out.println("1 - City \n2 - Zip Code \n0 - Quit!");
            Scanner number = new Scanner(System.in); // Variable to receive the menu number
            System.out.print("Insert the Option Number: ");

            //Switch to check which number the user typed
            switch(number.nextInt()) {
                case 0: // if number is 0 it ends the loop
                    aux = false; // variable gets false to get out of the infinite loop
                    break;
                case 1: // if the number is 1 enter here
                    c.findZip(cityFinder); // calls the findZip function of the City class
                    break;
                case 2: // if the number is 2 enter here
                    c.searchCity(zipFinder); // calls the searchCity function of the City class
                    break;
                default: // If not 1, 2 or 0 enter here
                    System.out.println("Invalid Number!");

            }
        }
        System.out.println("Done!"); // calls when system shuts down
    }
    public static void tester(){

    }

}

