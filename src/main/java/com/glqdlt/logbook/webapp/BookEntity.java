package com.glqdlt.logbook.webapp;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author glqdlt
 */
@Entity
@Table(name = "tb_book")
public class BookEntity {
    private String id;
    private String isbn;
    private String title;
    private List<AuthorEntity> authorEntityList = new LinkedList<>();
    private String description;
    private PublisherEntity publisher;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(unique = true)
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tb_book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    public List<AuthorEntity> getAuthorEntityList() {
        return authorEntityList;
    }

    public void setAuthorEntityList(List<AuthorEntity> authorEntityList) {
        this.authorEntityList = authorEntityList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pub_id")
    public PublisherEntity getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherEntity publisher) {
        this.publisher = publisher;
    }

    public void addAuthorEntity(AuthorEntity authorEntity){
        this.authorEntityList.add(authorEntity);
    }
}
