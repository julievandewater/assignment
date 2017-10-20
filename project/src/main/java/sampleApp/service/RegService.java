package sampleApp.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sampleApp.dao.*;
import sampleApp.model.*;
@Service
public class RegService implements IRegService {

    @Autowired
    private RegDAO regDAO;

    @Override
    public List<Registration> getAllRegistrations() {
        List<Registration> r = regDAO.getAllRegistrations();
        return r;
    }

    public Registration addNewRegistration(Registration registration) {
        Registration r = regDAO.addNewRegistration(registration);
        return r;
    }
}