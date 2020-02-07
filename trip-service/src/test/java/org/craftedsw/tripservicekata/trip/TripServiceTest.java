package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TripServiceTest {
	/*validate_logged_in_user // throws UserNotLoggedInException
does_not_return_any_trips_when_users_are_not_friends
return_trips_when_users_are_friends
*/
	User loggedUser;

    @Test
    public void throws_UserNotLoggedInException_when_user_is_not_logged_in() {
        loggedUser = null;

        TripService tripService = new TestableTripService();

	    assertThrows(UserNotLoggedInException.class,() -> tripService.getTripsByUser(null, loggedUser));
    }

    @Test
    public void does_not_return_any_trips_when_users_are_not_friends(){
        loggedUser = new User();

        TripService tripService = new TestableTripService();

        List<Trip> expected = new ArrayList<Trip>();

        assertEquals(expected, tripService.getTripsByUser(new User(), loggedUser));
    }

    @Test
    public void returns_friend_trips_when_both_users_are_friends(){
        loggedUser = new User();
        User friend = new User();
        friend.addTrip(new Trip());
        friend.addTrip(new Trip());
        friend.addTrip(new Trip());
        friend.addFriend(loggedUser);

        TripService tripService = new TestableTripService();

        List<Trip> result = tripService.getTripsByUser(friend, loggedUser);
        assertEquals(3, result.size());
    }


    private class TestableTripService extends  TripService {

        @Override
        protected List<Trip> findTrips(User user) {
            return user.trips();
        }
    }
}
