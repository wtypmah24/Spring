package bday.app.controller;

import bday.app.exception.NotFoundException;
import bday.app.friend.Friend;
import bday.app.service.FriendService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class FriendController {
    private final FriendService service;

    @Autowired
    public FriendController(FriendService service) {
        this.service = service;
    }

    @PostMapping(path = "/add_friend",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Friend addNewFriend(@RequestBody @Valid Friend newFriend) {
        service.addFriend(newFriend);
        return newFriend;
    }

    @GetMapping("/friends")
    public List<Friend> getAllFriends() {
        return service.getFriends();
    }

    @GetMapping("/today_birthday")
    public List<Friend> getBirthdayFriends() {
        return service.getBirthdayFriends();
    }

    @GetMapping("/get_friends/{fname}/{lname}")
    public List<Friend> getFriendsByName(@PathVariable("fname") String firstName,
                                         @PathVariable("lname") String lastName) throws NotFoundException {

        List<Friend> friends = service.getBirthDateByFullName(firstName, lastName);
        if (friends == null || friends.isEmpty())
            throw new NotFoundException("There are no friends with provided full name.");
        return friends;
    }

    @GetMapping("/get_friends/{birthday}")
    public List<Friend> getFriendsByBirthday(@PathVariable("birthday") LocalDate birthday) {
        List<Friend> result = service.getFriendsByBirthDay(birthday);
        if (result.isEmpty()) try {
            throw new NotFoundException("Friend not found.");
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<NotFoundException> handleNotFoundException(NotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new NotFoundException(exception.getMessage()));
    }
}
