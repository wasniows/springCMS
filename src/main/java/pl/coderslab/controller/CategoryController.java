package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Category;

import javax.validation.Valid;
import java.util.Collection;

@Controller
public class CategoryController {

    private final CategoryDao categoryDao;

    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @RequestMapping("/deletecategory/{id}")
    public String delete(@PathVariable long id){
        Category category = categoryDao.findById(id);
        categoryDao.delete(category);
        return "redirect:/listofcategories";
    }

    @RequestMapping("/editcategory/{id}")
    public String edit(@PathVariable long id, Model model){
        Category category = categoryDao.findById(id);
        model.addAttribute("category", category);
        return "editCategory";
    }

    @RequestMapping("/editcategory")
    public String editCategory (@Valid Category category, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "editCategory";
        }
        categoryDao.update(category);
        return "redirect:/listofcategories";
    }

    @GetMapping("/listofcategories")
    public String list(){

        return "listOfCategories";
    }

    @GetMapping("/addcategory")
    public String form(Model model){
        model.addAttribute("category", new Category());
        return "addCategory";
    }

    @PostMapping("/addcategory")
    public String add (@Valid Category category, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "addCategory";
        }
        categoryDao.save(category);
        return "redirect:/listofcategories";
    }

    @ModelAttribute("categories")
    public Collection<Category> categories(){
        return this.categoryDao.findAll();
    }

}
