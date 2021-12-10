/**
 * Leonardo Saraiva Filho - lsaraivafilho
 * 202102 CIS171 26657
 * 12/10/2021
 */
package storagepkg;
import javax.swing.*;
import java.util.Iterator;
import java.util.LinkedList;

public class searchedStorage {
    LinkedList<String> searchedLine = new LinkedList<String>();
    public searchedStorage(){
    }
    public void addToList(String output){
        searchedLine.add(output);
    }
    public void printSearch(){
        Iterator it = this.searchedLine.iterator();
        while(it.hasNext()){
            JOptionPane.showMessageDialog(null,it.next());
        }
    }


}

