package etu1868.framework.servlet;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.MultipartConfig;
import helper_classes.*;
import etu1868.framework.*;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.*;

@MultipartConfig
public class FrontServlet extends HttpServlet {
    HashMap<String, Mapping> MappingUrls; 
    HashMap<String, Object> sigleton; 

    @Override
    public void init() throws ServletException{
        this.MappingUrls = new HashMap<String, Mapping>();
        this.sigleton = new HashMap<String, Object>();
        ServletContext context = getServletContext();
        String absolutePath = context.getRealPath("/WEB-INF/classes");
        File workspace = new File(absolutePath);
        String[] test=workspace.list();
        for (String packageName : test) {
            String packagePath = absolutePath+'\\'+packageName;
            PackageClasse.initHashmap(packagePath,packageName, this.MappingUrls, sigleton);
        }
    }
    

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        if (request.getMethod().equals("GET")) {
            out.println("Method GET");
        } else if (request.getMethod().equals("POST")) {
            out.println("Method POST");
        } else {
            // Si la méthode HTTP n'est ni GET ni POST, on renvoie une erreur "Méthode non autorisée"
            out.println("Methode non reconnu");
        }
        processRequest(request, response);
    }
    protected void processRequest (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        String url = String.valueOf(req.getRequestURL());
        String parameter_url = Util.getParamURL(url);
        String method = req.getMethod();

        out.println("URL : "+url);
        out.println("MAPPING :"+this.MappingUrls.toString());
        out.println("Parameter url : "+parameter_url);
        Mapping mapping = this.MappingUrls.get(parameter_url);
        if (mapping != null) {
            out.println("Value of "+parameter_url+": ");
            out.println("\t ClassName : "+mapping.getClassName());
            out.println("\t Method : "+mapping.getMethod());

            try {
                Class<?> cls = Class.forName(mapping.getClassName());
                Object obj = this.iniObject(cls, mapping, req);
                Object value = Util.invokeMethod(req, mapping, obj);
                
                Modelview view = (Modelview) value;
                this.setDatas(req, view);
                req.getRequestDispatcher(view.getView()).forward(req, res);
                
                /*if (value instanceof Modelview) {
                    Modelview myview = (Modelview) value;
                    req.getRequestDispatcher(myview.getView()).forward(req,res);
                }*/
            } catch (Exception e) {
                out.println(e);
            }
        } else {
            out.println("The url `"+parameter_url+"` is not defined");
        }
    }

    public void setDatas(HttpServletRequest req, Modelview view) {
        HashMap<String, Object> datas = view.getDatas();
        for (String key : datas.keySet()) {
            req.setAttribute(key, datas.get(key));
        }
    }

    public Object iniObject(Class<?> cls, Mapping map, HttpServletRequest req) throws ServletException, Exception, NoSuchMethodException, IOException{
        Object toReturn = null;
        String key = cls.getName();
        if (this.sigleton.containsKey(key)) {
            System.out.println("the object is a sigleton");
            if (this.sigleton.get(key) == null) {
                toReturn = cls.getDeclaredConstructor().newInstance();
                Util.setObjectField(toReturn, req);
                this.sigleton.put(key, toReturn);
                //System.out.println("the object is a sigleton(init)");
            } else {
                Util.resetObject(this.sigleton.get(cls.getName()));
                toReturn = this.sigleton.get(key);
                Util.setObjectField(toReturn, req);
            }
        } else {
            toReturn = Util.initObjectForm(req, map);
        }
        return toReturn;
    }

    
}
