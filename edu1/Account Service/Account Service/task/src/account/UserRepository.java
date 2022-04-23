package account;


import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
public class UserRepository {

    public User findUserByUserName(String username) {
        return users.get(username);
    }

    public void save(User user) {
        users.put(user.getName(), user);
    }
}
