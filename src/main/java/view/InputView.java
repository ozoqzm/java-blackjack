package view;

import domain.Card;
import domain.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public List<String> names() {
        Scanner sc = new Scanner(System.in);
        System.out.println("게임에 참여할 사람의 이름을 입력하세요. (쉼표 기준으로 분리)");
        String nameList = sc.nextLine();
        List<String> arrayString = Arrays.asList(nameList.split(","));
//        for (String str: arrayString) {
//            if (str.length() > 5) // 이름 최대 5글자
//                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
//        }
        return arrayString;
    }

    // 카드 받을지 말지 여부
    public String whether(String input) {
        Scanner sc = new Scanner(System.in);
        System.out.println(input + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
        return sc.nextLine();
    }

    public double batting(Player player) {
        Scanner sc = new Scanner(System.in);
        System.out.println(player.getName() + "의 베팅 금액은?");
        return sc.nextDouble();
    }
}
