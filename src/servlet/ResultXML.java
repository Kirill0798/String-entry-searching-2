package servlet;

import beans.managed.SearchBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/result.xml")
public class ResultXML extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        executeRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        executeRequest(request, response);
    }
    private void executeRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("xml");
        HttpSession session = request.getSession();
        SearchBean task = (SearchBean) session.getAttribute("searchBean");

        if (task == null){
            response.setStatus(HttpServletResponse.SC_FOUND);
            response.setHeader("Location", "/index.xhtml");
            return;
        }

        try(OutputStream outputStream = response.getOutputStream()) {
            JAXBContext context = JAXBContext.newInstance(SearchBean.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(task, outputStream);
        }catch (JAXBException | IOException exc){
            exc.printStackTrace();
        }
    }
}
