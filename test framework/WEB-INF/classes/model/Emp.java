package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import annotation.*;
import etu1868.framework.ModelView;

public class Emp {

    int id;
    String nom;

    public Emp(int id,String nom){this.setId(id);this.setNom(nom);}
    
    public int getId()
    {
        return this.id;
    }
    public void setId(int id)
    {
        this.id = id;
    }

    public String getNom()
    {
        return this.nom;
    }
    public void setNom(String nom)
    {
        this.nom = nom;
    }

    @Url("Emp-test")
    public static ModelView test(){
        ModelView view = new ModelView("test.jsp");

        return view;
    }

    @Url("Emp-findAll")
    public static ModelView findAll() {
        HashMap <String, Object> data = new HashMap<>();
        Emp Jean1 = new Emp(1,"Jean1");
        Emp Jean2 = new Emp(2,"Jean2");
        Emp Jean3 = new Emp(3,"Jean3");
        List<Emp> list = new ArrayList<>();
        list.add(Jean1);
        list.add(Jean2);
        list.add(Jean3);
        data.put("list", list);
        ModelView mv = new ModelView("list.jsp",data);
        return mv;
    }

    @Url("Emp-getName")
    public static ModelView getName(){
        ModelView view = new ModelView("Name.jsp");

        return view;
    }
}
