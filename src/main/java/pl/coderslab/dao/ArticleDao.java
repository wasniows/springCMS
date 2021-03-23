package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {

    @PersistenceContext
    EntityManager entityManager;


    public Article findById(long id) {
        return entityManager.find(Article.class, id);
    }

    public void save(Article article) {
        entityManager.persist(article);
    }

    public void update(Article article) {
        entityManager.merge(article);
    }

    public void delete(Article article) {
        entityManager.remove(entityManager.contains(article) ?
                article : entityManager.merge(article));
    }

    public List<Article> findAll() {
        Query query = entityManager.createQuery("select a from Article a");
        return query.getResultList();
    }

    public List<Article> findLastFive() {
        Query query = entityManager.createQuery("select a from Article a order by a.id desc");
        query.setMaxResults(5);
        return query.getResultList();
    }

}
