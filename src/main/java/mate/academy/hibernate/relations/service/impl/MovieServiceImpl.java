package mate.academy.hibernate.relations.service.impl;

import mate.academy.hibernate.relations.dao.MovieDao;
import mate.academy.hibernate.relations.dao.impl.MovieDaoImpl;
import mate.academy.hibernate.relations.lib.DataProcessingException;
import mate.academy.hibernate.relations.model.Movie;
import mate.academy.hibernate.relations.service.MovieService;
import mate.academy.hibernate.relations.util.HibernateUtil;

public class MovieServiceImpl implements MovieService {
    private final MovieDao movieDao = new MovieDaoImpl(HibernateUtil.getSessionFactory());

    public MovieServiceImpl(MovieDaoImpl movieDao) {
    }

    @Override
    public Movie add(Movie country) {
        return movieDao.add(country);
    }

    @Override
    public Movie get(Long id) {
        return movieDao.get(id).orElseThrow(()
                -> new DataProcessingException("Movie Not Found with id: " + id + "."));
    }
}
