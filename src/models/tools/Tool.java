//Base class for all tools
package models.tools;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public abstract class Tool extends JButton
{   
    public Tool() {}
    
    public Tool(Image image, String text, String toolTip)
    {
        super.setIcon(new ImageIcon(image));
        super.setText(text);
        super.setToolTipText(toolTip);
    }
}