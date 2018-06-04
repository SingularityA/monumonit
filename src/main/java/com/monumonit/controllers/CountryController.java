package com.monumonit.controllers;

import com.monumonit.entities.Country;
import com.monumonit.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("country/")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("view/{id}/")
    public String view(Model model, @PathVariable Long id) {
        final Country country = countryService.find(id);
        model.addAttribute("country", country);
        return "countries/view";
    }
}
