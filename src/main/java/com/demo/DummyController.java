package com.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/dummy")
public class DummyController {

    @ResponseBody
    @RequestMapping("/index")
    String index() {
        return "index";
    }


}
