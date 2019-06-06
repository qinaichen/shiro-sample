package com.cns.shiro.servlet;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        String errorMsg = null;
        try {
            subject.login(token);

        }catch (UnknownAccountException e){
            errorMsg = "找不到此用户名";
        }catch (IncorrectCredentialsException e){
            errorMsg = "密码错误";
        }catch (AuthenticationException e){
            errorMsg = "其他异常："+e.getMessage() ;
        }
        if(errorMsg != null){
            request.setAttribute("errorMsg",errorMsg);
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else{
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
}
