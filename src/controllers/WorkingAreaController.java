package controllers;

import models.WorkingAreaModel;

public class WorkingAreaController
{
    private final WorkingAreaModel model;
    
    public WorkingAreaController(WorkingAreaModel model) 
    {
        this.model = model;
    }
    
    public WorkingAreaModel getModel()
    {
        return model;
    }
}