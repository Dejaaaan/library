package rs.levi9.library.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import rs.levi9.library.web.validation.custom.Isbn13;

@Entity
@Table(name = "book")
public class Book extends BaseEntity implements Serializable {
    
    public static final long serialVersionUID = 5128632882797623323L;
    
    @NotNull
    @Isbn13
    @Column(nullable = false)
    private String isbn;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    
    @NotNull
    @Length(min = 2, max = 100)
    @Column(nullable = false)
    private String title;
    
    @NotNull
    @Column(nullable = false)
    private String author;
    
    @NotNull
    @Past
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date publishDate;
    
    
    public Book() {
        
    }

    public Book(String isbn, Category category, String title, String author, Date publishDate) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
        this.category = category;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

}
