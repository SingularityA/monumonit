package com.monumonit.controllers;

import com.monumonit.controllers.common.AbstractCrudController;
import com.monumonit.dto.MonumentDto;
import com.monumonit.entities.Complex;
import com.monumonit.entities.Monument;
import com.monumonit.entities.MonumentType;
import com.monumonit.services.ComplexService;
import com.monumonit.services.MonumentService;
import com.monumonit.services.MonumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller("com.monumonit.controllers")
@RequestMapping("monument/")
public class MonumentController extends AbstractCrudController {

    @Autowired
    MonumentService monumentService;

    @Autowired
    MonumentTypeService monumentTypeService;

    @Autowired
    ComplexService complexService;

    @GetMapping("list/")
    public String list(Model model) {
        List<Monument> monuments = monumentService.findAll();
        model.addAttribute("monuments", monuments);
        return "monuments/list";
    }

    @GetMapping("view/{id}/")
    public String view(Model model, @PathVariable Long id) {
        final Monument monument = monumentService.find(id);
        model.addAttribute("monument", monument);
        return "monuments/view";
    }

    @GetMapping("create/")
    public String createGet(Model model) {
        setCreateBehaviour(model);
        injectLists(model);

        model.addAttribute("monumentDto", new MonumentDto());
        return "monuments/form";
    }

    @PostMapping("create/")
    public String createPost(Model model,
                             MonumentDto monumentDto,
                             BindingResult result) {

        final Monument monument = mapToMonument(monumentDto);
        monumentService.save(monument);
        return String.format("redirect:/monument/view/%s/", monument.getId());
    }

    @GetMapping("update/{id}/")
    public String updateGet(Model model,
                             @PathVariable Long id) {

        setUpdateBehaviour(model);
        injectLists(model);

        final Monument monument = monumentService.find(id);
        model.addAttribute("monumentDto", mapToMonumentDto(monument));
        return "monuments/form";
    }

    @PostMapping("update/{id}/")
    public String updatePost(Model model,
                               @PathVariable Long id,
                               MonumentDto monumentDto,
                               BindingResult result) {

        final Monument monument = mapToMonument(monumentDto);
        monumentService.save(monument);
        return "redirect:/monument/view/{id}/";
    }

    @GetMapping("delete/{id}/")
    public String deleteGet(Model model,
                            @PathVariable Long id) {

        final MonumentDto monumentDto = new MonumentDto();
        monumentDto.setId(id);
        model.addAttribute("monumentDto", monumentDto);
        return "monuments/delete";
    }

    @PostMapping("delete/{id}/")
    public String deletePost(Model model,
                             @PathVariable Long id,
                             MonumentDto monumentDto,
                             BindingResult result) {

        final Monument monument = monumentService.find(id);
        monumentService.delete(monument);

        System.out.println("POST DELETION");
        return "redirect:/monument/list/";
    }

    private void injectLists(Model model) {
        final List<MonumentType> typeList = monumentTypeService.findAll();
        final List<Complex> complexList = complexService.findAll();
        final List<Monument> monumentList = monumentService.findAll();

        model.addAttribute("typeList", typeList);
        model.addAttribute("complexList", complexList);
        model.addAttribute("monumentList", monumentList);
    }

    private MonumentDto mapToMonumentDto(Monument monument) {
        MonumentDto monumentDto = new MonumentDto();
        monumentDto.map(monument);
        return monumentDto;
    }

    private Monument mapToMonument(MonumentDto monumentDto) {
        final Monument monument =
                monumentDto.getId() != null ? monumentService.find(monumentDto.getId()) : new Monument();
        monumentDto.mapInto(monument);
        monument.setMonumentType(monumentTypeService.find(monumentDto.getTypeId()));
        monument.setComplex(complexService.find(monumentDto.getComplexId()));
        monument.setParent(monumentDto.getParentId() != null ? monumentService.find(monumentDto.getParentId()) : null);
        return monument;
    }
}
