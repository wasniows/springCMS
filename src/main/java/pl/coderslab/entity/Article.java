package pl.coderslab.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name = "articles")
public class Article {

    private static final String DATE_FORMATTER = "yyyy-MM-dd HH:mm:ss";


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 200, message = "{name.min.max}")
    @Column(length = 200)
    private String title;

    @OneToOne
    private Author author;

    @Size(min = 1, message = "{categories.min}")
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Category> categories;

    @Size(min = 5, message = "{content.min}")
    private String content;

    private String created;

    private String updated;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }


    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_FORMATTER));
    }

    @PreUpdate
    public void preUpdate() {

        updated = LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_FORMATTER));
    }
}
