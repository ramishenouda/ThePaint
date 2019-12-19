package models;

import javax.swing.*;
import java.awt.*;

public class ThePaintModel extends JFrame
{
    public ThePaintModel()
    {
        setTitle("ThePaint");
        super.setMinimumSize(new Dimension(800, 600));
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.decode("#2a2a2a"));
    }
    
    public void Show()
    {
        setVisible(true);
    }
}