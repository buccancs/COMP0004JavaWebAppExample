package uk.ac.ucl.servlets.item;

import uk.ac.ucl.dataframe.DataElement;
import uk.ac.ucl.dataframe.Dataframe;
import uk.ac.ucl.dataframe.Item;
import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteItemServlet", urlPatterns = {"/item/delete"})
public class DeleteItemServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Model model = ModelFactory.getModel();

        int itemId = Integer.parseInt(request.getParameter("deleteItemId"));
        int dataframeId = Integer.parseInt(request.getParameter("deleteItemParentId"));

        try {
            model.getDataframeById(dataframeId).removeItem(itemId);
            List<Item> items = model.getDataframeById(dataframeId).getItems();
            request.setAttribute("items", items);
            request.getRequestDispatcher("/items").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
