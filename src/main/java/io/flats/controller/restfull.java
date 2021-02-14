package io.flats.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class restfull {
    @RequestMapping("/me")
    @ResponseBody
    public String returnMe() {


        return "OWOUWU";
    }

}
