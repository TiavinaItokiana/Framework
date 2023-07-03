package etu1868.framework;

import java.util.HashMap;

public class ModelView {
    String view;
    public ModelView(String view) {
        setView(view);
    }
    
    public String getView() {
        return view;
    }
    public void setView(String view) {
        this.view = view;
    }
}
