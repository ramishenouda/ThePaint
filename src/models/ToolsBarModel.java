package models;

import javax.swing.JToolBar;
import javax.swing.JButton;

import javax.swing.JPanel;

import models.tools.Tool;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

public class ToolsBarModel extends JPanel 
{
    private JPanel toolsPanel = new JPanel();
    private JToolBar toolBar = new JToolBar("Tools");
    
    public ToolsBarModel(Tool... tools) 
    {
        super(new BorderLayout());
        setToolBar(tools);
        
        toolBar.setLayout(new GridLayout(7, 1));
        
        toolsPanel.add(toolBar);
        add(toolsPanel, BorderLayout.WEST);
    }
    
    private void setToolBar(Tool... tools)
    {
        for(Tool tool : tools)
        {
            toolBar.add(tool);
        }
    }
}