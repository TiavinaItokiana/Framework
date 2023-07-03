package model;

import annotation.*;
public class Emp 
{
    @Url(value="Emp-test")
    public void test()
    {
        System.out.println("Emp test function");
    }

    @Url(value = "Emp-go")
    public void go()
    {
        System.out.println("Emp test function go");
    }
}
