package org.mickael.librarymsbook.controller;

import org.mickael.librarymsbook.exception.CategoryNotFoundException;
import org.mickael.librarymsbook.model.Category;
import org.mickael.librarymsbook.service.contract.CategoryServiceContract;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
//@PreAuthorize("isAuthenticated()")
public class CategoryRestController {

    private static final Logger logger = LoggerFactory.getLogger(CategoryRestController.class);
    private final CategoryServiceContract categoryServiceContract;

    @Autowired
    public CategoryRestController(CategoryServiceContract categoryServiceContract) {
        this.categoryServiceContract = categoryServiceContract;
    }

    @GetMapping
    public List<Category> getCategories(){
        try {
            return categoryServiceContract.findAll();
        } catch (CategoryNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Categorys found", ex);
        }
    }

    @GetMapping("/{id}")
    public Category retrieveCategory(@PathVariable Integer id){
        logger.debug("Get category by id : " + id);
        try {
            return categoryServiceContract.findById(id);
        } catch (CategoryNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found", ex);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    //@PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYEE')")
    public ResponseEntity<Category> createNewCategory(@Valid @RequestBody Category newCategory){
        if (newCategory == null){
            return ResponseEntity.noContent().build();
        }
        Category categorySaved = categoryServiceContract.save(newCategory);
        URI location = ServletUriComponentsBuilder
                               .fromCurrentRequest()
                               .path("/{id}")
                               .buildAndExpand(categorySaved.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    //@PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYEE')")
    public Category updateCategory(@PathVariable Integer id, @RequestBody Category category){
        try {
            return categoryServiceContract.update(category);
        } catch (CategoryNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Provide correct Category ID", ex);
        }
    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("hasAuthority('DELETE')")
    public void deleteCategory(@PathVariable Integer id){
        categoryServiceContract.deleteById(id);
    }


}
