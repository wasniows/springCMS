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

import java.util.Collection;

@Controller
public class DraftController {

        private final ArticleDao articleDao;
        private final AuthorDao authorDao;
        private final CategoryDao categoryDao;

    public DraftController(ArticleDao articleDao, AuthorDao authorDao, CategoryDao categoryDao) {
        this.articleDao = articleDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
    }

    @GetMapping("/listofdrafts")
    public String listOfDrafs(){
        return "listOfDrafts";
    }

    @GetMapping("/adddraft")
    public String formBook(Model model){
        model.addAttribute("article", new Article());
        return "addDraft";
    }

    @PostMapping("/adddraft")
    public String addArticle (@Validated(Article.ValidationDraft.class) Article article, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "addDraft";
        }
        articleDao.save(article);
        return "redirect:/listofdrafts";
    }

    @GetMapping("/editdraft/{id}")
    public String editArticle(@PathVariable long id, Model model){
        Article article = articleDao.findById(id);
        model.addAttribute("article", article);
        return "editDraft";
    }

    @RequestMapping("/editdraft")
    public String editArticle (@Validated(Article.ValidationDraft.class) Article article, BindingResult bindingResult, Model model){

        if (!article.isDraft()){
            model.addAttribute("article", article);
            return "editArticle";
        }

        if (bindingResult.hasErrors()){
            return "editDraft";
        }
        articleDao.update(article);
        return "redirect:/listofdrafts";
    }

    @RequestMapping("/deletedraft/{id}")
    public String delete(@PathVariable long id){
        Article article = articleDao.findById(id);
        articleDao.delete(article);
        return "redirect:/listofdrafts";
    }

    @ModelAttribute("articles")
    public Collection<Article> articles(){
        return this.articleDao.findAllDrafts();
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
