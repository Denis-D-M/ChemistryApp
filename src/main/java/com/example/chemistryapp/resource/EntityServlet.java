package com.example.chemistryapp.resource;

import com.example.chemistryapp.service.ChemistryService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(value = "/entity-servlet", urlPatterns = "/entity-servlet")
public class EntityServlet extends HttpServlet {
    @Inject
    protected ChemistryService chemistryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + chemistryService.getChemistry(Long.valueOf(req.getParameter("id"))) + "</h1>");
        out.println("</body></html>");
    }
}