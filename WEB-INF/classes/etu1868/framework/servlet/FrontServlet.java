package etu1868.framework.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import etu1868.framework.Mapping;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import utilitaire.*;
/**
 * FrontServlet
 */
public class FrontServlet extends HttpServlet {

    HashMap<String, Mapping> MappingUrls;

    public void init() throws ServletException {
        ServletContext context = getServletContext();
        String contextPath = context.getRealPath("/");
        System.out.println("context Path : "+contextPath);
        try {
            MappingUrls = utilitaire.Package.scanPackages(contextPath);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

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
        out.println("Parameter URL : "+Utilitaire.getURLParameter(String.valueOf(request.getRequestURL())));
        for (Map.Entry<String,Mapping> entry : MappingUrls.entrySet()){
            String cle = entry.getKey();
            Mapping value = entry.getValue();
            out.println("cle : "+cle+ " , Class Name : "+ value.getClassName()+" ----- Method Name : "+value.getMethod());
        }
    }
}