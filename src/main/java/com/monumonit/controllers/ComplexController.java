package com.monumonit.controllers;

import com.monumonit.entities.Complex;
import com.monumonit.services.ComplexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("complex/")
public class ComplexController {

    @Autowired
    private ComplexService complexService;

    @GetMapping("view/{id}/")
    public String view(Model model, @PathVariable Long id) {
        final Complex complex = complexService.find(id);
        model.addAttribute("complex", complex);
        return "complexes/view";
    }
}
