package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import utilitaire.*;
/**
 * FrontServlet
 */
public class FrontServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request, response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        String url = String.valueOf(request.getRequestURL());
        out.println("URL: "+url);
        out.println("--------------------------------");
        out.println("Parameter URL : "+Utilitaire.getURLParameter(url));
    }
}