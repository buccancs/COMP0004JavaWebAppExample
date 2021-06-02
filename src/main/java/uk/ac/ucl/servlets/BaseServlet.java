package uk.ac.ucl.servlets.item;

import uk.ac.ucl.dataframe.Dataframe;
import uk.ac.ucl.dataframe.Item;
import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
public class BaseServlet extends HttpServlet{

    private Model model;

    public void setModel(Model model) throws IOException {
        this.model = ModelFactory.getModel();
    }

    public Model getModel() {
        return model;
    }
}
