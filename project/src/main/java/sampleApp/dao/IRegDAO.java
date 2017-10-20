package sampleApp.dao;

import sampleApp.model.*;
import sampleApp.model.Registration;

import java.util.List;

public interface IRegDAO {
    List<Registration> getAllRegistrations();

    Registration addNewRegistration(Registration registration);
}
