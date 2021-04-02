package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.entity.Article;

import java.util.Collection;

@Controller
public class HomePageController {

    private final ArticleDao articleDao;

    public HomePageController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }


    @ModelAttribute("articles5")
    public Collection<Article> articles5(){
        return this.articleDao.findLastFive();
    }

}
