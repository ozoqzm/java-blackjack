import domain.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        // 반복문으로 이름 리스트에서...
        InputView iv = new InputView();
        OutputView ov = new OutputView();
        List<Player> players = createPlayers(iv.names());
        Rule rule = new Rule();

        //배팅 금액 입력 받기
        for (Player player : players) {
            double batting = iv.batting(player);
            // 배팅 금액 저장
            player.setBatting(batting);
        }

        // 카드 초기 분베
        Dealer dealer = new Dealer();
        List<Card> deck = createDeck();
        Collections.shuffle(deck); // 요소 무작위 섞기

        for (Player player : players) {
            player.addCard(deck.remove(0));
            player.addCard(deck.remove(0));
        }
        dealer.addCard(deck.remove(0));
        dealer.addCard(deck.remove(0));

        // 초기 조건
        rule.initialCheck(players, dealer);

        // 플레이어들 카드 받기 여부 & 받기 반복
        // 마지막에 딜러 카드 추가 가능 여부 확인 후 받기
        // 받은 후엔 해당 플레이어 전체 카드 리스트 출력
        for (Player player : players) {
            while (true) {
                String answer = iv.whether(player.getName());
                if (answer.equals("y")) {
                    if (player.getCardValue() == 21) // 이미 21
                        break;
                    player.addCard(deck.remove(0));
                    player.onlyShowCard();
                    if (player.getCardValue() > 21)
                        break; // 초과 시 break
                } else
                    break;
            }
        }
        if (dealer.getCardValue() < 17) {// 딜러 카드값 16 이하일 때만 카드 받기
            dealer.addCard(deck.remove(0));
            System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
        }

        // 전체 카드 개수 출력 - 플레이어 리스트, 딜러 하나 받아와서
        ov.showResult(players, dealer);

//        // 최종 승패 결과 출력
//        rule.determineWinner(players, dealer);

        // 최종 수익 출력
        // Rule에서 승패 나눈 거 바탕으로 최종 수익..?
        rule.determineResult(players, dealer);
        ov.showProfit(players, dealer);
    }

    private static List<Player> createPlayers(List<String> names) {
        List<Player> players = new ArrayList<>();
        for (String name : names) {
            players.add(new Player(name.trim())); // 문자열 공백제거
        }
        return players;
    }

    private static List<Card> createDeck() {
        List<Card> deck = new ArrayList<>(); // 전체 카드들 리스트
        for (Denomination denomination : Denomination.values()) {
            for (int i = 0; i < 4; i++) { // 각 문양당 4장의 카드
                deck.add(new Card(denomination));
            }
        }
        return deck;
    }
}
