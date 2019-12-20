package models;

import ThePaint.ThePaint;
import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import javax.imageio.ImageIO;


public class WorkingAreaModel extends JComponent
{
    private BufferedImage image = null;
    private Graphics2D G2D = null;
    
    private int currentX, oldX;
    private int currentY, oldY;
    //Center Point, Center Point
    private int imageX;
    private int imageY;
    //Center Points
    Dimension thePaintDimension;
    //Drawing offsets
    int[] axis = new int[2];
    
    public WorkingAreaModel() 
    {
        setDoubleBuffered(false);
        setVisible(true);
        
        thePaintDimension = ThePaint.getThePaintModel().getSize();
        thePaintDimension.setSize(thePaintDimension.getWidth() / 2, thePaintDimension.getHeight() / 2);
        
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
                    G2D.drawLine(oldX - axis[0], oldY - axis[1], currentX - axis[0], currentY - axis[1]);
                    repaint();

                    oldX = currentX;
                    oldY = currentY;
                }
            }
        };
        
        addMouseListener(listener);
        addMouseMotionListener(listener);
    }
    
    private void homeScreen()
    {
        String filePath = Paths.get(ThePaint.getPath(), "homeScreenWallpaper.jpg").toString();
        File file = new File(filePath);
        
        try{
            image = ImageIO.read(file);
            setImage(image);
        } catch(IOException error) {
            System.out.println("error while getting HomeScreenWallpaper" + error);
        }
        
        repaint();
    }
    
    private void setCenterAxis()
    {
        System.out.println(imageX);
        System.out.println(imageY);
        
        System.out.println(thePaintDimension.width);
        System.out.println(thePaintDimension.height);
        
        int x = Math.abs(thePaintDimension.width - imageX);
        int y = Math.abs(thePaintDimension.height - imageY);
        
        axis[0] = x - 20;
        axis[1] = y - 40;
    }
        
    protected void paintComponent(Graphics g)
    {
        if(image == null)
        {
            homeScreen();
        }
        
        g.drawImage(image, axis[0], axis[1], null);
    }
        
    public void clear()
    {
        G2D.setPaint(Color.WHITE);
        G2D.fillRect(0, 0, thePaintDimension.width, thePaintDimension.height);
        G2D.setPaint(Color.black);
        repaint();
    }
    
    public Image getImage()
    {
        return this.image;
    }
    
    public void setImage(BufferedImage image)
    {
        this.image = image;
        imageX = image.getWidth() / 2;
        imageY = image.getHeight() / 2;
        
        thePaintDimension = ThePaint.getThePaintModel().getSize();
        thePaintDimension.setSize(thePaintDimension.getWidth() / 2, thePaintDimension.getHeight() / 2);
        
        setCenterAxis();
        
        G2D = (Graphics2D)image.getGraphics();
        repaint();
    }
    
    public void CreateNewPorject(int width, int height)
    {
        G2D = (Graphics2D)image.getGraphics();
        G2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        clear();
    }
}