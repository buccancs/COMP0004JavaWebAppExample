package uk.ac.ucl.servlets.item;

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

@WebServlet(name = "SearchItemServlet", urlPatterns = {"/item/search"})
public class SearchItemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("searchItem.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Model model = ModelFactory.getModel();

        String searchTerm = request.getParameter("searchTerm");
        List<Item> allMatchingItems = new ArrayList<Item>();

        for (Dataframe dataframe : model.getListDataframe()) {
            for (Item item : dataframe.getItems()) {
                if (item.getLabel().equals(searchTerm)) {
                    allMatchingItems.add(item);
                }
            }
        }
        request.setAttribute("items", allMatchingItems);
        request.getRequestDispatcher("/items").forward(request, response);
    }
}
