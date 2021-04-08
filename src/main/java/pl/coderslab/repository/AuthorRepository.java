package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
