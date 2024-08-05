package domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> cards = new ArrayList<>();
    private double profit = 0; // 베팅값
    private double batting = 0;

    public Player() {}

    public Player(String name) {
        this.name = name;
    }

    public void setBatting(double batting) {
        this.batting = batting;
    }

    public double getBatting() {
        return batting;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getProfit() {
        return profit;
    }

    public void win(double amount) {
        profit += amount;
    }

    public void lose() {
        profit -= batting;
    }

    public String getName() {
        return name;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getCardValue() {
        // 카드 값 계산
        int value = 0;
        int aceCount = 0;

        for (Card card : cards) {
            value += card.getValue();
            if (card.isAce()) {
                aceCount++;
            }
        }
        while (value <= 11 && aceCount > 0) {
            value += 10;
            aceCount--;
        }
        return value;
    }

    public void showCard() {
        System.out.println(name + "카드: " + cards + " - 결과: " + getCardValue());
    }
    public void onlyShowCard() {
        System.out.println(name + "카드: " + cards);
    }

}
