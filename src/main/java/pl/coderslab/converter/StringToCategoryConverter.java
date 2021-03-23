package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Category;

public class StringToCategoryConverter implements Converter<String, Category> {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Category convert(String s) {
        return categoryDao.findById(Long.parseLong(s));
    }
}
