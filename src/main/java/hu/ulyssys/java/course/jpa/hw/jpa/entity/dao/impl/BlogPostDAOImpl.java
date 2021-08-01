package hu.ulyssys.java.course.jpa.hw.jpa.entity.dao.impl;

import hu.ulyssys.java.course.jpa.hw.jpa.entity.BlogPostJPA;
import hu.ulyssys.java.course.jpa.hw.jpa.entity.dao.AbstractBlogDAO;
import hu.ulyssys.java.course.jpa.hw.jpa.entity.dao.BlogPostDAO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class BlogPostDAOImpl implements AbstractBlogDAO<BlogPostJPA> {

    private final static String persistanceUnit = "TestPersistence";

    @Override
    public EntityManager createEntityManager() {
        return Persistence.createEntityManagerFactory(persistanceUnit).createEntityManager();
    }

    @Override
    public void save(BlogPostJPA item) {

        EntityManager entityManager = createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(item);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(BlogPostJPA item) {

        EntityManager entityManager = createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(BlogPostJPA.class, item.getId()));
       // entityManager.remove(item);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void update(BlogPostJPA item) {

        EntityManager entityManager = createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(item);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public BlogPostJPA findByID(Long id) {
        EntityManager entityManager = createEntityManager();
        BlogPostJPA blogPost = entityManager.find(BlogPostJPA.class, id);
        return blogPost;
    }

    @Override
    public List<BlogPostJPA> findAll() {
        TypedQuery<BlogPostJPA> query = createEntityManager().createQuery("SELECT n FROM BlogPostJPA n",
                BlogPostJPA.class);
        return query.getResultList();
    }
}
