package gr.aueb.cf.schoolapp.service;

import gr.aueb.cf.schoolapp.dao.exceptions.UserDAOException;
import gr.aueb.cf.schoolapp.dto.InsertUserDTO;
import gr.aueb.cf.schoolapp.model.User;
import gr.aueb.cf.schoolapp.service.exceptions.UserNotFoundException;

public interface IUserService {
    User insertUser(InsertUserDTO dto) throws UserDAOException;
    User getUserByUsername(String username) throws UserDAOException, UserNotFoundException;
    boolean isUserValid(String username, String password) throws UserDAOException;
    boolean isEmailExist(String username) throws UserDAOException;
}
