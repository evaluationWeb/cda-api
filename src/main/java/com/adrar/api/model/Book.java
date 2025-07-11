package com.adrar.api.model;

import com.adrar.api.validation.PastOrPresentYear;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import org.jetbrains.annotations.NotNull;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    @Length(min = 2, message="Le titre doit contenir au moins 2 caractères")
    @NotBlank(message = "Title cannot be blank")
    private String title;
    @Column(length = 255, nullable = false)
    @NotBlank(message = "Description cannot be blank")
    private String description;
    @Column(length = 255)
    private String cover;
    @Column(length = 255, unique = true)
    private String chunk;
    @Temporal(TemporalType.DATE)
    @Column(nullable = true, name = "created_at")
    @PastOrPresentYear(min=2000)
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name="id_author")
    private Author author;
    @ManyToMany
    @JoinTable(
            name = "book_category",
            joinColumns = @JoinColumn( name = "id_book" ),
            inverseJoinColumns = @JoinColumn( name = "id_category" )
    )
    private List<Category> categories;

    public Book() {
        this.categories = new ArrayList<>();
    }
    public Book(String title, String description) {
        this.title = title;
        this.description = description;
        this.categories = new ArrayList<>();
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getChunk() {
        return chunk;
    }

    public void setChunk(String chunk) {
        this.chunk = chunk;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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

    public void addCategory(Category category) {
        this.categories.add(category);
    }

    public void removeCategory(Category category) {
        this.categories.remove(category);
    }
}
