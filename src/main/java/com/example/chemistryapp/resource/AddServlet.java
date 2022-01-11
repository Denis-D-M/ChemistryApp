package com.example.chemistryapp.resource;

import com.example.chemistryapp.service.ChemistryService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/add-servlet", urlPatterns = "/add-servlet")
public class AddServlet extends HttpServlet {
    @Inject
    private ChemistryService chemistryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        chemistryService.addChemistry(Long.valueOf(req.getParameter("id")), req.getParameter("label"));
        req.getRequestDispatcher("hello-servlet").forward(req, resp);
    }
}
