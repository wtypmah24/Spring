package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // указывает, что данный класс является контроллером
public class FirstController {
    @GetMapping("/truth")
    public String showTruth() {
        return "show_truth"; // указывается имя файла, хранящее
    }

    @GetMapping("/lie")
    public String showLie() {
        return "show_lie"; // указывается имя файла, хранящее
    }
}
