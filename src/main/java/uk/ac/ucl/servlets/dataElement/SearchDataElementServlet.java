package uk.ac.ucl.servlets.dataElement;

import uk.ac.ucl.dataframe.DataElement;
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

@WebServlet(name = "SearchDataElementServlet", urlPatterns = {"/dataElement/search"})
public class SearchDataElementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("searchDataElement.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Model model = ModelFactory.getModel();

        String searchTerm = request.getParameter("searchTerm");
        List<DataElement> allMatchingItems = new ArrayList<DataElement>();

        for (Dataframe dataframe: model.getListDataframe()){
            for (Item item : dataframe.getItems()){
                for (DataElement dataElement : item.getDataElements()){
                    if (dataElement.getDataType().equals(searchTerm)) {
                        allMatchingItems.add(dataElement);
                    }
                }
            }
        }
        request.setAttribute("dataElements", allMatchingItems);
        request.getRequestDispatcher("/dataElements").forward(request, response);
    }
}
