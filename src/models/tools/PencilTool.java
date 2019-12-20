package models.tools;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PencilTool extends Tool 
{
    public PencilTool(Image image, String text, String toolTip)
    {
        super(image, text, toolTip);
        super.addActionListener(new TextActionListener());
    }

    private class TextActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event) 
        {
            System.out.println("hey hey Pencil Tool is here");
        }
    }
}