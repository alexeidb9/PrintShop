package backend.Prints.service;

import backend.Log;
import backend.Prints.Print;
import backend.Prints.service.models.GetPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = {"/", ""})
public class PrintController {

    private Log log;
    private PrintService printService;

    @Autowired
    public PrintController(Log log, PrintService printService) {
        this.log = log;
        this.printService = printService;
    }


    //    @RequestMapping(value = {"/", ""});
    public ModelAndView index() {

        List<GetPrint> servicePrints = printService.getAllPrints();
        List<Print> prints = new ArrayList<>();
        servicePrints.forEach(e -> {
            Print entry = new Print();
            entry.setTitle(e.getTitle());
            prints.add(entry);
        });

        ModelAndView mv = new ModelAndView("print/index");
        mv.addObject("prints", prints);


        return mv;
    }


}
