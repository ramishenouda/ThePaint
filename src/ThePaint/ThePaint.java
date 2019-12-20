package ThePaint;

import java.awt.BorderLayout;
import controllers.MenuBarController;
import controllers.NewProjectController;
import controllers.ToolsController;
import controllers.WorkingAreaController;
import java.io.IOException;

import models.MenuBarModel;
import models.NewProjectModel;
import models.WorkingAreaModel;
import models.ThePaintModel;

public class ThePaint 
{
    public static NewProjectController newProjectController;
    public static MenuBarController menuBarController;
    public static WorkingAreaController workingAreaController;
    public static ToolsController toolsController;
    
    private static ThePaintModel model = new ThePaintModel();

    
    public static void main(String[] args) 
    {
        
        NewProjectModel newProjectModel = new NewProjectModel(); 
        newProjectController = new NewProjectController(newProjectModel);
        
        MenuBarModel menuBarModel = new MenuBarModel(newProjectController);
        menuBarController = new MenuBarController(menuBarModel);
        
        WorkingAreaModel paintingAreaModel = new WorkingAreaModel();
        workingAreaController = new WorkingAreaController(paintingAreaModel);
        
        try {
            toolsController = new ToolsController();
        } catch (IOException ex) {
            System.out.println("Error while Setting toolsController due to error in IOError\n" + ex.getMessage());
        }
        
        model.add(workingAreaController.getModel(), BorderLayout.CENTER);
        model.add(menuBarController.getModel(), BorderLayout.NORTH);
        model.add(toolsController.getModel(), BorderLayout.WEST);
        
        model.Show();
    }
    
    public static String getPath()
    {
        return System.getProperty("user.dir");
    }
    
    public static ThePaintModel getThePaintModel()
    {
        return model;
    }
}