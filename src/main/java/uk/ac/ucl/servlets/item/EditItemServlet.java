package uk.ac.ucl.servlets.item;

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

@WebServlet(name = "EditItemServlet", urlPatterns = {"/item/edit"})
public class EditItemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Model model = ModelFactory.getModel();
        int editItemId = Integer.parseInt(request.getParameter("editItemId"));
        int editItemParentId = Integer.parseInt(request.getParameter("editItemParentId"));

        try {
            request.setAttribute("dataframes", model.getListDataframe());
            request.setAttribute("editItemId", editItemId);
            request.setAttribute("editItemParentId", editItemParentId);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }

        request.getRequestDispatcher("editItem.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Model model = ModelFactory.getModel();

        int itemId = Integer.parseInt(request.getParameter("itemId"));
        int parentId = Integer.parseInt(request.getParameter("parentId"));
        int newParentId = Integer.parseInt(request.getParameter("newParentId"));
        String label = request.getParameter("label");
        String description = request.getParameter("description");
        String group = request.getParameter("group");

        try {
            Item item = model.getDataframeById(parentId).getItemById(itemId);
            if (newParentId == parentId) {
                item.setLabel(label);
                item.setDescription(description);
                item.setGroup(group);

            } else {
                model.getDataframeById(parentId).removeItem(itemId);
                model.getDataframeById(newParentId).addItem(itemId, newParentId, label, description, group);
            }
            List<Item> items = model.getDataframeById(newParentId).getItems();
            request.setAttribute("items", items);
            request.getRequestDispatcher("/items").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}