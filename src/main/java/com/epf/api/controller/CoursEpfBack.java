package com.epf.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CoursEpfBack {

    @RequestMapping("/")
    @ResponseBody
    public String hello() {
        return "Backend OK ✅ (Controller standard)";
    }
}