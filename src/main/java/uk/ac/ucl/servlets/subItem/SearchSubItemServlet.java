package uk.ac.ucl.servlets.subItem;

import uk.ac.ucl.dataframe.Dataframe;
import uk.ac.ucl.dataframe.Item;
import uk.ac.ucl.dataframe.SubItem;
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

@WebServlet(name = "SearchSubItemServlet", urlPatterns = {"/subItem/search"})
public class SearchSubItemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("searchSubItem.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Model model = ModelFactory.getModel();

        String searchTerm = request.getParameter("searchTerm");
        List<SubItem> allMatchingItems = new ArrayList<SubItem>();

        for (Dataframe dataframe: model.getListDataframe()){
            for (Item item : dataframe.getItems()){
                for (SubItem subItem : item.getSubItems()){
                    if (subItem.getDataType().equals(searchTerm)) {
                        allMatchingItems.add(subItem);
                    }
                }
            }
        }
        request.setAttribute("subItems", allMatchingItems);
        request.getRequestDispatcher("/subItems").forward(request, response);
    }
}
