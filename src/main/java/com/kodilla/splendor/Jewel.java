package com.kodilla.splendor;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public final class Jewel {

    ImageView diamond = new ImageView(new Image("file:C:/Users/a-awo/Documents/Programowanie/Splendor/src/main/resources/stones/diamond.png"));
    ImageView sapphire = new ImageView(new Image("file:C:/Users/a-awo/Documents/Programowanie/Splendor/src/main/resources/stones/sapphire.png"));
    ImageView onyx = new ImageView(new Image("file:C:/Users/a-awo/Documents/Programowanie/Splendor/src/main/resources/stones/onyx.png"));
    ImageView emerald = new ImageView(new Image("file:C:/Users/a-awo/Documents/Programowanie/Splendor/src/main/resources/stones/emerald.png"));
    ImageView ruby = new ImageView(new Image("file:C:/Users/a-awo/Documents/Programowanie/Splendor/src/main/resources/stones/ruby.png"));
    ImageView gold = new ImageView(new Image("file:C:/Users/a-awo/Documents/Programowanie/Splendor/src/main/resources/stones/gold.png"));

    public ImageView getDiamond(){
        return diamond;
    }
    public ImageView getSapphire() {
        return sapphire;
    }

    public ImageView getOnyx(){
        return onyx;
    }
    public ImageView getEmerald(){
        return emerald;
    }
    public ImageView getRuby(){
        return ruby;
    }
    public ImageView getGold(){
        return gold;
    }


}
