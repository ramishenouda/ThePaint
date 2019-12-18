package thepaint.views;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class MainView extends JFrame
{
    public MainView()
    {
        setTitle("ThePaint");
        setSize(800, 600);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
    }
    
    public void Show()
    {
        setVisible(true);
    }
}
