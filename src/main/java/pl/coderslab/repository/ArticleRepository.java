package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Article;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    Article findArticleById(Long id);

    @Query(value = "SELECT a FROM Article a WHERE a.draft = false ")
    List<Article> findAllArticles();

    @Query(value = "SELECT * FROM articles a " +
            "JOIN articles_categories ac ON a.id = ac.Article_id " +
            "JOIN categories c ON ac.categories_id = c.id " +
            "WHERE c.name LIKE :categoryName", nativeQuery = true)
    List<Article> findArticleByCategoryName(@Param("categoryName") String categoryName);

    @Query(value = "SELECT * FROM articles a " +
            "JOIN articles_categories ac ON a.id = ac.Article_id " +
            "JOIN categories c ON ac.categories_id = c.id " +
            "WHERE c.id = :categoryId", nativeQuery = true)
    List<Article> findArticleByCategoryId(@Param("categoryId") Long categoryId);

}
