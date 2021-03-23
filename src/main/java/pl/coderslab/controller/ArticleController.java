package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;

import java.util.Collection;
import java.util.List;

@Controller
public class ArticleController {

    private final ArticleDao articleDao;
    private final AuthorDao authorDao;
    private final CategoryDao categoryDao;

    public ArticleController(ArticleDao articleDao, AuthorDao authorDao, CategoryDao categoryDao) {
        this.articleDao = articleDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
    }

    @GetMapping("/listofarticles")
    public String listOfArticles(Model model){
        List<Article> articles = articleDao.findAll();
        model.addAttribute("articles", articles);
        return "listOfArticles.jsp";
    }

    @GetMapping("/addarticle")
    public String formBook(Model model){
        model.addAttribute("article", new Article());
        return "/addArticle.jsp";
    }

    @PostMapping("/addarticle")
    public String addArticle (Article article){
        articleDao.save(article);
        return "redirect:/listofarticles";
    }

    @GetMapping("/editarticle/{id}")
    public String editArticle(@PathVariable long id, Model model){
        Article article = articleDao.findById(id);
        model.addAttribute("article", article);
        return "/editArticle.jsp";
    }

    @RequestMapping("/editarticle")
    public String editArticle (Article article){
        articleDao.update(article);
        return "redirect:/listofarticles";
    }

    @RequestMapping("/deletearticle/{id}")
    public String delete(@PathVariable long id){
        Article article = articleDao.findById(id);
        articleDao.delete(article);
        return "redirect:/listofarticles";
    }

    @ModelAttribute("authors")
    public Collection<Author> authors(){
        return this.authorDao.findAll();
    }

    @ModelAttribute("categories")
    public Collection<Category> categories(){
        return this.categoryDao.findAll();
    }

}
