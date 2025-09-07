package mate.academy.hibernate.relations.dao.impl;

import java.util.Optional;
import mate.academy.hibernate.relations.dao.CountryDao;
import mate.academy.hibernate.relations.lib.DataProcessingException;
import mate.academy.hibernate.relations.model.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CountryDaoImpl extends AbstractDao implements CountryDao {
    public CountryDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Country add(Country country) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(country);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Cannot add new country with name "
                    + country.getName() + " to database.", e);
        }
        return country;
    }

    @Override
    public Optional<Country> get(Long id) {
        Optional<Country> foundCountry;
        try (Session session = factory.openSession()) {
            foundCountry = Optional.ofNullable(session.find(Country.class, id));
        } catch (Exception e) {
            throw new DataProcessingException("Can not get country by id: "
                    + id, e);
        }
        return foundCountry;
    }
}
