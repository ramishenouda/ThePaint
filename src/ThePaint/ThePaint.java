package ThePaint;

import java.awt.BorderLayout;
import controllers.MenuBarController;
import controllers.NewProjectController;
import controllers.PaintingAreaController;

import models.MenuBarModel;
import models.NewProjectModel;
import models.PaintingAreaModel;
import models.ThePaintModel;

public class ThePaint 
{
    public static NewProjectController newProjectController;
    public static MenuBarController menuBarController;
    public static PaintingAreaController paintingAreaController;
    
    public static void main(String[] args) 
    {
        ThePaintModel view = new ThePaintModel();
        
        NewProjectModel newProjectModel = new NewProjectModel(); 
        newProjectController = new NewProjectController(newProjectModel);
        
        MenuBarModel menuBarModel = new MenuBarModel(newProjectController);
        menuBarController = new MenuBarController(menuBarModel);
        
        PaintingAreaModel paintingAreaModel = new PaintingAreaModel();
        paintingAreaController = new PaintingAreaController(paintingAreaModel);
        
        view.add(paintingAreaController.getModel(), BorderLayout.CENTER);
        view.add(menuBarController.getModel(), BorderLayout.NORTH);
        view.Show();
    }
}