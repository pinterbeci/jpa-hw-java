package hu.ulyssys.java.course.jpa.hw.jpa.entity.dao.impl;

import hu.ulyssys.java.course.jpa.hw.jpa.entity.AuthorJPA;
import hu.ulyssys.java.course.jpa.hw.jpa.entity.BlogPostJPA;
import hu.ulyssys.java.course.jpa.hw.jpa.entity.dao.AbstractBlogDAO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class AuthorDAOImpl implements AbstractBlogDAO<AuthorJPA> {

    private final static String persistanceUnit = "TestPersistence";

    @Override
    public EntityManager createEntityManager() {
        return Persistence.createEntityManagerFactory(persistanceUnit).createEntityManager();
    }

    @Override
    public void save(AuthorJPA item) {
        EntityManager entityManager = createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(item);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(AuthorJPA item) {
        EntityManager entityManager = createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(AuthorJPA.class, item.getId()));

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void update(AuthorJPA item) {
        EntityManager entityManager = createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(item);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public AuthorJPA findByID(Long id) {

        EntityManager entityManager = createEntityManager();
        AuthorJPA author = entityManager.find(AuthorJPA.class, id);
        return author;
    }

    @Override
    public List<AuthorJPA> findAll() {
        TypedQuery<AuthorJPA> query = createEntityManager().createQuery("SELECT n FROM AuthorJPA n",
                AuthorJPA.class);
        return query.getResultList();
    }
}
