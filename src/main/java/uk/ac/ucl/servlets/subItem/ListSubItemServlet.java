package uk.ac.ucl.servlets.subItem;

import uk.ac.ucl.dataframe.SubItem;
import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;
import uk.ac.ucl.utilities.SaveModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListSubItemServlet", urlPatterns = {"/subItems"})
public class ListSubItemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Model model = ModelFactory.getModel();

        int itemId = Integer.parseInt(request.getParameter("parentItemId"));
        int dataframeId = Integer.parseInt(request.getParameter("parentDataframeId"));
        try {
            List<SubItem> subItems = model.getDataframeById(dataframeId).getItemById(itemId).getSubItems();
            request.setAttribute("subItems", subItems);
            SaveModel.saveSubItems(model);
            request.getRequestDispatcher("subItem/listSubItem.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("e", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Model model = ModelFactory.getModel();

        try {
            request.getAttribute("subItems");
            SaveModel.saveSubItems(model);
            request.getRequestDispatcher("subItem/listSubItem.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("e", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
