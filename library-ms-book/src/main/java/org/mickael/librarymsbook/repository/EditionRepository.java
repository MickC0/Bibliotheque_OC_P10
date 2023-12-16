package org.mickael.librarymsbook.repository;

import org.mickael.librarymsbook.model.Edition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditionRepository extends JpaRepository<Edition, Integer> {
}
