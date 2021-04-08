package pl.coderslab.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;
import pl.coderslab.repository.ArticleRepository;
import pl.coderslab.repository.AuthorRepository;
import pl.coderslab.repository.CategoryRepository;


import java.util.Collection;
import java.util.List;

@Controller
@AllArgsConstructor
@SessionAttributes("article")
public class ArticleController {

    private final ArticleDao articleDao;
    private final ArticleRepository articleRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;



    @GetMapping(value = "/articles", params = "categoryName")
    String ArticlesByCategoryName(@RequestParam("categoryName") String categoryName, Model model){

        List<Article> articles = articleRepository.findArticleByCategoryName(categoryName);
        model.addAttribute("articles", articles);
        return "listOfArticles";
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
        return this.authorRepository.findAll();
    }

    @ModelAttribute("categories")
    public Collection<Category> categories(){
        return this.categoryRepository.findAll();
    }

    @ModelAttribute("articles")
    public Collection<Article> articles(){
        return this.articleDao.findAll();
    }
}
