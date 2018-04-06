package aplikacja.service;


import aplikacja.dao.UserDao;
import aplikacja.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    public User findUser(int id) {
        return userDao.findUser(id);
    }


    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }


}
