package controllers;

import models.PaintingAreaModel;

public class PaintingAreaController
{
    private final PaintingAreaModel model;
    
    public PaintingAreaController(PaintingAreaModel model) 
    {
        this.model = model;
    }
    
    public PaintingAreaModel getModel()
    {
        return model;
    }
}