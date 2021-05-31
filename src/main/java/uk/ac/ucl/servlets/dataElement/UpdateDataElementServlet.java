package uk.ac.ucl.servlets.dataElement;

import uk.ac.ucl.dataframe.DataElement;
import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UpdateDataElementServlet", urlPatterns = {"/dataElement/update"})
public class UpdateDataElementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Model model = ModelFactory.getModel();
        int updateDataElementId = Integer.parseInt(request.getParameter("updateDataElementId"));
        int updateParentItemId = Integer.parseInt(request.getParameter("updateParentItemId"));
        int updateParentDataframeId = Integer.parseInt(request.getParameter("updateParentDataframeId"));

        try {
            request.setAttribute("dataId", updateDataElementId);
            request.setAttribute("parentItemId", updateParentItemId);
            request.setAttribute("parentDataframeId", updateParentDataframeId);
            request.getRequestDispatcher("updateDataElement.jsp").forward(request, response);
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
            DataElement dataElement = model.getDataframeById(parentDataframeId).getItemById(parentItemId).getDataElementById(dataID);
            dataElement.setDataType(dataType);
            dataElement.setData(data);
            List<DataElement> dataElements = model.getDataframeById(parentDataframeId).getItemById(parentItemId).getDataElements();
            request.setAttribute("dataElements", dataElements);
            request.getRequestDispatcher("/dataElements").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
