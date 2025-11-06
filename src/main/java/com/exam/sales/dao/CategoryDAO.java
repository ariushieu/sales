package com.exam.sales.dao;

import com.exam.sales.model.Category;
import com.exam.sales.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryDAO {
    private static final String SELECT_ALL_CATEGORIES = "SELECT * FROM categories";
    private static final String SELECT_CATEGORY_BY_ID = "SELECT * FROM categories WHERE categoryId = ?";
    private static final String INSERT_CATEGORY = "INSERT INTO categories (type, description) VALUES (?, ?)";
    private static final String UPDATE_CATEGORY = "UPDATE categories SET type = ?, description = ? WHERE categoryId = ?";
    private static final String DELETE_CATEGORY = "DELETE FROM categories WHERE categoryId = ?";

    private Category extractCategoryFromResultSet(ResultSet rs) throws SQLException {
        Category category = new Category();
        category.setCategoryId(rs.getLong("categoryId"));
        category.setType(rs.getString("type"));
        category.setDescription(rs.getString("description"));
        return category;
    }

    public List<Category> getAllCategories() throws SQLException {
        List<Category> categories = new ArrayList<>();

        try (
                Connection conn = ConnectionUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_CATEGORIES);
                ResultSet rs = stmt.executeQuery();
        ) {
            while (rs.next()) {
                categories.add(extractCategoryFromResultSet(rs));
            }

        } catch (Exception e) {
            throw new SQLException("Lỗi truy vấn tất cả danh mục.", e);
        }
        return categories;
    }

    public Category selectCategoryById(Long categoryId) throws SQLException {
        Category category = null;
        try (
                Connection conn = ConnectionUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SELECT_CATEGORY_BY_ID);
        ) {
            stmt.setLong(1, categoryId);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    category = extractCategoryFromResultSet(rs);
                }
            }
        } catch (Exception e) {
            throw new SQLException("Lỗi truy vấn danh mục có ID: " + categoryId, e);
        }
        return category;
    }

    public boolean createCategory(Category category) throws SQLException {
        try (
                Connection conn = ConnectionUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(INSERT_CATEGORY)
        ){
            stmt.setString(1, category.getType());
            stmt.setString(2, category.getDescription());

            return stmt.executeUpdate() > 0;
        }catch (Exception e){
            throw new SQLException("Lỗi khi thêm danh mục mới ", e);
        }
    }
}
