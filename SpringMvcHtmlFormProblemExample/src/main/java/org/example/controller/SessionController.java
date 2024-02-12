package org.example.controller;

import org.example.user.session.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SessionController {
    private final UserSession userSession;
    @Autowired
    public SessionController(UserSession userSession) {
        this.userSession = userSession;
    }
    @GetMapping("/")
    public String greeting(){
        if (userSession.isNew()){
            return "welcome_new_user";
        }
        else {
            userSession.setNew(false);
            return "welcome_back";
        }
    }
}