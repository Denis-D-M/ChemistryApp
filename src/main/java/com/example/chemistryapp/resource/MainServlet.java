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
import java.util.List;


@WebServlet(value = "/hello-servlet", urlPatterns = "/hello-servlet")
public class MainServlet extends HttpServlet {

    @Inject
    protected ChemistryService chemistryService;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        List<ChemistryEntity> allChemistry = chemistryService.getAllChemistry();
        for (ChemistryEntity chemistry : allChemistry) {
            out.println("<a href=\"entity-servlet?id=" + chemistry.getId() + "\">" + chemistry.getName() + "</a><br><br>");
        }
        out.println("</body></html>");
    }

}