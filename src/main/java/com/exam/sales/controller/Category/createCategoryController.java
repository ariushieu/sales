package com.exam.sales.controller.Category;

import com.exam.sales.model.Category;
import com.exam.sales.service.CategoryService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/category/add")
public class createCategoryController extends HttpServlet {
    private CategoryService categoryService;

    @Override
    public void init() {
        categoryService = new CategoryService();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/categories-add.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String type = req.getParameter("type");
        String description = req.getParameter("description");

        if (type == null || type.isEmpty()){
            req.setAttribute("error", "Tên loại không được bỏ trống");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/categories-add.jsp");
            dispatcher.forward(req, resp);
            return;
        }

        Category category = new Category();
        category.setType(type);
        category.setDescription(description);

        try {
            boolean isCreated = categoryService.createCategory(category);
            if (isCreated){
                resp.sendRedirect("/categories");
            }else {
                req.setAttribute("error", "Thêm danh mục thất bại!");
                RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/categories-list.jsp");
                dispatcher.forward(req, resp);
            }
        }catch (Exception e){
            throw new ServletException("Lỗi khi thêm danh mục mới", e);
        }
    }
}
