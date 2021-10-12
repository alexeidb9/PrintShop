package backend.Prints;

import backend.Authors.Author;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity(name = "canvases")
@Data
@NoArgsConstructor
public class Canvas extends Print {

    //8x8, 30x30 (popular)
    private double canvasSize;

    private CanvasType canvasType;

    //TODO
    //    Switch statement for canvas type
//
//    switch(enum type) {
//        case
//    }


    @ManyToOne
    private Author author;


}
