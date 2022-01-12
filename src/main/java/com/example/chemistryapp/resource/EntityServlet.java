package com.example.chemistryapp.resource;

import com.example.chemistryapp.entity.ChemistryEntity;
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
    private ChemistryService chemistryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        ChemistryEntity entity = chemistryService.getChemistry(Long.valueOf(req.getParameter("id")));
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<link rel=\"stylesheet\" href=\"style.css\">");
        out.println("</head>");
        out.println("<body>");
        req.getRequestDispatcher("/header.jspf").include(req, resp);
        out.println("<table>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<td>Id</td>");
        out.println("<td>Название</td>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");
        out.println("<tr>");
        out.println("<td>" + entity.getId() +"</td>");
        out.println("<td>" + entity.getName() +"</td>");
        out.println("</tr>");
        out.println("</tbody>");
        out.println("</table>");

        out.println("<h1>Введите новые данные товара:</h1>");
        out.println("<form action=\"edit-servlet\" method=\"get\">");
        out.println("<input type=\"text\" name=\"id\" value=" + entity.getId() + " />");
        out.println("<input type=\"text\" name=\"label\" value=" + entity.getName() + " />");
        out.println("<input type=\"submit\" value=\"ок\" />");
        req.getRequestDispatcher("/footer.jspf").include(req, resp);
        out.println("</body></html>");
    }
}
