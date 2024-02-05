package com.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SecondController {
    @GetMapping("/second")
    @ResponseBody
    public String second(@RequestParam(name = "name") String name) {
        return "User " + name + " redirected";
    }
}