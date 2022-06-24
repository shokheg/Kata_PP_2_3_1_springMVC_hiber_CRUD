package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

/**
 * @author shokhalevich
 */

@Service
public class UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public void add(User user) {
        userDAO.add(user);
    }

    public User updateUser(User user) {
        userDAO.updateUser(user);
        return user;
    }

    public User delete(User user) {
        return userDAO.delete(user);
    }

    public User getUser(Long id) {
        return userDAO.getUser(id);
    }


}
