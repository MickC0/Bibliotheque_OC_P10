package org.mickael.librarymsbook.repository;

import org.mickael.librarymsbook.model.Cover;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoverRepository extends JpaRepository<Cover, Integer> {
}
