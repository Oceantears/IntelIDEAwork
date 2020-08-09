package com.controllers;

import com.bean.Gongsijidi;
import com.bean.Hw_Equipment;
import com.mapper.HwEquipmentMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class TiandiController {
    @Resource
    private HwEquipmentMapper hwEquipmentMapper;

    @RequestMapping(value = "/tiandi")
    public ModelAndView list(Model model) {
        List<Gongsijidi> gongsijidis = hwEquipmentMapper.selectGongsijidi();
        System.out.println(gongsijidis.toString());
        model.addAttribute("gongsijidis", gongsijidis);

        return new ModelAndView("tiandi", "tiandi", model);
    }
}
