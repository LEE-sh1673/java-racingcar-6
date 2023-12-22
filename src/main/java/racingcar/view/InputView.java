package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import racingcar.model.Cars;
import racingcar.model.TryCount;
import racingcar.validator.NumericValidator;

public class InputView {

    private static final String INPUT_NUMBER_OF_ATTEMPTS = "시도할 회수는 몇회인가요?";
    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private static final String NAME_SPLITTER = ",";

    public Cars readCars() {
        System.out.println(INPUT_CAR_NAMES);
        final String names = Console.readLine();
        return Cars.withNames(Arrays.asList(names.split(NAME_SPLITTER)));
    }

    public TryCount readTryCount() {
        System.out.println(INPUT_NUMBER_OF_ATTEMPTS);
        final String stringNumber = Console.readLine();
        NumericValidator.validate(stringNumber);
        return TryCount.valueOf(Integer.parseInt(stringNumber));
    }
}
