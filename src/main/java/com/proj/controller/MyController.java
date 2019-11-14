package com.proj.controller;

import com.proj.dao.DeveloperDao;
import com.proj.model.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class MyController {

    @Autowired()
    private DeveloperDao devDao;

    @RequestMapping(value = "/data")
    public ModelAndView listDeveloper(ModelAndView model) throws IOException {

        List<Developer> listDev = devDao.devList();
        model.addObject("listDev", listDev);
        model.setViewName("dat.jsp");

        return model;
    }
}
