package com.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/dummy")
public class DummyController {

    @ResponseBody
    @RequestMapping("/index")
    String index() {
        return "index";
    }


    //    @ResponseBody
    @RequestMapping("/sendingModel")
    ModelAndView sendingModel() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("msg", "Hello World");
        return modelAndView;
    }


    @RequestMapping("/country/{countryName}")
    @ResponseBody
    String returnCountryName(@PathVariable("countryName") String countryName) {
        return countryName;
    }

    @RequestMapping("/countryAndState/{countryName}/{stateName}")
    @ResponseBody
    String returnCountryAndState(@PathVariable Map<String, String> requestMap) {
        return requestMap.get("countryName") + " " + requestMap.get("stateName");
    }

    @RequestMapping(value = "/submitForm1.html", method = RequestMethod.POST)
    @ResponseBody
    String submitForm(@RequestParam("username") String username,
                      @RequestParam("password") String password) {
        return "Username " + username + " Password " + password;
    }


//    @RequestMapping(value = "/submitForm.html", method = RequestMethod.POST)
//    @ResponseBody
//    String submitForm(StudentObject studentObject) {
//        return "Firstname " + studentObject.getFirstName() + " LastName " + studentObject.getLastName();
//    }

    @RequestMapping(value = "/submitForm.html", method = RequestMethod.POST)
    @ResponseBody
    ModelAndView submitForm(@ModelAttribute("student") StudentObject studentObject) {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }




}
