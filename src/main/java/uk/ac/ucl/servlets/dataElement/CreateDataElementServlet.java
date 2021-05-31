package uk.ac.ucl.servlets.dataElement;

import uk.ac.ucl.dataframe.DataElement;
import uk.ac.ucl.dataframe.Dataframe;
import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CreateDataElementServlet", urlPatterns = {"/dataElement/new"})
public class CreateDataElementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Model model = ModelFactory.getModel();

        try {
            List<Dataframe> dataframes = model.getListDataframe();
            request.setAttribute("dataframes", dataframes);
            request.getRequestDispatcher("createDataElement.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
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
            DataElement dataElement = DataElement.create(dataId, parentItemID, parentDataframeId, dataType, data);
            model.getDataframeById(parentDataframeId).getItemById(parentItemID).addDataElement(dataElement);
            List<DataElement> dataElements = model.getDataframeById(parentDataframeId).getItemById(parentItemID).getDataElements();
            request.setAttribute("dataElements", dataElements);
            request.getRequestDispatcher("/dataElements").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
