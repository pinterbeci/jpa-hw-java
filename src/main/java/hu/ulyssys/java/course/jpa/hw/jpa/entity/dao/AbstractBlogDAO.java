package hu.ulyssys.java.course.jpa.hw.jpa.entity.dao;

import hu.ulyssys.java.course.jpa.hw.jpa.entity.AbstractBlogJPA;
import hu.ulyssys.java.course.jpa.hw.jpa.entity.BlogPostJPA;

import javax.persistence.EntityManager;
import java.util.List;

public interface AbstractBlogDAO<T extends AbstractBlogJPA> {

    EntityManager createEntityManager() ;

    void save(T item) ;


    void delete(T item) ;


    void update(T item) ;

    T findByID(Long id);

    List<T> findAll();
}
