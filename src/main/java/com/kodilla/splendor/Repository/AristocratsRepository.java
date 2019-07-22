package com.kodilla.splendor.Repository;

import com.kodilla.splendor.Aristocrats;
import com.kodilla.splendor.Colors;
import com.kodilla.splendor.Move;
import com.kodilla.splendor.Player;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.*;

public class AristocratsRepository {

    private Random random = new Random();

    private Map<Colors, Integer> annaCost = new HashMap<>();
    private Map<Colors, Integer> catherineCost = new HashMap<>();
    private Map<Colors, Integer> charlesCost = new HashMap<>();
    private Map<Colors, Integer> elizabethCost = new HashMap<>();
    private Map<Colors, Integer> francisCost = new HashMap<>();
    private Map<Colors, Integer> isabellaCost = new HashMap<>();
    private Map<Colors, Integer> maryCost = new HashMap<>();
    private Map<Colors, Integer> niccoloCost = new HashMap<>();
    private Map<Colors, Integer> sulejmanCost = new HashMap<>();
    private Map<Colors, Integer> henryCost = new HashMap<>();


    private ImageView annaView = new ImageView(new Image("file:src/main/resources/aristocrats/Anna.png", 150, 150, true, true));
    private ImageView catherineView = new ImageView(new Image("file:src/main/resources/aristocrats/Catherine.png", 150, 150, true, true));
    private ImageView charlesView = new ImageView(new Image("file:src/main/resources/aristocrats/Charles.png", 150, 150, true, true));
    private ImageView elizabethView = new ImageView(new Image("file:src/main/resources/aristocrats/Elisabeth.png", 150, 150, true, true));
    private ImageView francisView = new ImageView(new Image("file:src/main/resources/aristocrats/Francis.png", 150, 150, true, true));
    private ImageView isabellaView = new ImageView(new Image("file:src/main/resources/aristocrats/Isabella.png", 150, 150, true, true));
    private ImageView maryView = new ImageView(new Image("file:src/main/resources/aristocrats/Mary.png", 150, 150, true, true));
    private ImageView niccoloView = new ImageView(new Image("file:src/main/resources/aristocrats/Niccolo.png", 150, 150, true, true));
    private ImageView sulejmanView = new ImageView(new Image("file:src/main/resources/aristocrats/Sulejman.png", 150, 150, true, true));
    private ImageView henryView = new ImageView(new Image("file:src/main/resources/aristocrats/Henry.png", 150, 150, true, true));

    private int annaValue = 3;
    private int catherineValue = 3;
    private int charlesValue = 3;
    private int elizabethValue = 3;
    private int francisValue = 3;
    private int isabellaValue = 3;
    private int maryValue = 3;
    private int niccoloValue = 3;
    private int sulejmanValue = 3;
    private int henryValue = 3;

    private List<Aristocrats> aristocratsList = new ArrayList<>();

    private List<Aristocrats> threeAristocratsList = new ArrayList<>();

    private Aristocrats anna = new Aristocrats(annaCost, annaView, annaValue);
    private Aristocrats catherine = new Aristocrats(catherineCost, catherineView, catherineValue);
    private Aristocrats charles = new Aristocrats(charlesCost, charlesView, charlesValue);
    private Aristocrats elizabeth = new Aristocrats(elizabethCost, elizabethView, elizabethValue);
    private Aristocrats francis = new Aristocrats(francisCost, francisView, francisValue);
    private Aristocrats isabella = new Aristocrats(isabellaCost, isabellaView, isabellaValue);
    private Aristocrats mary = new Aristocrats(maryCost, maryView, maryValue);
    private Aristocrats niccolo = new Aristocrats(niccoloCost, niccoloView, niccoloValue);
    private Aristocrats sulejman = new Aristocrats(sulejmanCost, sulejmanView, sulejmanValue);
    private Aristocrats henry = new Aristocrats(henryCost, henryView, henryValue);


