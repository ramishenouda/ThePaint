package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.MenuBarModel;

public class MenuBarController
{
    private final MenuBarModel menuBarView;
    
    public MenuBarController(MenuBarModel menuBarView)
    {
        this.menuBarView = menuBarView;
        addActionListeners();
    }

    private void addActionListeners()
    {
        menuBarView.getNewProjectItem().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event) 
            {
                menuBarView.newProjectTrigger();
            }
        });
    }
    
    public MenuBarModel getModel()
    {
        return menuBarView;
    }
}
