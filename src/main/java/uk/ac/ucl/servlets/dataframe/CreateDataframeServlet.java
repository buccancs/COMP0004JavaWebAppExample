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

@WebServlet(name = "CreateDataframeServlet", urlPatterns = {"/dataframe/new"})
public class CreateDataframeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("createDataframe.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Model model = ModelFactory.getModel();

        int dataframeId = Integer.parseInt(request.getParameter("dataframeId"));
        String label = request.getParameter("label");
        String description = request.getParameter("description");

        Dataframe newDataframe = Dataframe.create(dataframeId, label, description);

        try {
            model.addDataframe(newDataframe);
            request.getRequestDispatcher("/dataframes").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
