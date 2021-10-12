package backend.Prints.service;

import backend.Prints.repository.PrintController;
import backend.Prints.service.models.AddPrint;
import backend.Prints.service.models.GetPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public class PrintDetailsServiceOnPrintRepository implements PrintService {

    PrintController printController;
//    Log log;

    @Autowired
    public PrintDetailsServiceOnPrintRepository(PrintController printsRepository) {
        this.printController = printController;
    }


    @Override
    public List<GetPrint> getAllPrints() {
        return null;
    }

    @Override
    public Image getPrintImage(Long entryId) {
        return null;
    }

    @Override
    public long addPrint(AddPrint entry) {
        return 0;
    }

    @Override
    public void updatePrint(AddPrint entry) {

    }
}
