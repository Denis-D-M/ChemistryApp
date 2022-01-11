package com.example.chemistryapp.resource;

import com.example.chemistryapp.entity.ChemistryEntity;
import com.example.chemistryapp.service.ChemistryService;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(value = "/entity-servlet", urlPatterns = "/entity-servlet")
public class EntityServlet extends HttpServlet {
    @Inject
    private ChemistryService chemistryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        ChemistryEntity entity = chemistryService.getChemistry(Long.valueOf(req.getParameter("id")));
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Id - " + entity.getId() + "</h1>");
        out.println("<h1>" + "Label - " + entity.getName() + "</h1>");

        out.println("<form action=\"edit-servlet\" method=\"get\">");
        out.println("<input type=\"text\" name=\"id\" value=" + entity.getId() + " />");
        out.println("<input type=\"text\" name=\"label\" value=" + entity.getName() + " />");
        out.println("<input type=\"submit\" value=\"ok\" />");
        out.println("</body></html>");
    }
}
