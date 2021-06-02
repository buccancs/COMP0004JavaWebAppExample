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

@WebServlet(name = "UpdateSubItemServlet", urlPatterns = {"/subItem/update"})
public class UpdateSubItemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Model model = ModelFactory.getModel();
        int updateSubItemId = Integer.parseInt(request.getParameter("updateSubItemId"));
        int updateParentItemId = Integer.parseInt(request.getParameter("updateParentItemId"));
        int updateParentDataframeId = Integer.parseInt(request.getParameter("updateParentDataframeId"));

        try {
            request.setAttribute("dataId", updateSubItemId);
            request.setAttribute("parentItemId", updateParentItemId);
            request.setAttribute("parentDataframeId", updateParentDataframeId);
            request.getRequestDispatcher("updateSubItem.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Model model = ModelFactory.getModel();
        int dataID = Integer.parseInt(request.getParameter("dataId"));
        int parentItemId = Integer.parseInt(request.getParameter("parentItemId"));
        int parentDataframeId = Integer.parseInt(request.getParameter("parentDataframeId"));
        String dataType = request.getParameter("dataType");
        String data = request.getParameter("data");

        try {
            SubItem subItem = model.getDataframeById(parentDataframeId).getItemById(parentItemId).getSubItemById(dataID);
            subItem.setDataType(dataType);
            subItem.setData(data);
            List<SubItem> subItems = model.getDataframeById(parentDataframeId).getItemById(parentItemId).getSubItems();
            request.setAttribute("subItems", subItems);
            request.getRequestDispatcher("/subItems").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
