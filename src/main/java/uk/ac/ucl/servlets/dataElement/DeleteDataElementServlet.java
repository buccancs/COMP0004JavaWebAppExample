package uk.ac.ucl.servlets.dataElement;

import uk.ac.ucl.dataframe.DataElement;
import uk.ac.ucl.dataframe.Dataframe;
import uk.ac.ucl.dataframe.Item;
import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteDataElementServlet", urlPatterns = {"/dataElement/delete"})
public class DeleteDataElementServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Model model = ModelFactory.getModel();

        int updateDataElementId = Integer.parseInt(request.getParameter("deleteDataElementId"));
        int updateParentItemId = Integer.parseInt(request.getParameter("deleteParentItemId"));
        int updateParentDataframeId = Integer.parseInt(request.getParameter("deleteParentDataframeId"));

        try {
            model.getDataframeById(updateParentDataframeId).getItemById(updateParentItemId).removeDataElement(updateDataElementId);
            List<DataElement> dataElements = model.getDataframeById(updateParentDataframeId).getItemById(updateParentItemId).getDataElements();
            request.setAttribute("dataElements", dataElements);
            request.getRequestDispatcher("/dataElements").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
