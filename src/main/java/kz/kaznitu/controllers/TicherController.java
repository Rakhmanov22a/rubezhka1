package kz.kaznitu.controllers;

import kz.kaznitu.models.Ticher;
import kz.kaznitu.repasitories.TicherRepasitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/ticher")
public class TicherController {
    @Autowired
    private TicherRepasitory ticherRepasitory ;
    private long a;

    @RequestMapping("/add")
    public String showForm(Model model){
        model.addAttribute("ticher",new Ticher());
        return "ticher_add_form";
    }

    @RequestMapping("/addd")
    public String showFormm(Model model){
        model.addAttribute("ticherr",new Ticher());
        return "ticher_update";
    }
    @PostMapping("/add")
    public String addTicher(@ModelAttribute Ticher ticher){
        ticherRepasitory.save(ticher) ;

        return "redirect:/ticher/all" ;
    }


    @GetMapping("/all2")
    public @ResponseBody Iterable<Ticher> allTichers(){
        return ticherRepasitory.findAll() ;
    }

    @GetMapping("/all")
    public String allTichers2(Model model){
        List<Ticher> tichers = (List<Ticher>) ticherRepasitory.findAll();
        model.addAttribute("tichers", tichers) ;
        return "tichers" ;
    }

    @PostMapping("/adds")
    public String addsTicher(@ModelAttribute Ticher ticher){
        Ticher ticher1 = new Ticher();
        ticher1.setId(a);
        ticher1.setFirstName(ticher.getFirstName());
        ticher1.setLastName(ticher.getLastName());
        ticher1.setKafedraId(ticher.getKafedraId());
        ticherRepasitory.save(ticher1) ;

        return "redirect:/ticher/all" ;
    }

    @RequestMapping(value = "/ticher_update",method = RequestMethod.GET)
    public ModelAndView updateTichers(Model model,@RequestParam("id") long id){
        a=id;
        Optional<Ticher> ticher = (Optional <Ticher> ) ticherRepasitory.findById(id);
        model.addAttribute("ticherr",ticher);
        return new ModelAndView("ticher_update");
    }
    @RequestMapping(value = "/deleteContact",method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam("id") long idd){
        ticherRepasitory.deleteById(idd);
        return new ModelAndView("redirect:/ticher/all");
    }
}
