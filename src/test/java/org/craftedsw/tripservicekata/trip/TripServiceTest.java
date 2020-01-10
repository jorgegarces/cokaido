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

	    assertThrows(UserNotLoggedInException.class,() -> tripService.getTripsByUser(null));
    }

    @Test
    public void does_not_return_any_trips_when_users_are_not_friends(){
        loggedUser = new User();

        TripService tripService = new TestableTripService();

        List<Trip> expected = new ArrayList<Trip>();

        assertEquals(expected, tripService.getTripsByUser(new User()));
    }

    private class TestableTripService extends  TripService {
        @Override
        protected User getLoggedUser() {
            return loggedUser;
        }
    }
}
