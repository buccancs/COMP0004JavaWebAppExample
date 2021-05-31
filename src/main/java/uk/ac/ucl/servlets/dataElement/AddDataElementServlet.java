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

@WebServlet(name = "AddDataElementServlet", urlPatterns = {"/dataElements?item={id}/new"})
public class AddDataElementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/createDataElement.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Model model = ModelFactory.getModel();

        int itemId = Integer.parseInt(request.getParameter("itemId"));
        int dataId = Integer.parseInt(request.getParameter("dataId"));
        String dataType = request.getParameter("dataType");
        String data = request.getParameter("data");

        DataElement dataElement = DataElement.create(dataId, dataType, data);

        for (Dataframe dataframe : model.getListDataframe()){
            for (Item item : dataframe.getItems()){
                if (item.getItemId() == itemId){
                    item.addDataElement(dataElement);
                }
                else{

                }
            }
        }
        request.getRequestDispatcher("/ListItemServlet").forward(request, response);
    }
}
