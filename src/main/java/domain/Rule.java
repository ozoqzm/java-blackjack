package domain;

import java.util.List;

public class Rule {
    // 승패 결과 계산
    public void determineWinner(List<Player> players, Dealer dealer) {
        int max = dealer.getCardValue();
        String winner = "dealer";
        int dealerWinCount = 0;
        int dealerLoseCount = 0;

        for (Player player : players) {
            if (player.getCardValue() > 21) {
                System.out.println(player.getName() + ": 패");
                dealerWinCount++; // 초과 시 딜러 승
                continue;
            }
            if (player.getCardValue() > dealer.getCardValue()) {
                dealerLoseCount++;
                System.out.println(player.getName() + ": 승");
            }
            if (player.getCardValue() < dealer.getCardValue()) {
                dealerWinCount++;
                System.out.println(player.getName() + ": 패");
            }
            else
                System.out.println(player.getName() + ": 무");
        }
        System.out.println("딜러: " +dealerWinCount+ "승" +dealerLoseCount+ "패");
    }
}
