package teksystems.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.dao.ProductDAO;
import teksystems.casestudy.database.entity.Product;
import teksystems.casestudy.database.entity.User;
import teksystems.casestudy.formbean.ConversationFormBean;

import javax.validation.Valid;

@Slf4j
@Controller
public class ConversationController {

    @Autowired
    private ProductDAO productDao;

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

        log.debug(form.toString());

        if (bindingResult.hasErrors())  {
            // this is the error case
            for ( FieldError error : bindingResult.getFieldErrors()) {
                log.debug(error.toString());
            }

            // add the errors to the model to be displayed on the page
            response.addObject("bindingResult", bindingResult);

            // add the form bean back to the model so I can fill the form with the user input
            response.addObject("form", form);
        } else {
            // this is the success case
            // we are going to save the product to the database

            Product product = new Product();

            product.setName(form.getProductName());
            product.setDescription(form.getDescription());
            product.setPrice(form.getPrice());
            product.setImageUrl(form.getImageURL());

            productDao.save(product);

        }


        return response;
    }

}
