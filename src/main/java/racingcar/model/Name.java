package racingcar.model;

import org.junit.platform.commons.util.StringUtils;

class Name {

    private static final int MAX_LENGTH = 5;

    private final String name;

    private Name(final String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException();
        }
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    static Name create(final String name) {
        return new Name(name);
    }

    String getName() {
        return name;
    }
}
