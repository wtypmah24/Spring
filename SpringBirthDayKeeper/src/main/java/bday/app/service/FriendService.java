package bday.app.service;

import bday.app.friend.Friend;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FriendService {
    private final List<Friend> friends;

    public FriendService() {
        friends = new ArrayList<>();
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public void addFriend(Friend friend) {
        friends.add(friend);
    }

    public List<Friend> getFriendsByBirthDay(LocalDate birthday) {
        return friends.stream()
                .filter(friend -> friend.birthDate().equals(birthday))
                .collect(Collectors.toList());
    }

    public List<Friend> getBirthdayFriends() {
        return friends.stream()
                .filter(friend -> friend.birthDate().equals(LocalDate.now()))
                .collect(Collectors.toList());
    }

    public List<Friend> getBirthDateByFullName(String firstName, String lastName) {
        return friends.stream()
                .filter(friend -> friend.firstName().equals(firstName) && friend.lastName().equals(lastName))
                .toList();
    }
}
