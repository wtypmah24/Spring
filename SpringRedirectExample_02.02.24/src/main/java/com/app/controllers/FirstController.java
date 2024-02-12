package com.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FirstController {
    @GetMapping("/first")
    public String first(@RequestParam("name") String name, RedirectAttributes redirectAttributes){
        System.out.println("Получен зпрос с именем " + name);
        redirectAttributes.addAttribute("name", name);
        return "redirect:/second";
    }
}