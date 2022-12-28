package com.glqdlt.logbook.webapp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<BookEntity, String> {
}
