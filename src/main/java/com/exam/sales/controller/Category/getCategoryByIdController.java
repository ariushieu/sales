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

@WebServlet("/category/detail")
public class getCategoryByIdController extends HttpServlet {
    private CategoryService categoryService;

    @Override
    public void init() {
        categoryService = new CategoryService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        String idParam = req.getParameter("categoryId");
        if(idParam == null || idParam.isEmpty()){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Thiếu tham số id");
            return;
        }
        try{
            Long categoryId = Long.parseLong(idParam);
            Category category = categoryService.getCategoryById(categoryId);

            if (category == null){
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Không tìm thấy danh mục ID: " + categoryId);
                return;
            }
            req.setAttribute("category", category);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/categories-detail.jsp");
            dispatcher.forward(req, resp);
        }catch (NumberFormatException e){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID không hợp lệ");
        }catch (Exception e){
            throw new ServletException("Lỗi khi lấy chi tiết danh mục", e);
        }
    }
}
