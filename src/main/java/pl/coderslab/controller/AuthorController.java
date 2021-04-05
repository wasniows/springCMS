package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@Controller
public class AuthorController {
    
    private final AuthorDao authorDao;
    private final ArticleDao articleDao;

    public AuthorController(AuthorDao authorDao, ArticleDao articleDao) {
        this.authorDao = authorDao;
        this.articleDao = articleDao;
    }

    @RequestMapping("/deleteauthor/{id}")
    public String delete(@PathVariable long id){

        List<Article> list = articleDao.findAuthorById(id);
        if (!(list.size() == 0)) {
            return "noDelete";
        }

        Author author = authorDao.findById(id);
        authorDao.delete(author);
        return "redirect:/listofauthors";
    }

    @RequestMapping("/editauthor/{id}")
    public String edit(@PathVariable long id, Model model){
        Author author = authorDao.findById(id);
        model.addAttribute("author", author);
        return "editAuthor";
    }

    @RequestMapping("/editauthor")
    public String editAuthor (@Valid Author author, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "editAuthor";
        }
        authorDao.update(author);
        return "redirect:/listofauthors";
    }

    @GetMapping("/listofauthors")
    public String list(){
        return "listOfAuthors";
    }

    @GetMapping("/addauthor")
    public String formAuthor(Model model){
        model.addAttribute("author", new Author());
        return "addAuthor";
    }

    @PostMapping("/addauthor")
    public String add (@Valid Author author, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "addAuthor";
        }
        authorDao.save(author);
        return "redirect:/listofauthors";
    }

    @ModelAttribute("authors")
    public Collection<Author> authors(){
        return this.authorDao.findAll();
    }
    
}
