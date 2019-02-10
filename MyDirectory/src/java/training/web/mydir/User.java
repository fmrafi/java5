/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package training.web.mydir;

/**
 *
 * @author Tanvir
 */
public class User {
    
    private String userId;
    private String password;
    private String salutation;

    public User() {
        userId = null;
        password = null;
        salutation = null;
    }

    /**
     * @return the uid
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param uid the uid to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the salutation
     */
    public String getSalutation() {
        return salutation;
    }

    /**
     * @param salutation the salutation to set
     */
    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    
}
