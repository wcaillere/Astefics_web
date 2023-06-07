package com.astefics.astefics_web.DAO;

import com.astefics.astefics_web.entity.Category;
import com.astefics.astefics_web.repository.ICategoryRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
@AllArgsConstructor
public class CategoryDAO {

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

    public void modifyCategory(Integer id, String newName) {
        if (repository.findCategoryByName(newName).size() == 0) {
            Category category = new Category();

            category.setId(id);
            category.setName(newName);

            repository.save(category);
        }
    }
}
