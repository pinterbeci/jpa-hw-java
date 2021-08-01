package hu.ulyssys.java.course.jpa.hw.jpa;

import hu.ulyssys.java.course.jpa.hw.hibernate.entity.Author;
import hu.ulyssys.java.course.jpa.hw.jpa.entity.AuthorJPA;
import hu.ulyssys.java.course.jpa.hw.jpa.entity.BlogPostJPA;
import hu.ulyssys.java.course.jpa.hw.jpa.entity.dao.BlogPostDAO;
import hu.ulyssys.java.course.jpa.hw.jpa.entity.dao.impl.AuthorDAOImpl;
import hu.ulyssys.java.course.jpa.hw.jpa.entity.dao.impl.BlogPostDAOImpl;


import java.util.Date;

public class JPAMain {
    public static void main(String[] args) {


        //BlogPost CRUD

        BlogPostDAOImpl blogPostDAO = new BlogPostDAOImpl();
        BlogPostJPA blogPost = new BlogPostJPA();
        blogPost.setCategory("MAVEN");
        blogPost.setContent("Csudi jóóó");
        blogPost.setTittle("Szipiszupiiii-" + 666);
        blogPost.setCreatedDate(new Date());
        blogPost.setLastModifiedDate(new Date());
        blogPost.setPublishedDate(new Date());

        //save
        blogPostDAO.save(blogPost);

        //update & find by id
        BlogPostJPA updatedBlogPost = blogPostDAO.findByID(10L);
        updatedBlogPost.setCreatedDate(new Date());
        updatedBlogPost.setContent("SQL");
        blogPostDAO.update(updatedBlogPost);


        //delete
        BlogPostJPA deleteThisBlogPost = blogPostDAO.findByID(9L);
       // blogPostDAO.delete(deleteThisBlogPost);


        //read
        System.out.println("BlogPost elements:");
        blogPostDAO.findAll().forEach(blogPostJPA -> {

            System.out.println("ID: " + blogPostJPA.getId() + ", Category: " + blogPostJPA.getCategory() +
                    ", Content: " + blogPostJPA.getContent() + ", Tittle: " + blogPostJPA.getTittle());
        });

        System.out.println("__________________________________");

        AuthorDAOImpl authorDAO = new AuthorDAOImpl();

        //Author CRUD
        AuthorJPA author = new AuthorJPA();
        author.setCreatedDate(new Date());
        author.setFirstName("Béci");
        author.setLastName("Pintér");
        author.setLastModifiedDate(new Date());
        author.setUserName("pinter_ur99");

        //create
        authorDAO.save(author);

        //find by id
        AuthorJPA updatedAuthor = authorDAO.findByID(14L);

        updatedAuthor.setFirstName("Hugó");
        updatedAuthor.setLastName("Kilincs");
        updatedAuthor.setUserName("KilincsesHugo66");
        updatedAuthor.setLastModifiedDate(new Date());

        //update
        authorDAO.update(updatedAuthor);


        //delete
        AuthorJPA deleteThisAuthor = authorDAO.findByID(6L);
       // authorDAO.delete(deleteThisAuthor);


        //read

        System.out.println("Author elements:");
        authorDAO.findAll().forEach(authorJPA -> {

            System.out.println("First name: " + authorJPA.getFirstName() + ", Last name:" + authorJPA.getLastName() +
                    ", Username: " + authorJPA.getUserName() + ", Last modified date: " + authorJPA.getLastModifiedDate());
        });
    }
}
