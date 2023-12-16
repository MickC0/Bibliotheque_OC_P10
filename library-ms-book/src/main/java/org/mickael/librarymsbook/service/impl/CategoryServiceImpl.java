package org.mickael.librarymsbook.service.impl;


import org.mickael.librarymsbook.exception.CategoryNotFoundException;
import org.mickael.librarymsbook.model.Category;
import org.mickael.librarymsbook.repository.CategoryRepository;
import org.mickael.librarymsbook.service.contract.CategoryServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryServiceContract {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() throws CategoryNotFoundException {
        List<Category> categorys = categoryRepository.findAll();
        if (categorys.isEmpty()){
            throw new CategoryNotFoundException("No category found");
        }
        return categorys;
    }

    @Override
    public Category findById(Integer id) throws CategoryNotFoundException {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (!optionalCategory.isPresent()){
            throw new CategoryNotFoundException("Category not found in repository");
        }
        return optionalCategory.get();
    }

    @Override
    public Category save(Category category) {

        Category savedCategory = categoryRepository.save(category);

        return savedCategory;
    }

    @Override
    public Category update(Category category) throws CategoryNotFoundException{
        Optional<Category> optionalCategory = categoryRepository.findById(category.getId());
        if (!optionalCategory.isPresent()){
            throw new CategoryNotFoundException("Category not found in repository");
        }
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(Integer id) {
        categoryRepository.deleteById(id);
    }

}
