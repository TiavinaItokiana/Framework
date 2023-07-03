package etu1868.framework;

import java.util.HashMap;

public class ModelView {
    HashMap <String, Object> datas;
    String view;
    public ModelView(String view) {
        setView(view);
    }
    public ModelView (String view, HashMap <String, Object> datas)
    {
        setView(view);
        setDatas(datas);
    }
    
    public HashMap<String, Object> getDatas() {
        return datas;
    }
    public void setDatas(HashMap<String, Object> datas) {
        this.datas = datas;
    }
    public String getView() {
        return view;
    }
    public void setView(String view) {
        this.view = view;
    }

    public void addItem (String key, Object value) throws Exception
    {
        if(this.getDatas()!=null)
        {
            this.getDatas().put(key, value);
        }
        else
        {
            throw new Exception(this.getClass().getSimpleName()+" : datas (HashMap<String key, Object value>) is Null");
        }
    }
}
