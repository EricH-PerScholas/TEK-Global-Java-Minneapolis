package teksystems.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.dao.UserDAO;
import teksystems.casestudy.database.entity.User;
import teksystems.casestudy.formbean.RegisterFormBean;

import java.util.Date;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserDAO userDao;

    /**
     * this is the controller method for the entry point of the
     * user registration page.   It does not do anything really
     * other than provide a route to the register.jsp page
     */
    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public ModelAndView register() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/register");

        // all these 2 lines of code are doing is seeding the model with an
        // empty form bean so that the JSP page substitutions will not error out
        // in this case spring is being nice enough not to throw errors but these
        // 2 lines are safety.
        RegisterFormBean form = new RegisterFormBean();
        response.addObject("form",form);

        return response;
    }

    /**
     * when the user submits the form it will call into this method
     * 1) the action on the form itself must match the value here in the request mapping
     * 2) method on the form must match the method here
     * otherwise spring MVC will not be able to respond to the request
     *
     * In this case the @PostMapping and @RequestMapping are the same with the @PostMapping
     * being a sharthand.   This works the same for @GetMapping
     *
     * This method now becomes a create and an edit based on if the id is populated in
     * the RegisterFormBean.
     */
    //@PostMapping( "/user/registerSubmit")
    @RequestMapping(value = "/user/registerSubmit", method = RequestMethod.POST)
    public ModelAndView registerSubmit(RegisterFormBean form) throws Exception {
        ModelAndView response = new ModelAndView();

        // we first assume that we are going to try to load the user from
        // the database using the incoming id on the form
        User user = userDao.findById(form.getId());

        // if the user is not null the know it is an edit
         if ( user == null ) {
             // now, if the user from the database is null then it means we did not
             // find this user.   Therefore, it is a create.
             user = new User();
        }

        user.setEmail(form.getEmail());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setPassword(form.getPassword());
        user.setCreateDate(new Date());

        userDao.save(user);

        log.info(form.toString());

        // here instaed of showing a view, we want to redirect to the edit page
        // the edit page will then be responsible for loading the user from the
        // database and dynamically creating the page
        // when you use redirect: as part of the view name it triggers spring to tell the
        // browser to do a redirect to the URL after the :    The big piece here to
        // recognize that redirect: uses an actual URL rather than a view name path.
        response.setViewName("redirect:/user/edit/" + user.getId());

        return response;
    }

    /**
     * This method is for editing a user. There is a path parameter being used
     * to pass the userid for the user that is to be editied.
     *
     * In this case the @GetMapping is equivlant to the @RequestMapping
     */
    //@RequestMapping(value = "/user/edit/{userId}", method = RequestMethod.GET)
    @GetMapping("/user/edit/{userId}")
    //public ModelAndView editUser(@RequestParam("userId") Integer userId) throws Exception {
    public ModelAndView editUser(@PathVariable("userId") Integer userId) throws Exception {
            ModelAndView response = new ModelAndView();
        response.setViewName("user/register");

        User user = userDao.findById(userId);

        RegisterFormBean form = new RegisterFormBean();

        form.setId(user.getId());
        form.setEmail(user.getEmail());
        form.setFirstName(user.getFirstName());
        form.setLastName(user.getLastName());
        form.setPassword(user.getPassword());
        form.setConfirmPassword(user.getPassword());

        response.addObject("form", form);

        return response;
    }
}
