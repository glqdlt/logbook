package com.glqdlt.logbook.webapp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.LinkedList;
import java.util.List;

/**
 * @author glqdlt
 */
@Entity
@Table(name = "tb_author")
public class AuthorEntity {
    private String id;
    private String name;
    private List<BookEntity> bookEntity = new LinkedList<>();

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "authorEntityList")
    public List<BookEntity> getBookEntity() {
        return bookEntity;
    }

    public void setBookEntity(List<BookEntity> bookEntity) {
        this.bookEntity = bookEntity;
    }

    public void addBookEntity(BookEntity bookEntity) {
        this.bookEntity.add(bookEntity);
    }
}
