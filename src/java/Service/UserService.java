/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.sql.SQLException;

/**
 *
 * @author Joey
 */
public interface UserService {
    public boolean isValidUser(String username, String password) throws SQLException;
}
