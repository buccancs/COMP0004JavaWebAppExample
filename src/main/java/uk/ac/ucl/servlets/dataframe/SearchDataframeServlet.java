package uk.ac.ucl.servlets.dataframe;

import uk.ac.ucl.dataframe.Dataframe;
import uk.ac.ucl.dataframe.Item;
import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SearchDataframeServlet", urlPatterns = {"/dataframe/search"})
public class SearchDataframeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("searchDataframe.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Model model = ModelFactory.getModel();

        String searchTerm = request.getParameter("searchTerm");
        List<Dataframe> allMatchingItems = new ArrayList<Dataframe>();

        for (Dataframe dataframe: model.getListDataframe()) {
            if (dataframe.getLabel().equals(searchTerm)) {
                allMatchingItems.add(dataframe);
            }
        }
        request.setAttribute("dataframes", allMatchingItems);
        request.getRequestDispatcher("/dataframes").forward(request, response);
    }
}