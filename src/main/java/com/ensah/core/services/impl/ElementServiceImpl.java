package com.ensah.core.services.impl;

import com.ensah.core.bo.ElementPedagogique;
import com.ensah.core.reposetory.IElementRepository;
import com.ensah.core.services.IElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ElementServiceImpl  implements IElementService {
    @Autowired
    private IElementRepository elementPedagogiqueRepository;

    @Override
    public List<ElementPedagogique> getAllElements() {
        return elementPedagogiqueRepository.findAll();
    }

    @Override
    public ElementPedagogique getElementById(Long id) {
        return elementPedagogiqueRepository.findById(id).orElse(null);
    }

    @Override
    public void saveElement(ElementPedagogique element) {
        elementPedagogiqueRepository.save(element);
    }

    @Override
    public void updateElement(ElementPedagogique element) {
        elementPedagogiqueRepository.save(element);
    }

    @Override
    public void deleteElement(Long id) {
        elementPedagogiqueRepository.deleteById(id);
    }
}
