package teksystems.casestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.entity.User;

@Controller
public class ConversationController {

    @RequestMapping(value = "/conversation", method = RequestMethod.GET)
    public ModelAndView userList() throws Exception {
        ModelAndView response= new ModelAndView();
        response.setViewName("conversation");
        return response;
    }




}
