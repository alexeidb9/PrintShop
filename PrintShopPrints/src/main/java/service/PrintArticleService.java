package main.java.service;

import main.java.service.models.AddPrint;
import main.java.service.models.GetPrint;

import java.awt.Image;
import java.util.List;

/**
 * Created by kevin on 03/07/2015.
 */
public interface PrintArticleService {

    List<GetPrint> getAllArticles(long id);
    GetPrint getArticle(long id);
    long addPrint(AddPrint entry);
    void updateArticle(AddPrint entry);
	Image getArticleImage(Long entryId);
}
