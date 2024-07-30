package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuizController {
    @GetMapping("/random-quote")
    public String quote(Model model) {
        String[] quotes = {
                "A",
                "B"
        };
        int random = (int) (Math.random() * quotes.length);
        model.addAttribute("randomQuote", quotes[random]);
        return "quote";
    }
}
