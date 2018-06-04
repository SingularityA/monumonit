package com.monumonit.controllers.common;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public abstract class AbstractCrudController {

    protected static void setCreateBehaviour(Model model) {
        model.addAttribute("newModel", true);
    }

    protected static void setUpdateBehaviour(Model model) {
        model.addAttribute("newModel", false);
    }
}
