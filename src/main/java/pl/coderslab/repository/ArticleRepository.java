package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Article;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {


    @Query(value = "SELECT * FROM articles a " +
            "JOIN articles_categories ac ON a.id = ac.Article_id " +
            "JOIN categories c ON ac.categories_id = c.id " +
            "WHERE c.name LIKE :categoryName", nativeQuery = true)
    List<Article> findArticleByCategoryName(@Param("categoryName") String categoryName);
}
