package controllers;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import models.NewProjectModel;

public class NewProjectController 
{
    private final NewProjectModel model;
    
    public NewProjectController(NewProjectModel model)
    {
        this.model = model;
        addActionListeners();
    }

    private void addActionListeners()
    {
        model.getCreateButton().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event) 
            {
                System.out.println("Creating New Project");
            }
        });
        
        model.getUseImageButton().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                if(model.getFileChooserModel())
                {
                    try {
                        File file = model.getSelectedFile();
                        BufferedImage image = ImageIO.read(file);   
                        ThePaint.ThePaint.workingAreaController.getModel().setImage(image);        
                    } catch(IOException error) {
                        System.out.println(error);
                    }
                }
            }
        });
    }
    
    public void showModel()
    {
        model.showProjectModel();
    }
    
    public NewProjectModel returnModel()
    {
        return model;
    }
}