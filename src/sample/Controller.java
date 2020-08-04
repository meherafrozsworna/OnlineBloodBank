package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Controller {
    public ImageView image1 = new ImageView(new Image(getClass().getResourceAsStream("/image/1.jpg")));
    public AnchorPane pane;
//    Image img = new Image(Main.class.getResourceAsStream("1.png"));
//    image1.setImage(img);
//    ImageView img = new ImageView(new Image(getClass().getResourceAsStream("/image/1.jpg")));
//    image1.
    public void setImage1(){
        ImageView img = new ImageView(new Image(getClass().getResourceAsStream("/image/1.jpg")));
        pane.getChildren().setAll(img);
    }

}
