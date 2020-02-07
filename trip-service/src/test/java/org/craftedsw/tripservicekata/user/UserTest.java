package org.craftedsw.tripservicekata.user;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    public void ensure_one_user_is_friends_with_another(){
        User user = new User();
        User friend = new User();
        user.addFriend(friend);

        assertTrue(user.isFriendsWith(friend));
    }

    @Test
    public void ensure_one_user_is_not_friends_with_another(){
        User user = new User();
        User friend = new User();

        assertFalse(user.isFriendsWith(friend));
    }
}
