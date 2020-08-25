package com.bcaf.lgd.testing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ControllerItem {
    private ServiceItems si;

    public ControllerItem() {this.si = new ServiceItems();}

    @GetMapping("/item")
    String index(Model model) {
        List<items> selectItems = si.doSelectItems();
        model.addAttribute("selectItems", selectItems);
        return "index";
    }
}

