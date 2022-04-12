package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.beans.Patients;
import com.dao.PatientsDao;

@Controller
public class PatientsController {
	@Autowired  
    PatientsDao dao;//will inject dao from xml file  
      
    /*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */  
    @RequestMapping("/patientform")  
    public String showform(Model m){  
    	m.addAttribute("command", new Patients());
    	return "patientform"; 
    }  
    /*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET*/  
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("pa") Patients pa){  
        dao.save(pa);  
        return "redirect:/viewpatient";//will redirect to viewemp request mapping  
    }  
    /* It provides list of employees in model object */  
    @RequestMapping("/viewpatient")  
    public String viewpatient(Model m){  
        List<Patients> list=dao.getPatients();  
        m.addAttribute("list",list);
        return "viewpatient";  
    }  
    /* It displays object data into form for the given id.  
     * The @PathVariable puts URL data into variable.*/  
    @RequestMapping(value="/editpatient/{id}")  
    public String edit(@PathVariable int id, Model m){  
        Patients pa=dao.getPatientsById(id);  
        m.addAttribute("command",pa);
        return "patienteditform";  
    }  
    /* It updates model object. */  
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("pa") Patients pa){  
        dao.update(pa);  
        return "redirect:/viewpatient";  
    }  
    /* It deletes record for the given id in URL and redirects to /viewemp */  
    @RequestMapping(value="/deletepatient/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        dao.delete(id);  
        return "redirect:/viewpatient";  
    }   
    
}
