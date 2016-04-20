/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceImpl;

import Dao.UserDao;
import Service.UserService;
import java.sql.SQLException;

/**
 *
 * @author Joey
 */
public class UserServiceImpl implements UserService{
    private UserDao userDao;
    public UserDao getUserDao()
    {
        return this.userDao;
    }
    public void setUserDao(UserDao userDao)
    {
        this.userDao = userDao;
    }
 
    @Override
    public boolean isValidUser(String username, String password) throws SQLException
    {
        return userDao.isValidUser(username, password);
    }
}

