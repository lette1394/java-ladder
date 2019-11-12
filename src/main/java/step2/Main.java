package step2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

import step2.domain.BooleanGenerator;
import step2.domain.Ladder;
import step2.domain.WidthAwareRandomBooleanGenerator;

public class Main {
    public static void main(String[] args) {
        main(args, WidthAwareRandomBooleanGenerator::new);
    }

    public static void main(String[] args, Function<Integer, BooleanGenerator> booleanGenerator) {
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        final List<String> names = Arrays.stream(sc.nextLine().split(","))
                                         .map(String::trim)
                                         .collect(Collectors.toList());

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        final int height = Integer.parseInt(sc.nextLine());

        System.out.println("한 사다리 폭은 몇 인가요?");
        final int width = Integer.parseInt(sc.nextLine());

        System.out.println("실행결과");
        System.out.println();
        System.out.print(Ladder.builder()
                               .maxHeight(height)
                               .maxWidth(width)
                               .names(names)
                               .booleanGenerator(booleanGenerator)
                               .build().print());
    }
}
