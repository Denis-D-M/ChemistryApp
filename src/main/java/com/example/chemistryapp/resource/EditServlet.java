package com.example.chemistryapp.resource;

import com.example.chemistryapp.service.ChemistryService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/edit-servlet", urlPatterns = "/edit-servlet")
public class EditServlet extends HttpServlet {
    @Inject
    private ChemistryService chemistryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        chemistryService.editChemistry(Long.valueOf(req.getParameter("id")), req.getParameter("label"));
        req.getRequestDispatcher("hello-servlet").forward(req, resp);
    }
}
