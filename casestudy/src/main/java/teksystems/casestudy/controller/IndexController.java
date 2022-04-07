package teksystems.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.dao.UserDAO;
import teksystems.casestudy.database.entity.User;
import teksystems.casestudy.validation.EmailUniqueImpl;

import java.util.List;

@Slf4j
@Controller
public class IndexController {


    @Autowired
    private UserDAO userDao;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() throws Exception {
        ModelAndView response = new ModelAndView();

      // log.debug("lombok logging at debug level");
       log.info("lombok logging at info level");
       log.warn("lombok logging at info level");

        List<User> users = userDao.findByFirstNameIgnoreCaseContaining("A");

        for( User user : users ) {
            log.debug(user.toString());
        }

        // figure out how to add this to the model
        // add JSTL imports to your pom
        // figure out how to do a c:forEach in the JSP page

        response.setViewName("index");

        return response;
    }
}
