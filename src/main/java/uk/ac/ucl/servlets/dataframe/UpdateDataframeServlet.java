package uk.ac.ucl.servlets.dataframe;

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

@WebServlet(name = "UpdateDataframeServlet", urlPatterns = {"/dataframe/update"})
public class UpdateDataframeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Model model = ModelFactory.getModel();

        try {
            request.setAttribute("dataframes", model.getListDataframe());
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
        request.getRequestDispatcher("updateDataframe.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Model model = ModelFactory.getModel();

        int dataframeId = Integer.parseInt(request.getParameter("dataframeId"));
        int newDataframeId = Integer.parseInt(request.getParameter("newDataframeId"));
        String newLabel = request.getParameter("label");
        String newDescription = request.getParameter("description");

        try {
            Dataframe dataframe = model.getDataframeById(dataframeId);
            dataframe.setDataFrameId(newDataframeId);
            dataframe.setLabel(newLabel);
            dataframe.setDescription(newDescription);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
        request.getRequestDispatcher("dataframes").forward(request, response);
    }

}
