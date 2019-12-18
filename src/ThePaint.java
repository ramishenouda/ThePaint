package thepaint;

import java.awt.BorderLayout;
import models.PaintingAreaModel;
import thepaint.views.MainView;

public class ThePaint 
{
    public static void main(String[] args) 
    {
        MainView view = new MainView();
        view.add(new PaintingAreaModel(), BorderLayout.CENTER);
        view.Show();
    }
}
