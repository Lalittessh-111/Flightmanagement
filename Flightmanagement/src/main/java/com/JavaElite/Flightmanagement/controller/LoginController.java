package com.JavaElite.Flightmanagement.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.JavaElite.Flightmanagement.bean.FlightUser;
import com.JavaElite.Flightmanagement.service.FlightUserService;

@RestController
public class LoginController {

    @Autowired
    private FlightUserService service;
    
    @Autowired
    private BCryptPasswordEncoder bCrypt;
    
    @GetMapping("/index")
    public ModelAndView showIndexPage() {
        return new ModelAndView("index");
    }

    @GetMapping("/register")
    public ModelAndView showUserRegistrationPage() {
        FlightUser user = new FlightUser();
        ModelAndView mv = new ModelAndView("newUserPage");
        mv.addObject("userRecord", user);
        return mv;
    }

    @PostMapping("/register")
    public ModelAndView saveUserRegistrationPage(@ModelAttribute("userRecord") FlightUser user) {
        String encodedPassword = bCrypt.encode(user.getPassword()); // encrypts the password
        FlightUser newUser = new FlightUser();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(encodedPassword);
        newUser.setType(user.getType());
        service.save(newUser);
        return new ModelAndView("loginPage");
    }

    @GetMapping("/loginPage")
    public ModelAndView showLoginPage(@RequestParam(value = "error", required = false) String error) {
        ModelAndView mv = new ModelAndView("loginPage");
        if (error != null) {
            mv.addObject("error", "Invalid username or password.");
        }
        return mv;
    }

    @PostMapping("/loginPage")
    public ModelAndView handleLoginPage(@RequestParam(value = "username") String username, 
                                        @RequestParam(value = "password") String password) {
        ModelAndView mv = new ModelAndView("loginPage");
        FlightUser user = service.findByUsername(username);
        if (user != null && bCrypt.matches(password, user.getPassword())) {
            mv.setViewName("index"); // or another page indicating successful login
        } else {
            mv.addObject("error", "Invalid username or password.");
        }
        return mv;
    }

    @GetMapping("/loginerror")
    public ModelAndView showLoginErrorPage() {
        ModelAndView mv = new ModelAndView("loginPage");
        mv.addObject("error", "Invalid username or password.");
        return mv;
    }
}