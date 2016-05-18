/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewBean;

/**
 *
 * @author code
 */
public class HoldBean {
    private String suspend = "";
    private String setting = "";
    private String email = "";

    public String getSuspend() {
        return suspend;
    }

    public String getSetting() {
        return setting;
    }

    public String getEmail() {
        return email;
    }

    public void setSuspend(String suspend) {
        this.suspend = suspend;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
