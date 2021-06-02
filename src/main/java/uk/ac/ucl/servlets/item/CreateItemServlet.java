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

@WebServlet(name = "CreateItemServlet", urlPatterns = {"/item/new"})
public class CreateItemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Model model = ModelFactory.getModel();

        try {
            List<Dataframe> dataframes = model.getListDataframe();
            request.setAttribute("dataframes", dataframes);
            request.getRequestDispatcher("createItem.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("e", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Model model = ModelFactory.getModel();

        int itemId = Integer.parseInt(request.getParameter("itemId"));
        int parentId = Integer.parseInt(request.getParameter("parentId"));
        String label = request.getParameter("label");
        String description = request.getParameter("description");
        String group = request.getParameter("group");

        try {
            if (!model.getDataframeById(parentId).getItemIds().contains(itemId)) {
                Item item = Item.createAsItem(itemId, parentId, label, description, group);
                model.getDataframeById(parentId).addItem(item);

                List<Item> items = model.getDataframeById(parentId).getItems();
                request.setAttribute("items", items);
                request.getRequestDispatcher("/items").forward(request, response);
            }
            else{
                request.setAttribute("e", "Item with this ID already exists in this dataframe!");
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("e", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
