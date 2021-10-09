package backend.Prints.service;

import com.alxndr.printshop.backend.models.Prints.model.Print;
import com.alxndr.printshop.backend.models.Prints.repository.PrintsRepository;
import backend.Prints.service.models.AddPrint;
import backend.Prints.service.models.GetPrint;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;
import java.util.List;

public class PrintDetailsServiceOnPrintRepository implements PrintService {

    PrintsRepository printsRepository;
//    Log log;

    @Autowired
    public PrintDetailsServiceOnPrintRepository(PrintsRepository printsRepository) {
        this.printsRepository = printsRepository;
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
