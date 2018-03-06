package kz.kaznitu.controllers;

import kz.kaznitu.models.Kafedra;
import kz.kaznitu.models.Ticher;
import kz.kaznitu.repasitories.KafedraRepasitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/kafedra")
public class KafedraController {
    @Autowired
    private KafedraRepasitory kafedraRepasitory ;
    private long a;

    @RequestMapping("/add")
    public String showForm(Model model){
        model.addAttribute("kafedra",new Kafedra());
        return "kafedra_add_form";
    }

    @RequestMapping("/addd")
    public String showFormm(Model model){
        model.addAttribute("kafedraa",new Kafedra());
        return "kafedra_update";
    }
    @PostMapping("/add")
    public String addKafedra (@ModelAttribute Kafedra kafedra){
        kafedraRepasitory.save(kafedra) ;

        return "redirect:/kafedra/all" ;
    }


    @GetMapping("/all2")
    public @ResponseBody Iterable<Kafedra> allKafedras(){
        return kafedraRepasitory.findAll() ;
    }

    @GetMapping("/all")
    public String allKafedras2(Model model){
        List<Kafedra> kafedras = (List<Kafedra>) kafedraRepasitory.findAll();
        model.addAttribute("kafedras", kafedras) ;
        return "kafedras" ;
    }

    @PostMapping("/adds")
    public String addsKafedra(@ModelAttribute Kafedra kafedra){
        Kafedra kafedra1= new Kafedra();
        kafedra1.setId(a);
        kafedra1.setKafedraName(kafedra.getKafedraName());
        kafedra1.setZavKafedra(kafedra.getZavKafedra());
        kafedraRepasitory.save(kafedra1) ;

        return "redirect:/kafedra/all" ;
    }

    @RequestMapping(value = "/kafedra_update",method = RequestMethod.GET)
    public ModelAndView updateKafedras(Model model,@RequestParam("id") long id){
        a=id;
        Optional<Kafedra> kafedra = (Optional <Kafedra> ) kafedraRepasitory.findById(id);
        model.addAttribute("kafedraa",kafedra);
        return new ModelAndView("kafedra_update");
    }
    @RequestMapping(value = "/deleteContact",method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam("id") long idd){
        kafedraRepasitory.deleteById(idd);
        return new ModelAndView("redirect:/kafedra/all");
    }
}
