package com.kodilla.splendor;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public final class Cards3Level {

    ImageView blue3White3Green3Black5 = new ImageView(
            new Image("file:C:/Users/a-awo/Documents/Programowanie/Splendor/src/main/resources/cards/level3/3blue__3white_3green_3red_5black.png",
                    120,240, true, true));
    ImageView blue4White6Blue3Black3 = new ImageView(
            new Image("file:C:/Users/a-awo/Documents/Programowanie/Splendor/src/main/resources/cards/level3/4blue__6white_3blue_3black.png",
                    120,240, true, true));
    ImageView blue4White7 = new ImageView(
            new Image("file:C:/Users/a-awo/Documents/Programowanie/Splendor/src/main/resources/cards/level3/4blue_7white.png",
                    120,240, true, true));
    ImageView blue5Blue3White7 = new ImageView(
            new Image("file:C:/Users/a-awo/Documents/Programowanie/Splendor/src/main/resources/cards/level3/5blue__3blue_7white.png",
                    120,240, true, true));




    public ImageView getBlue3White3Green3Black5(){
        return blue3White3Green3Black5;
    }
    public ImageView getBlue4White6Blue3Black3(){
        return blue4White6Blue3Black3;
    }
    public ImageView getBlue4White7(){
        return blue4White7;
    }
    public ImageView getBlue5Blue3White(){
        return blue5Blue3White7;
    }


}
