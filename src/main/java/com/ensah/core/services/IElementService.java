package com.ensah.core.services;

import com.ensah.core.bo.ElementPedagogique;

import java.util.List;

public interface IElementService {
    public List<ElementPedagogique> getAllElements();
    public ElementPedagogique getElementById(Long id) ;
    public void saveElement(ElementPedagogique element) ;
    public void updateElement(ElementPedagogique element);
    public void deleteElement(Long id);









    }
