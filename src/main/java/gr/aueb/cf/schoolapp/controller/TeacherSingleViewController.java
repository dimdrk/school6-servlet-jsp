package gr.aueb.cf.schoolapp.controller;

import gr.aueb.cf.schoolapp.dto.TeacherReadOnlyDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/teachers/view")
public class TeacherSingleViewController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id").trim());
        String firstname = request.getParameter("firstname").trim();
        String lastname = request.getParameter("lastname").trim();

        TeacherReadOnlyDTO readOnlyDTO = new TeacherReadOnlyDTO(id, firstname, lastname);
        request.setAttribute("readOnlyDTO", readOnlyDTO);
        request.getRequestDispatcher("/WEB-INF/jsp/teacher-view.jsp").forward(request, response);
    }
}
