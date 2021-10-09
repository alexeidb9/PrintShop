package backend.Prints.service;

import backend.Prints.service.models.AddPrint;
import backend.Prints.service.models.GetPrint;

import java.awt.*;
import java.util.List;;

public interface PrintService {

    List<GetPrint> getAllPrints();
    Image getPrintImage(Long entryId);
    long addPrint(AddPrint entry);
    void updatePrint(AddPrint entry);

}
