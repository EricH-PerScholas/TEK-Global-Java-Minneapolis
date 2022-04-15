package teksystems.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.entity.User;
import teksystems.casestudy.formbean.ConversationFormBean;

@Slf4j
@Controller
public class ConversationController {

    @RequestMapping(value = "/conversation", method = RequestMethod.GET)
    public ModelAndView conversation() throws Exception {
        ModelAndView response= new ModelAndView();
        response.setViewName("conversation");
        return response;
    }


    @RequestMapping(value = "/conversation/conversationSubmit", method = RequestMethod.GET)
    public ModelAndView submit(ConversationFormBean form) throws Exception {
        ModelAndView response= new ModelAndView();
        response.setViewName("conversation");

        log.debug(form.toString());

        return response;
    }

}
