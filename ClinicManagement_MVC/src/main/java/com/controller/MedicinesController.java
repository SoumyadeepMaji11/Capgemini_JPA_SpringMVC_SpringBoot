package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.beans.Medicines;
import com.dao.MedicinesDao;

@Controller
public class MedicinesController {
	@Autowired  
    MedicinesDao dao1;//will inject dao from xml file  
      
    /*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */  
    @RequestMapping("/medicineform")  
    public String showform(Model m){  
    	m.addAttribute("command", new Medicines());
    	return "medicineform"; 
    }  
    /*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET*/  
    @RequestMapping(value="/msave",method = RequestMethod.POST)  
    public String msave(@ModelAttribute("me") Medicines me){  
        dao1.msave(me);  
        return "redirect:/mviewmedicine";//will redirect to viewemp request mapping  
    }  
    /* It provides list of employees in model object */  
    @RequestMapping("/mviewmedicine")  
    public String mviewmedicine(Model m){  
        List<Medicines> list=dao1.mgetMedicines();  
        m.addAttribute("list",list);
        return "viewmedicine";  
    }  
    /* It displays object data into form for the given id.  
     * The @PathVariable puts URL data into variable.*/  
    @RequestMapping(value="/meditmedicine/{id}")  
    public String edit(@PathVariable int id, Model m){  
        Medicines me=dao1.mgetMedicinesById(id);  
        m.addAttribute("command",me);
        return "medicineeditform";  
    }  
    /* It updates model object. */  
    @RequestMapping(value="/meditsave",method = RequestMethod.POST)  
    public String meditsave(@ModelAttribute("me") Medicines me){  
        dao1.mupdate(me);  
        return "redirect:/mviewmedicine";  
    }  
    /* It deletes record for the given id in URL and redirects to /viewemp */  
    @RequestMapping(value="/mdeletemedicine/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        dao1.mdelete(id);  
        return "redirect:/mviewmedicine";  
    }   
    
}
