package com.jakub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class HtmlController
{
    @GetMapping
    public String schowindex()
    {
        return "index";
    }
}
