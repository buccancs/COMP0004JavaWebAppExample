package uk.ac.ucl.servlets.subItem;

import uk.ac.ucl.dataframe.Dataframe;
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

@WebServlet(name = "CreateSubItemServlet", urlPatterns = {"/subItem/new"})
public class CreateSubItemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Model model = ModelFactory.getModel();

        try {
            List<Dataframe> dataframes = model.getListDataframe();
            request.setAttribute("dataframes", dataframes);
            request.getRequestDispatcher("createSubItem.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("e", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Model model = ModelFactory.getModel();

        int parentItemID = Integer.parseInt(request.getParameter("parentItemId"));
        int parentDataframeId = Integer.parseInt(request.getParameter("parentDataframeId"));
        int dataId = Integer.parseInt(request.getParameter("dataId"));
        String dataType = request.getParameter("dataType");
        String data = request.getParameter("data");

        try {
            if (!model.getDataframeById(parentDataframeId).getItemById(parentItemID).getSubItemIds().contains(dataId)) {
                SubItem subItem = SubItem.create(dataId, parentItemID, parentDataframeId, dataType, data);
                model.getDataframeById(parentDataframeId).getItemById(parentItemID).addSubItem(subItem);

                List<SubItem> subItems = model.getDataframeById(parentDataframeId).getItemById(parentItemID).getSubItems();
                request.setAttribute("subItems", subItems);
                request.getRequestDispatcher("/subItems").forward(request, response);
            } else {
                request.setAttribute("e", "SubItem with this ID already exists in this Item!");
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("e", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
