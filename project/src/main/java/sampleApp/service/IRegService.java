package sampleApp.service;

import sampleApp.model.*;
import sampleApp.model.Registration;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

public interface IRegService {
    @ModelAttribute("allRegs")
    List<Registration> getAllRegistrations();

    Registration addNewRegistration(Registration registration);
}
