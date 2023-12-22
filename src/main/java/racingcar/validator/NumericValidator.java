package racingcar.validator;

import java.util.regex.Pattern;
import org.junit.platform.commons.util.StringUtils;

public class NumericValidator {

    private static final Pattern NUMERIC_PATTERN = Pattern.compile("\\d+");

    // 기본 생성자가 만들어지는 것을 막는다. (인스턴스화 방지용).
    private NumericValidator() {
        throw new AssertionError();
    }

    public static void validate(final String stringNumber) {
        if (StringUtils.isBlank(stringNumber) || !isNumeric(stringNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isNumeric(final String stringNumber) {
        return NUMERIC_PATTERN.matcher(stringNumber).matches();
    }
}
