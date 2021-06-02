package uk.ac.ucl.servlets.subItem;

import uk.ac.ucl.dataframe.SubItem;
import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteSubItemServlet", urlPatterns = {"/subItem/delete"})
public class DeleteSubItemServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Model model = ModelFactory.getModel();

        int updateSubItemId = Integer.parseInt(request.getParameter("deleteSubItemId"));
        int updateParentItemId = Integer.parseInt(request.getParameter("deleteParentItemId"));
        int updateParentDataframeId = Integer.parseInt(request.getParameter("deleteParentDataframeId"));

        try {
            model.getDataframeById(updateParentDataframeId).getItemById(updateParentItemId).removeSubItem(updateSubItemId);
            List<SubItem> subItems = model.getDataframeById(updateParentDataframeId).getItemById(updateParentItemId).getSubItems();
            request.setAttribute("subItems", subItems);
            request.getRequestDispatcher("/subItems").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
