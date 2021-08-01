package hu.ulyssys.java.course.jpa.hw.hibernate;

import hu.ulyssys.java.course.jpa.hw.hibernate.entity.Author;
import hu.ulyssys.java.course.jpa.hw.hibernate.entity.BlogPost;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class HibernateMain {

    public static void main(String[] args) {

        BlogPost blogPost = new BlogPost();
        blogPost.setCategory("JAVA");
        blogPost.setContent("EE and SE");
        blogPost.setTittle("Awesome content!");
        blogPost.setCreatedDate(new Date());
        blogPost.setLastModifiedDate(new Date());
        blogPost.setPublishedDate(new Date());

        //insert
        insertBlogPost(blogPost);
        Long insertedBlogPostID = insertBlogPost(blogPost);

        //find by id
        BlogPost persistedBlogPost = findBlogPostById(insertedBlogPostID);

        persistedBlogPost.setCategory("MAVEN");
        persistedBlogPost.setContent("Building my project.");
        persistedBlogPost.setLastModifiedDate(new Date());

        //update
        updateBlogPost(persistedBlogPost);

        //get blog_post table
        System.out.println("BlogPost items: ");
        getAllBlogPost().forEach(blogPost1 -> {
            System.out.println("ID: " + blogPost1.getId() + ", Category: " + blogPost1.getCategory()
                    + ", Content: " + blogPost1.getContent() + ", Tittle: " + blogPost1.getTittle()
                    + ", Created date: " + blogPost1.getCreatedDate());
        });
        System.out.println("End of Blogpost items.");
        System.out.println("_____________________________________________________________________________");

        Author author = new Author();
        author.setCreatedDate(new Date());
        author.setFirstName("Sanya");
        author.setLastName("Hugel");
        author.setLastModifiedDate(new Date());
        author.setUsername("sanci456");

        //insert
        insertAuthor(author);
        Long insertedAuthor = insertAuthor(author);

        //find by id
        Author persistedAuthor = findAuthortById(insertedAuthor);
        System.out.println("Find Author ID: " + persistedAuthor.getId());

        persistedAuthor.setUsername("Lofeju555");
        persistedAuthor.setLastModifiedDate(new Date());
        persistedAuthor.setFirstName("Karón");
        persistedAuthor.setLastName("Háúv varjú");

        updateAuthor(persistedAuthor);

        System.out.println("Aurhor items:");
        getAllAuthor().forEach(author1 -> {
            System.out.println("ID: " + author1.getId() + ", First name: " + author1.getFirstName()
                    + ", Last name: " + author1.getLastName() + ", username: " + author.getUsername()
                    + ", Created date: " + author1.getCreatedDate());
        });
        DatabaseSessionProvider.getInstance().getSessionObj().close();
    }

    private static Long insertAuthor(Author author) {
        Session session = DatabaseSessionProvider.getInstance().getSessionObj();
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
        return author.getId();
    }

    private static Long insertBlogPost(BlogPost blogPost) {
        Session session = DatabaseSessionProvider.getInstance().getSessionObj();
        session.beginTransaction();
        session.save(blogPost);
        session.getTransaction().commit();
        return blogPost.getId();
    }

    private static BlogPost findBlogPostById(Long id) {
        Session session = DatabaseSessionProvider.getInstance().getSessionObj();
        BlogPost blogPost = session.find(BlogPost.class, id);
        return blogPost;
    }

    private static Author findAuthortById(Long id) {
        Session session = DatabaseSessionProvider.getInstance().getSessionObj();
        Author author = session.find(Author.class, id);
        return author;
    }

    private static void updateBlogPost(BlogPost blogPost) {
        Session session = DatabaseSessionProvider.getInstance().getSessionObj();
        session.beginTransaction();
        session.update(blogPost);
        session.getTransaction().commit();
        System.out.println("Updated BlogPost item ID: " + blogPost.getId());
    }

    private static void updateAuthor(Author author) {
        Session session = DatabaseSessionProvider.getInstance().getSessionObj();
        session.beginTransaction();
        session.update(author);
        session.getTransaction().commit();
        System.out.println("Updated Author item ID: " + author.getId());

    }

    private static List<BlogPost> getAllBlogPost() {
        Session session = DatabaseSessionProvider.getInstance().getSessionObj();
        Query<BlogPost> query = session.createQuery("SELECT n FROM BlogPost n", BlogPost.class);
        return query.getResultList();
    }

    private static List<Author> getAllAuthor() {
        Session session = DatabaseSessionProvider.getInstance().getSessionObj();
        Query<Author> query = session.createQuery("SELECT n FROM Author n", Author.class);
        return query.getResultList();
    }
}
