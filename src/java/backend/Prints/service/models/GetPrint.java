package backend.Prints.service.models;

import lombok.Data;

import java.awt.image.BufferedImage;
import java.util.List;

@Data
public class GetPrint {

    private Long userId;
    private String url;
    private String title;
    private Long printId;
    private BufferedImage image;
    private List<String> tags;
    boolean isArchived;
    boolean isFavourite;



}
