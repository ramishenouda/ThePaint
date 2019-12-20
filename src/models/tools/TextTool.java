package models.tools;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextTool extends Tool 
{
    public TextTool(Image image, String text, String toolTip)
    {
        super(image, text, toolTip);
        super.addActionListener(new TextActionListener());
    }

    private class TextActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event) 
        {
            System.out.println("hey hey TextTool is here");
        }
    }
}