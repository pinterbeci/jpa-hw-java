package hu.ulyssys.java.course.jpa.hw.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "blog_post")
public class BlogPostJPA extends AbstractBlogJPA implements Serializable {

    @Column(name = "tittle")
    private String tittle;

    @Column(name = "content")
    private String content;

    @Column(name = "category")
    private String category;

    @Column(name = "published_date", nullable = false)
    private Date publishedDate;

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }
}
