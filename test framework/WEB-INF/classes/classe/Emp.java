package classe;

import annotation.*;
import etu1868.framework.ModelView;

public class Emp {
    @Url("Emp-findAll")
    public void findAll(){
        System.out.println("ceci est une fonction pour find All");
    }

    @Url("Emp-test")
    public static ModelView test(){
        ModelView view = new ModelView("test.jsp");

        return view;
    }

    @Url("Emp-getName")
    public static ModelView getName(){
        ModelView view = new ModelView("Name.jsp");

        return view;
    }
}
