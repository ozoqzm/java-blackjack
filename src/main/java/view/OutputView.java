package view;

import domain.Card;
import domain.Dealer;
import domain.Player;

import java.util.List;

public class OutputView {
    // 해당 플레이어가 가지고 있는 카드 출력
    public void showResult(List<Player> players, Dealer dealer) {
        for (Player player : players) {
            player.showCard();
        }
        dealer.showCard();
    }

    // 최종 수익 출력
    public void showProfit(List<Player> players, Dealer dealer) {
        System.out.println("### 최종 수익");
        for (Player player : players) {
            System.out.println(player.getName() +": " + player.getProfit());
        }
        System.out.println("딜러: " + dealer.getProfit());
    }

}
