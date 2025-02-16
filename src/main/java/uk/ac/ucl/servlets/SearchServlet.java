package uk.ac.ucl.servlets.dataframe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SearchServlet", urlPatterns = {"/search"})
public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("search.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String dataStructure = request.getParameter("dataStructure");
        String searchTerm = request.getParameter("searchTerm");

        switch (dataStructure) {
            case "dataframe" -> {
                request.setAttribute("searchTerm", searchTerm);
                request.getRequestDispatcher("/dataframe/search").forward(request, response);
            }
            case "item" -> {
                request.setAttribute("searchTerm", searchTerm);
                request.getRequestDispatcher("/item/search").forward(request, response);
            }
            case "subItem" -> {
                request.setAttribute("searchTerm", searchTerm);
                request.getRequestDispatcher("/subItem/search").forward(request, response);
            }
            default -> request.getRequestDispatcher("/").forward(request, response);
        }
    }
}