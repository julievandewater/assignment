package sampleApp.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import sampleApp.model.Registration;
import sampleApp.service.*;
import java.util.List;
import org.springframework.ui.*;


@Controller
public class RegController extends WebMvcConfigurerAdapter {

    @Autowired
    private RegService regService;
    public static final Logger logger = LoggerFactory.getLogger(RegController.class);

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/register")
    public String showForm(Registration registration) {
        return "signup";
    }

    @PostMapping("/register")
    public String checkRegistrationInfo(@Valid Registration registration, BindingResult bindingResult) {

        //something went wrong, reflect on form
        if (bindingResult.hasErrors()) {
            return "signup";
        }
        else {
            //reg was free of errors, call insert method and forward the user
            regService.addNewRegistration(registration);
            return "redirect:/results";
        }
    }

    @GetMapping("/admin")
    public String showReport(Registration registration, BindingResult bindingResult, Model model) {
        List<Registration> allRegs = null;

        allRegs = regService.getAllRegistrations();
        for (Registration r: allRegs) {
            bindingResult.getModel().values();
        }
        //let's pass it to the model so the report can have it
        model.addAttribute("allRegs", allRegs);

        return "admin";
    }

}
