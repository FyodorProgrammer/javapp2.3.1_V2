package web.dao;
import org.springframework.stereotype.Component;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {
    private static long USER_COUNT;
    private final List<User> users;


    {
        users = new ArrayList<>();

        users.add(new User(++USER_COUNT, "name1", "lastname1", "email1@email.ru"));
        users.add(new User(++USER_COUNT, "name2", "lastname2", "email2@email.ru"));
        users.add(new User(++USER_COUNT, "name3", "lastname3", "email3@email.ru"));
        users.add(new User(++USER_COUNT, "name4", "lastname4", "email4@email.ru"));


    }

    public List<User> index() {
        return users;
    }
    public User show(long id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    public void save(User user) {
        user.setId(++USER_COUNT);
        users.add(user);
    }

    public void update(long id, User updateUser) {
        User userToBeUpdated = show(id);
        userToBeUpdated.setName(updateUser.getName());
        userToBeUpdated.setLastName(updateUser.getLastName());
        userToBeUpdated.setEmail(updateUser.getEmail());

    }

    public void delete(long id){
        users.removeIf(p -> p.getId() == id);
    }

}
