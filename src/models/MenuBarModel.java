package models;

import controllers.NewProjectController;
import java.awt.FileDialog;
import java.awt.Frame;
import javax.swing.*;

public class MenuBarModel extends JMenuBar
{
    private JMenu file, edit, help;
    //file items
    private JMenuItem newProject, openImage, saveImage;
    //newProject JFrame
    NewProjectController newProjectController;
    
    public MenuBarModel(NewProjectController newProjectController)
    {
        this.newProjectController = newProjectController;
        createComponents();
    }
    
    private void createComponents()
    {
        file = new JMenu("File");    
        edit = new JMenu("Edit");    
        help = new JMenu("Help");
        //Creating the file items
        newProject = new JMenuItem("New Project");
        //Adding the file items
        file.add(newProject);
        //Adding menus to the bar
        add(file);
        add(edit);
        add(help);
    }
    
    public JMenuItem getNewProjectItem()
    {
        return this.newProject;
    }
    
    public JMenuItem getOpenImageItem()
    {
        return this.openImage;
    }
    
    public JMenuItem getSaveImageItem()
    {
        return this.saveImage;
    }
    
    public void newProjectTrigger()
    {
        newProjectController.showModel();
    }
    
    public void chooseFileTrigger()
    {
        FileDialog dialog = new FileDialog((Frame)null, "Select File to Open");
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
    }
}
