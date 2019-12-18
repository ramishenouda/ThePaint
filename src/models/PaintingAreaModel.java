package models;

import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;


public class PaintingAreaModel extends JComponent
{
    private Image image;
    private Graphics2D G2D;
    
    private int currentX, oldX;
    private int currentY, oldY;

    public PaintingAreaModel() 
    {
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
        /*addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent event)
            {
                oldX = event.getX();
                oldY = event.getY();
            }
        });
        
        addMouseMotionListener(new MouseMotionAdapter()
        {
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
        });*/
    }
    
    public void paint(Graphics g)
    {
        if(image == null)
        {
            image = createImage(getSize().width, getSize().height);
            G2D = (Graphics2D)image.getGraphics();
            G2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        }
        
        g.drawImage(image, 0, 0, null);
    }
    
    public void clear()
    {
        G2D.setPaint(Color.white);
        G2D.fillRect(0, 0, getSize().width, getSize().height);
        G2D.setPaint(Color.black);
        repaint();
    }
}