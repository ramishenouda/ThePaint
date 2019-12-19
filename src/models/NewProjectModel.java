package models;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.io.File;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewProjectModel extends JDialog
{
    private final JButton createButton;
    private final JButton useImageButton;
    
    private FileDialog dialog;
    private File file = null;
    
    public NewProjectModel()
    {   
        setTitle("Creating new Project");
        setSize(400, 155);
        setVisible(false);        
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setModal(true);
        setModalityType (ModalityType.APPLICATION_MODAL);
        getContentPane().setBackground(Color.white);
        
        JPanel projectPropertiesPanel = new JPanel();
        JPanel projectOptionsPanel = new JPanel();
        
        projectOptionsPanel.setLayout(new BorderLayout(1, 1));
        projectPropertiesPanel.setLayout(new GridLayout(3, 2));
        
        projectPropertiesPanel.setSize(200, 400);
        
        JLabel nameLabel = new JLabel("Name:");
        JLabel widthLabel = new JLabel("Width(px):");
        JLabel heightLabel = new JLabel("Height(px):");
        
        JTextField nameTextField = new JTextField("New Paint");
        JTextField widthTextField = new JTextField("1280");
        JTextField heightTextField = new JTextField("720");
        
        projectPropertiesPanel.add(nameLabel);
        projectPropertiesPanel.add(nameTextField);
        
        projectPropertiesPanel.add(widthLabel);
        projectPropertiesPanel.add(widthTextField);

        projectPropertiesPanel.add(heightLabel);
        projectPropertiesPanel.add(heightTextField);

        
        createButton = new JButton("Create");
        useImageButton = new JButton("Use Image");
        
        projectOptionsPanel.add(useImageButton, BorderLayout.NORTH);
        projectOptionsPanel.add(createButton, BorderLayout.SOUTH);
         
        add(projectPropertiesPanel, BorderLayout.NORTH);
        add(projectOptionsPanel, BorderLayout.CENTER);
   }
    
    public JButton getCreateButton()
    {
        return this.createButton;
    }
    
    public void showProjectModel()
    {
        setVisible(true);
    }
    
    public JButton getUseImageButton()
    {
        return this.useImageButton;
    }
    
    public boolean getFileChooserModel() 
    {
        //to avoid bugs when canceling FileDialog
        file = null;
        //creating FileDialog
        dialog = new FileDialog((Frame)null, "Select File to Open", FileDialog.LOAD);
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        
        if(!dialog.getFile().equals("null"))
        {
            file = new File(Paths.get(dialog.getDirectory(), dialog.getFile()).toString());
            dialog = null;
            return true;
        }
        
        dialog = null;
        return false;
    }
    
    public File getSelectedFile()
    {
        
        return file;
    }
}
