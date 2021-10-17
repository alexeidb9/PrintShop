package models.Prints.service;

import models.Prints.repository.PrintRepository;
import main.models.Prints.service.models.AddPrint;
import main.models.Prints.service.models.GetPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public class PrintDetailsServiceOnPrintRepository implements PrintService {

    PrintRepository printRepository;
//    main.Log log;

    @Autowired
    public PrintDetailsServiceOnPrintRepository(PrintRepository printsRepository) {
        this.printRepository = printRepository;
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
