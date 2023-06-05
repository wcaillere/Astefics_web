package com.astefics.astefics_web.DAO;

import com.astefics.astefics_web.entity.Category;
import com.astefics.astefics_web.repository.ICategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryDAO {

    @Autowired
    private ICategoryRepository repository;

    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    public Category getOneCategoryById(Integer id) {
        Category category = null;
        Optional<Category> foundCategory = repository.findById(id);

        if (foundCategory.isPresent()) {
            category = foundCategory.get();
        }

        return category;
    }

    public void addCategory(Category category) {
        if (repository.findCategoryByName(category.getName()).size() == 0) {
            repository.save(category);
        }
        ;
    }

    public void deleteCategory(Integer id) {
        if (getOneCategoryById(id) != null) {
            repository.deleteById(id);
        }
    }
}
