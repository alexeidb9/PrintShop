package main.java.service.models;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GetPrint {

    private Long userId;
    private String url;
    private String title;
    private Long printId;
    private Image image;
    private List<String> tags;
    boolean isArchived;
    boolean isFavourite;

    public GetPrint(Long userId, String url, String title, Long entryId) {
        this.setUserId(userId);
        this.url = url;
        this.title = title;
        this.setPrintId(entryId);
        tags = new ArrayList<String>();
        isArchived = false;
        isFavourite = false;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void ToggleFavourite() {
        isFavourite = !isFavourite;
    }

    public void ToggleArchive() {
        isArchived = !isArchived;
    }


    public void addTag(String tag) {
        // todo: tag should not exist in list already
        tags.add(tag);
    }

    public void removeTag(String tag) {
        // todo: tag should exist in list already
        tags.remove(tag);
    }

    @Override
    public String
    toString() {
        return "GetPrint{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPrintId() {
        return printId;
    }

    public void setPrintId(Long printId) {
        this.printId = printId;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}




