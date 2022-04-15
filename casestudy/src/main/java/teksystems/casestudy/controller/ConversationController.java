package teksystems.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.entity.User;
import teksystems.casestudy.formbean.ConversationFormBean;

import javax.validation.Valid;

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
    public ModelAndView submit(@Valid ConversationFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response= new ModelAndView();
        response.setViewName("conversation");

        if (bindingResult.hasErrors())  {
            for ( FieldError error : bindingResult.getFieldErrors()) {
                log.debug(error.toString());
            }
        }

        log.debug(form.toString());

        return response;
    }

}
