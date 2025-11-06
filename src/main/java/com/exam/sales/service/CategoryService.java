package com.exam.sales.service;

import com.exam.sales.dao.CategoryDAO;
import com.exam.sales.model.Category;

import java.sql.SQLException;
import java.util.List;

public class CategoryService {
    private final CategoryDAO categoryDAO;

//    public CategoryService(CategoryDAO categoryDAO) {
//        this.categoryDAO = categoryDAO;
//    }

    public CategoryService() {
        this.categoryDAO =  new CategoryDAO();
    }

    public List<Category> getAllCategories(){
        try{
            return categoryDAO.getAllCategories();
        }catch (SQLException e){
            throw new RuntimeException("Không thể lấy danh sách danh mục.", e);
        }
    }


    public Category getCategoryById(Long categoryId){
        try{
            return categoryDAO.selectCategoryById(categoryId);
        }catch (Exception e){
            throw new RuntimeException("Không thể lấy danh mục có ID: " + categoryId, e);
        }
    }
}
