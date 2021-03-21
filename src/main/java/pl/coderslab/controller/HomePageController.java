package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;

import java.util.List;

@Controller
public class HomePageController {

    private final ArticleDao articleDao;

    public HomePageController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @GetMapping("/")
    public String home(Model model){
        List<Article> articles = articleDao.findAll();
        model.addAttribute("articles", articles);
        return "home.jsp";
    }


}
