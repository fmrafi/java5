/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package training.web.mydir;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Tanvir
 */
public class Directory {

    private ArrayList<DirectoryEntry> entries;

    public Directory() {
        this.entries = new ArrayList<DirectoryEntry>();
        DirectoryEntry de;
        Calendar c;

        de = new DirectoryEntry();
        de.setID("1");
        de.setFirstName("Tanvir");
        de.setLastName("Ahmed");
        c = Calendar.getInstance();
        c.set(1974, 1, 1, 0, 0, 0);
        de.setDateOfBirth(c.getTime());
        de.setPhoneNumber("1234567890");
        entries.add(de);

        de = new DirectoryEntry();
        de.setID("2");
        de.setFirstName("John");
        de.setLastName("Smith");
        c = Calendar.getInstance();
        c.set(1980, 10, 5, 0, 0, 0);
        de.setDateOfBirth(c.getTime());
        de.setPhoneNumber("9876543210");
        entries.add(de);

    }

    /**
     * @return the entries
     */
    public ArrayList<DirectoryEntry> getEntries() {
        return entries;
    }

    /**
     * @param entries the entries to set
     */
    public void setEntries(ArrayList<DirectoryEntry> entries) {
        this.entries = entries;
    }
}
