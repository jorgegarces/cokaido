package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

public class TripService {

    public List<Trip> getTripsByUser(User user, User loggedUser) throws UserNotLoggedInException {
        if (loggedUser == null) throw new UserNotLoggedInException();

        if (user.isFriendsWith(loggedUser)) return findTrips(user);
		return new ArrayList<Trip>();
    }

    protected List<Trip> findTrips(User user) {
        return TripDAO.findTripsByUser(user);
    }
}