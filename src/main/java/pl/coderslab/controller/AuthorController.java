package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;

import java.util.Collection;

@Controller
public class AuthorController {
    
    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @RequestMapping("/deleteauthor/{id}")
    public String delete(@PathVariable long id){
        Author author = authorDao.findById(id);
        authorDao.delete(author);
        return "redirect:/listofauthors";
    }

    @RequestMapping("/editauthor/{id}")
    public String edit(@PathVariable long id, Model model){
        Author author = authorDao.findById(id);
        model.addAttribute("author", author);
        return "/editAuthor.jsp";
    }

    @RequestMapping("/editauthor")
    public String editAuthor (Author author){
        authorDao.update(author);
        return "redirect:/listofauthors";
    }

    @GetMapping("/listofauthors")
    public String list(){
        return "listOfAuthors.jsp";
    }

    @GetMapping("/addauthor")
    public String formAuthor(Model model){
        model.addAttribute("author", new Author());
        return "/addAuthor.jsp";
    }

    @PostMapping("/addauthor")
    public String add (Author author, Model model){
        authorDao.save(author);
        return "redirect:/listofauthors";
    }

    @ModelAttribute("authors")
    public Collection<Author> authors(){
        return this.authorDao.findAll();
    }
    
}
