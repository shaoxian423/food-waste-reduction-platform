package com.duan.fwrp.servlet;

import com.duan.fwrp.dao.SurplusFoodDAO;
import com.duan.fwrp.entity.SurplusFood;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求参数
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String userType = request.getParameter("userType");

        // 用户注册逻辑（根据实际实现修改）
        // 伪代码表示用户注册逻辑
        // User user = new User();
        // user.setName(name);
        // user.setEmail(email);
        // user.setPassword(password);
        // user.setUserType(userType);
        // UserDao userDao = new UserDao();
        // userDao.save(user);

        // 模拟注册成功后，查询 SurplusFood 表
        SurplusFoodDAO surplusFoodDAO = new SurplusFoodDAO();
        List<SurplusFood> surplusFoods = surplusFoodDAO.getAllSurplusFoods();

        // 将结果存储在请求属性中
        request.setAttribute("surplusFoods", surplusFoods);

        // 转发到 retailerDashboard.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("retailerDashboard.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
