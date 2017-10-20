package sampleApp.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sampleApp.controller.RegController;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sampleApp.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Transactional
@Repository
public class RegDAO implements IRegDAO {

    public static final Logger logger = LoggerFactory.getLogger(RegController.class);

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<Registration> getAllRegistrations() {
        String hql = "FROM Registration r ORDER BY r.regDate desc";
        return (List<Registration>) entityManager.createQuery(hql).getResultList();
    }

    public Registration addNewRegistration(Registration r) {
        String hql = "INSERT INTO registrations (first_name, last_name, address1, address2, city, state, zip, country) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8)";
        entityManager.createNativeQuery(hql).setParameter(1, r.getFirstName()).setParameter(2, r.getLastName())
                .setParameter(3, r.getAddress1()).setParameter(4, r.getAddress2())
                .setParameter(5, r.getCity()).setParameter(6, r.getState())
                .setParameter(7, r.getZip()).setParameter(8, r.getCountry())
                .executeUpdate();
        return r;
    }
}
