package com.app.controllers;

import com.app.service.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalcController {
    private final CalcService calcService;

    @Autowired
    public CalcController(CalcService calcService) {
        this.calcService = calcService;
    }

    @GetMapping("/calc")
    public String calculate(@RequestParam(name = "operator", defaultValue = "") String operator,
                            @RequestParam("num1") int num1,
                            @RequestParam("num2") int num2,
                            Model model) {

        int result = calcService.calculate(operator, num1, num2);
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("operator", operator);
        model.addAttribute("result", result);
        return "calcResult";
    }
}
