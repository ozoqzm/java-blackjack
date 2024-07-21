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
    public void determineResult(List<Player> players, Dealer dealer) {
        for (Player player : players) {
            int pValue = player.getCardValue();
            int dValue = dealer.getCardValue();

            // 플레이어 21 초과
            if (pValue > 21) {
                player.lose();
                dealer.win(player.getBatting());
            }
            // 딜러 21 초과
            else if (dValue > 21) {
                player.win(player.getBatting());
            }
            // 플레이어 값 더 근접
            else if (pValue > dValue) {
                player.win(player.getBatting());
            }
            // 둘의 값 같음 (동시 21)
            else if (dValue == pValue) {
                player.win(player.getBatting());
            }
        }
    }
    // 초기 분배 후 체크
    public void initialCheck(List<Player> players, Dealer dealer) {
        for (Player player : players) {
            if (player.getCardValue() == 21) {
                player.win(player.getBatting() * 1.5);
                dealer.lose(player.getBatting() * 1.5);
            }
        }
    }
}
