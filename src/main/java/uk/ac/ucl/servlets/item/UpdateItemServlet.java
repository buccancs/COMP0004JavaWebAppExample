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

@WebServlet(name = "UpdateItemServlet", urlPatterns = {"/?dataframeId={dataframeId}&itemId={itemId}/new"})
public class UpdateItemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Model model = ModelFactory.getModel();

        int dataframeId = Integer.parseInt(request.getParameter("dataframeId"));
        int itemId = Integer.parseInt(request.getParameter("itemId"));

        try {
            Item item = model.getDataframeById(dataframeId).getItemById(itemId);
            request.setAttribute("item", item);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }

        request.getRequestDispatcher("/updateItem.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Model model = ModelFactory.getModel();

        int itemId = Integer.parseInt(request.getParameter("itemId"));
        int dataframeId = Integer.parseInt(request.getParameter("parentId"));
        String label = request.getParameter("label");
        String description = request.getParameter("description");
        String group = request.getParameter("group");

        try {
            Item item = model.getDataframeById(dataframeId).getItemById(itemId);
            item.setLabel(label);
            item.setDescription(description);
            item.setGroup(group);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }

        request.getRequestDispatcher("/ListItem.jsp").forward(request, response);

    }

}