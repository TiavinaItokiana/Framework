import annotation.Url;
import etu1868.framework.ModelView;

package model;
public class Test 
{
    @Url(value="Test-room")
    public ModelView room() 
    {
        System.out.println("SHAMBLESS");
        ModelView lolo = new ModelView("test.jsp");
        return lolo;
    }
}
