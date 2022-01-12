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
import java.util.List;
import java.util.Locale;


@WebServlet(value = "/hello-servlet", urlPatterns = "/hello-servlet")
public class MainServlet extends HttpServlet {

    @Inject
    private ChemistryService chemistryService;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<link rel=\"stylesheet\" href=\"style.css\">");
        out.println("</head>");
        out.println("<body>");
        req.getRequestDispatcher("/header.jspf").include(req, resp);
        List<ChemistryEntity> allChemistry = chemistryService.getAllChemistry();

        out.println("<table>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<td>Каталог товаров</td>");
        out.println("<td></td>");
        out.println("<td></td>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");
        out.println("<tr>");
        int delimeter = 0;
        for (ChemistryEntity chemistry : allChemistry) {
            if (delimeter % 3 == 0){
                out.println("</tr>");
                out.println("<tr>");
            }
            out.println("<td>");
            out.println("<a href=\"entity-servlet?id=" + chemistry.getId() + "\">" + chemistry.getName() + "</a><br><br>");
            out.println("</td>");
            delimeter++;
        }
        out.println("</tr>");
        out.println("</tbody>");
        out.println("</table>");
        out.println("<h1>Добавить новый товар:</h1>");
        out.println("<form action=\"add-servlet\" method=\"get\">");
        out.println("<input type=\"text\" name=\"id\" placeholder=\"Id товара\" />");
        out.println("<input type=\"text\" name=\"label\" placeholder=\"Название товара\" />");
        out.println("<input type=\"submit\" value=\"ok\" />");
        req.getRequestDispatcher("/footer.jspf").include(req, resp);
        out.println("</body></html>");

    }

}