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
import java.util.List;

@WebServlet(name = "ListItemServlet", urlPatterns = {"/items"})
public class ListItemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Model model = ModelFactory.getModel();

        int dataframeId = Integer.parseInt(request.getParameter("requestItemsDataframeId"));
        try {
            List<Item> items = model.getDataframeById(dataframeId).getItems();
            request.setAttribute("items", items);
            request.getRequestDispatcher("item/listItem.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Model model = ModelFactory.getModel();

        try {
            request.getAttribute("items");
            request.getRequestDispatcher("item/listItem.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
