package web.service;


import org.springframework.stereotype.Component;
import web.dao.UserDAO;
import web.dao.UserDAOList;
import web.model.User;

import java.util.List;

@Component
public class UserService implements Service {

    private final UserDAO userDaoList = new UserDAOList();
    @Override
    public List<User> index() {
        return userDaoList.index();
    }

    @Override
    public User show(long id) {
        return userDaoList.show(id);
    }

    @Override
    public void save(User user) {
        userDaoList.save(user);
    }

    @Override
    public void update(long id, User updateUser) {
        userDaoList.update(id, updateUser);
    }

    @Override
    public void delete(long id) {
        userDaoList.delete(id);
    }

}
