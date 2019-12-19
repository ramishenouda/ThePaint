package models;

import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PaintingAreaModel extends JComponent
{
    private Image image;
    private Graphics2D G2D;
    
    private int currentX, oldX;
    private int currentY, oldY;
    
    Dimension screenSize;
    
    public PaintingAreaModel() 
    {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        setDoubleBuffered(false);
        setVisible(true);
        
        MouseAdapter listener = new MouseAdapter()        
        {
            public void mousePressed(MouseEvent event)
            {
                oldX = event.getX();
                oldY = event.getY();
            }
            
            public void mouseDragged(MouseEvent event)
            {
                currentX = event.getX();
                currentY = event.getY();
                if(G2D != null)
                {
                    G2D.drawLine(oldX, oldY, currentX, currentY);
                    repaint();

                    oldX = currentX;
                    oldY = currentY;
                }
            }
        };
        
        addMouseListener(listener);
        addMouseMotionListener(listener);
    }
    
    protected void paintComponent(Graphics g)
    {
        if(image == null)
        {
            image = createImage(screenSize.width, screenSize.height);
            
            G2D = (Graphics2D)image.getGraphics();
            G2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            clear();
        }
        
        g.drawImage(image, 0, 0, null);
    }
    
    public void clear()
    {
        G2D.setPaint(Color.WHITE);
        G2D.fillRect(0, 0, screenSize.width, screenSize.height);
        G2D.setPaint(Color.black);
        repaint();
    }
    
    public Image getImage()
    {
        return this.image;
    }
    
    public void setImage(Image image)
    {
        this.image = image;
        setG2DImage();
        repaint();
    }
    
    private void setG2DImage()
    {
        G2D = (Graphics2D)image.getGraphics();
    }
}