package com.jars.shopping.REST;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcinpankowski on 26.02.17.
 */
public class UserDataPOJO {
    static List<UserDataForGUI> getDataForGUI(List<UserData> usersToPrint) {
        List<UserDataForGUI> userDataForGUIs = new ArrayList<>();

        for (UserData userToP : usersToPrint) {
            userDataForGUIs.add(new UserDataForGUI(userToP.getId(), userToP.getUsername(), userToP.getDate()));
        }

        return userDataForGUIs;
    }
}
