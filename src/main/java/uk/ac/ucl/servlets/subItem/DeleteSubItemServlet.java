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

        int editSubItemId = Integer.parseInt(request.getParameter("deleteSubItemId"));
        int editParentItemId = Integer.parseInt(request.getParameter("deleteParentItemId"));
        int editParentDataframeId = Integer.parseInt(request.getParameter("deleteParentDataframeId"));

        try {
            model.getDataframeById(editParentDataframeId).getItemById(editParentItemId).removeSubItem(editSubItemId);
            List<SubItem> subItems = model.getDataframeById(editParentDataframeId).getItemById(editParentItemId).getSubItems();
            request.setAttribute("subItems", subItems);
            request.getRequestDispatcher("/subItems").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("e", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