    public AristocratsRepository() {
        annaCost.put(Colors.BLUE, 3);
        annaCost.put(Colors.BLACK, 0);
        annaCost.put(Colors.RED, 0);
        annaCost.put(Colors.GREEN, 3);
        annaCost.put(Colors.WHITE, 3);

        catherineCost.put(Colors.BLUE, 3);
        catherineCost.put(Colors.BLACK, 0);
        catherineCost.put(Colors.RED, 3);
        catherineCost.put(Colors.GREEN, 3);
        catherineCost.put(Colors.WHITE, 0);

        charlesCost.put(Colors.BLUE, 0);
        charlesCost.put(Colors.BLACK, 3);
        charlesCost.put(Colors.RED, 3);
        charlesCost.put(Colors.GREEN, 0);
        charlesCost.put(Colors.WHITE, 3);

        elizabethCost.put(Colors.BLUE, 3);
        elizabethCost.put(Colors.BLACK, 3);
        elizabethCost.put(Colors.RED, 0);
        elizabethCost.put(Colors.GREEN, 0);
        elizabethCost.put(Colors.WHITE, 3);

        francisCost.put(Colors.BLUE, 0);
        francisCost.put(Colors.BLACK, 3);
        francisCost.put(Colors.RED, 3);
        francisCost.put(Colors.GREEN, 3);
        francisCost.put(Colors.WHITE, 0);

        isabellaCost.put(Colors.BLUE, 0);
        isabellaCost.put(Colors.BLACK, 4);
        isabellaCost.put(Colors.RED, 0);
        isabellaCost.put(Colors.GREEN, 0);
        isabellaCost.put(Colors.WHITE, 4);

        maryCost.put(Colors.BLUE, 0);
        maryCost.put(Colors.BLACK, 0);
        maryCost.put(Colors.RED, 4);
        maryCost.put(Colors.GREEN, 4);
        maryCost.put(Colors.WHITE, 0);

        niccoloCost.put(Colors.BLUE, 4);
        niccoloCost.put(Colors.BLACK, 0);
        niccoloCost.put(Colors.RED, 0);
        niccoloCost.put(Colors.GREEN, 0);
        niccoloCost.put(Colors.WHITE, 4);

        sulejmanCost.put(Colors.BLUE, 4);
        sulejmanCost.put(Colors.BLACK, 0);
        sulejmanCost.put(Colors.RED, 0);
        sulejmanCost.put(Colors.GREEN, 4);
        sulejmanCost.put(Colors.WHITE, 0);

        henryCost.put(Colors.BLUE, 0);
        henryCost.put(Colors.BLACK, 4);
        henryCost.put(Colors.RED, 4);
        henryCost.put(Colors.GREEN, 0);
        henryCost.put(Colors.WHITE, 0);

        aristocratsList.add(anna);
        aristocratsList.add(catherine);
        aristocratsList.add(charles);
        aristocratsList.add(elizabeth);
        aristocratsList.add(francis);
        aristocratsList.add(isabella);
        aristocratsList.add(mary);
        aristocratsList.add(niccolo);
        aristocratsList.add(sulejman);
        aristocratsList.add(henry);

    }

    public List<Aristocrats> getThreeAristocratsList() {
        return threeAristocratsList;
    }


    public void drawThreeAristocrats() {
        Aristocrats aristocrat1 = drawAristocrat();
        Aristocrats aristocrat2 = drawAristocrat();
        Aristocrats aristocrat3 = drawAristocrat();

        threeAristocratsList.add(aristocrat1);
        threeAristocratsList.add(aristocrat2);
        threeAristocratsList.add(aristocrat3);
    }

    public Aristocrats drawAristocrat() {
        Aristocrats randomAristocrat = new Aristocrats();
        if (aristocratsList.size() > 0) {
            randomAristocrat = aristocratsList.get(random.nextInt(aristocratsList.size()));
            aristocratsList.remove(randomAristocrat);
        }
        return randomAristocrat;
    }


    public boolean takeAristocrat(Player player, Aristocrats aristocrat) {
        boolean ifAristocratTaken = false;
        if(Move.validateMove("aristocrat")){
            int aristocratPosition = threeAristocratsList.indexOf(aristocrat);

            long costCheckCounter = aristocrat.getCost().entrySet().stream()
                    .filter(e -> player.getCardCounter().get(e.getKey()) >= e.getValue())
                    .count();

            if (costCheckCounter == 5L) {
                player.setResult(player.getResult() + aristocrat.getValue());
                player.getAristocrats().add(aristocrat);
                ifAristocratTaken = true;
                Move.setAristocratsTaken(Move.getAristocratsTaken() + 1);
                threeAristocratsList.set(aristocratPosition, drawAristocrat());
            }
        }
        return ifAristocratTaken;
    }
}
