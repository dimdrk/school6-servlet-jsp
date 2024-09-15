package gr.aueb.cf.schoolapp.controller;

import gr.aueb.cf.schoolapp.authentication.AuthenticationProvider;
import gr.aueb.cf.schoolapp.dao.ITeacherDAO;
import gr.aueb.cf.schoolapp.dao.IUserDAO;
import gr.aueb.cf.schoolapp.dao.TeacherDAOImpl;
import gr.aueb.cf.schoolapp.dao.UserDAOImpl;
import gr.aueb.cf.schoolapp.dao.exceptions.UserDAOException;
import gr.aueb.cf.schoolapp.dto.UserLoginDTO;
import gr.aueb.cf.schoolapp.service.ITeacherService;
import gr.aueb.cf.schoolapp.service.IUserService;
import gr.aueb.cf.schoolapp.service.TeacherServiceImpl;
import gr.aueb.cf.schoolapp.service.UserServiceImpl;
import gr.aueb.cf.schoolapp.service.exceptions.UserNotFoundException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    IUserDAO userDAO = new UserDAOImpl();
    IUserService userService = new UserServiceImpl(userDAO);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String isError = request.getParameter("isError");
        request.setAttribute("isError", isError == null ? "false" : "true");

        request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Data binding
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean principleIsAuthenticated = false;

        UserLoginDTO userLoginDTO = new UserLoginDTO(username, password);

        try {
            principleIsAuthenticated = AuthenticationProvider.authenticate(userLoginDTO);

            if (principleIsAuthenticated) {
                HttpSession session = request.getSession(false);
                session.setAttribute("username", username);
                // session.setAttribute("role", userService.getUserByUsername(username).getRoleType().name());
                response.sendRedirect(request.getContextPath() + "/teachers");
            } else {
                response.sendRedirect(request.getContextPath() + "/login?isError=true");
            }
        } catch (UserDAOException e) {
        //} catch (UserDAOException | UserNotFoundException e) {
            response.sendRedirect(request.getContextPath() + "/login?isError=true");
        }
    }
}