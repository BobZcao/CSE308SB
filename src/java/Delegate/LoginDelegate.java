/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Delegate;

import Service.UserService;
import java.sql.SQLException;

/**
 *
 * @author Joey
 */
public class LoginDelegate {

    private UserService userService;

    public UserService getUserService() {
        return this.userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public boolean isValidUser(String username, String password) throws SQLException {
        return userService.isValidUser(username, password);
    }
}
