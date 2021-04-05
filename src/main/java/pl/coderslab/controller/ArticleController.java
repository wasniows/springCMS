package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@Controller
@SessionAttributes("article")
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
    public String listOfArticles(){
        return "listOfArticles";
    }

    @GetMapping("/addarticle")
    public String formBook(Model model){
        model.addAttribute("article", new Article());
        return "addArticle";
    }

    @PostMapping("/addarticle")
    public String addArticle (@Validated(Article.ValidationArticle.class) Article article, BindingResult bindingResult, Model model){

        if (article.isDraft()){
            model.addAttribute("article", article);
            return "addDraft";
        }

        if (bindingResult.hasErrors()){
            return "addArticle";
        }
        articleDao.save(article);
        return "redirect:/listofarticles";
    }

    @GetMapping("/editarticle/{id}")
    public String editArticle(@PathVariable long id, Model model){
        Article article = articleDao.findById(id);
        model.addAttribute("article", article);
        return "editArticle";
    }

    @RequestMapping("/editarticle")
    public String editArticle (@Validated(Article.ValidationArticle.class) Article article, BindingResult bindingResult, Model model){

        if (article.isDraft()){
            model.addAttribute("article", article);
            return "editDraft";
        }

        if (bindingResult.hasErrors()){
            return "editArticle";
        }
        articleDao.update(article);
        return "redirect:/listofarticles";
    }

    @RequestMapping("/delaccept/{id}")
    public String delAccept(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        return "/delAccept";
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

    @ModelAttribute("articles")
    public Collection<Article> articles(){
        return this.articleDao.findAll();
    }

}
