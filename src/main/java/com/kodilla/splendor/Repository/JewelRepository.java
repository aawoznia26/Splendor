package com.kodilla.splendor.Repository;

import com.kodilla.splendor.Colors;
import com.kodilla.splendor.Jewel;
import com.kodilla.splendor.Player;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class JewelRepository {

    private List<Jewel> jewelList = new ArrayList<>();

    private Image diamondImage = new Image("file:src/main/resources/stones/diamond.png");
    private Image sapphireImage = new Image("file:src/main/resources/stones/sapphire.png");
    private Image onyxImage = new Image("file:src/main/resources/stones/onyx.png");
    private Image emeraldImage = new Image("file:src/main/resources/stones/emerald.png");
    private Image rubyImage = new Image("file:src/main/resources/stones/ruby.png");

    private Jewel diamond = new Jewel(Colors.WHITE, new ImageView(diamondImage), 4);
    private Jewel sapphire = new Jewel(Colors.BLUE, new ImageView(sapphireImage), 4);
    private Jewel onyx = new Jewel(Colors.BLACK, new ImageView(onyxImage), 4);
    private Jewel emerald = new Jewel(Colors.GREEN, new ImageView(emeraldImage), 4);
    private Jewel ruby = new Jewel(Colors.RED, new ImageView(rubyImage), 4);

    public JewelRepository() {
        jewelList.add(diamond);
        jewelList.add(sapphire);
        jewelList.add(onyx);
        jewelList.add(emerald);
        jewelList.add(ruby);
    }

    public List<Jewel> getJewelList() {
        return jewelList;
    }

    public Image getDiamondImage() {
        return diamondImage;
    }

    public Image getSapphireImage() {
        return sapphireImage;
    }

    public Image getOnyxImage() {
        return onyxImage;
    }

    public Image getEmeraldImage() {
        return emeraldImage;
    }

    public Image getRubyImage() {
        return rubyImage;
    }

    public Jewel getDiamond() {
        return diamond;
    }

    public Jewel getSapphire() {
        return sapphire;
    }

    public Jewel getOnyx() {
        return onyx;
    }

    public Jewel getEmerald() {
        return emerald;
    }

    public Jewel getRuby() {
        return ruby;
    }

    public void takeJewel(Player player, Colors color) {

        Jewel foundJewel = jewelList.stream()
                .filter(j -> j.getColor() == color)
                .findAny().get();

        if (foundJewel.getNumber() > 0) {
            foundJewel.setNumber(foundJewel.getNumber() - 1);
            int playerJewelCounter = player.getJewelCounter().get(color);
            player.getJewelCounter().replace(color, playerJewelCounter + 1);
        } else {
            System.out.println("There is no jewel to take");
        }

    }

}
