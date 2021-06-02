package uk.ac.ucl.servlets.dataframe;

import uk.ac.ucl.dataframe.Dataframe;
import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateDataframeServlet", urlPatterns = {"/dataframe/edit"})
public class EditDataframeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Model model = ModelFactory.getModel();
        int dataframeId = Integer.parseInt(request.getParameter("editDataframeId"));

        try {
            request.setAttribute("dataframes", model.getListDataframe());
            request.setAttribute("dataframeId", dataframeId);
            request.getRequestDispatcher("editDataframe.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Model model = ModelFactory.getModel();

        int dataframeId = Integer.parseInt(request.getParameter("dataframeId"));
        String newLabel = request.getParameter("label");
        String newDescription = request.getParameter("description");

        try {
            Dataframe dataframe = model.getDataframeById(dataframeId);
            dataframe.setLabel(newLabel);
            dataframe.setDescription(newDescription);
            request.setAttribute("dataframes", model.getListDataframe());
            request.getRequestDispatcher("/dataframes").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
