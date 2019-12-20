package controllers;

import ThePaint.ThePaint;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import models.ToolsBarModel;
import models.tools.TextTool;
import models.tools.Tool;

public class ToolsController 
{
    private final ToolsBarModel model;
    
    Tool pencilTool;
    Tool textTool;
    Tool textTool2;
    Tool textTool3;
    Tool textTool4;
    Tool textTool5;
    Tool textTool6;
    
    public ToolsController() throws IOException
    {
        File file;
        Image image;
        
        file = new File(Paths.get(ThePaint.getPath(), "icons", "selecticon.png").toString());
        image = ImageIO.read(file);
        textTool = new TextTool(image, "", "text tool tip");
        
        file = new File(Paths.get(ThePaint.getPath(), "icons", "pencilicon.png").toString());
        image = ImageIO.read(file);
        pencilTool = new TextTool(image, "", "text tool tip");
        
        textTool2 = new TextTool(image, "", "text tool tip");
        textTool3 = new TextTool(image, "", "text tool tip");
        textTool4 = new TextTool(image, "", "text tool tip");
        textTool5 = new TextTool(image, "", "text tool tip");
        textTool6 = new TextTool(image, "", "text tool tip");

        model = new ToolsBarModel(textTool, pencilTool, textTool2, textTool3, textTool4, textTool5, textTool6);
    }
    
    public ToolsBarModel getModel()
    {
        return model;
    }
}