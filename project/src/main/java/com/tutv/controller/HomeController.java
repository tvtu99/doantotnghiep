package com.tutv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
  
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public ModelAndView homePage() {
      ModelAndView mav = new ModelAndView("home");
      return mav;
   }
  
   @RequestMapping(value = "/springmvc", method = RequestMethod.GET)
   public ModelAndView springMVCPage() {
      ModelAndView mav = new ModelAndView("home");
      return mav;
   }
   
   @RequestMapping(value = "/loginb", method = RequestMethod.GET)
   public ModelAndView loginPage() {
      ModelAndView mav = new ModelAndView("login");
      return mav;
   }
}