/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Person;



/**
 *
 * @author code
 */
public class Member {
    
    private String userName;
    private String password;
    private String passwordConf;
    private String email;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String telephone;
    private int font;

    public int getFont() {
        return font;
    }

    public void setFont(int font) {
        this.font = font;
    }

    public int getContrast() {
        return contrast;
    }

    public void setContrast(int contrast) {
        this.contrast = contrast;
    }

    public int getLendingPeriod() {
        return lendingPeriod;
    }

    public void setLendingPeriod(int lendingPeriod) {
        this.lendingPeriod = lendingPeriod;
    }

    public String getAgeContent() {
        return ageContent;
    }

    public void setAgeContent(String ageContent) {
        this.ageContent = ageContent;
    }
    private int contrast;
    private int lendingPeriod;
    private String ageContent;
    
    public Member(){
    
    }
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordConf(){
        return passwordConf;
    }
    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setPasswordConf(String passwordConf){
        this.passwordConf = passwordConf;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
   
}
