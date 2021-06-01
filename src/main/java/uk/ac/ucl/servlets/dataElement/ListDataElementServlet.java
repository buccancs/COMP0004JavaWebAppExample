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

@WebServlet(name = "ListDataElementServlet", urlPatterns = {"/dataElements"})
public class ListDataElementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Model model = ModelFactory.getModel();

        int itemId = Integer.parseInt(request.getParameter("parentItemId"));
        int dataframeId = Integer.parseInt(request.getParameter("parentDataframeId"));
        try {
            List<DataElement> dataElements = model.getDataframeById(dataframeId).getItemById(itemId).getDataElements();
            request.setAttribute("dataElements", dataElements);
            model.saveFileDataElement();
            request.getRequestDispatcher("dataElement/listDataElement.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Model model = ModelFactory.getModel();

        try {
            request.getAttribute("dataElements");
            model.saveFileDataElement();
            request.getRequestDispatcher("dataElement/listDataElement.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
