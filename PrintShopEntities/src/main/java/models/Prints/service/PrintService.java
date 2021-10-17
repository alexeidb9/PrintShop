package models.Prints.service;

import main.models.Prints.service.models.AddPrint;
import main.models.Prints.service.models.GetPrint;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;;

@Service
public interface PrintService {

    List<GetPrint> getAllPrints();
    Image getPrintImage(Long entryId);
    long addPrint(AddPrint entry);
    void updatePrint(AddPrint entry);

}
