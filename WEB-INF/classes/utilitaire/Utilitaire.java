package utilitaire;

public class Utilitaire 
{
    public static String getURLParameter (String url)
    {
        String param ="";
        String dom = url.substring(url.indexOf("//")+2);
        dom = dom.substring(dom.indexOf("/")+1);
        String temp = dom.substring(dom.indexOf("/")+1);
        if(temp.contains("?"))
        {
            temp = temp.replace("?", "");
            param = temp.split(temp)[0];
        }
        else
        {
            param = temp;
        }
        System.out.println(temp);
        return param;
    }
}
