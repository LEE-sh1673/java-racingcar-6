package racingcar.model;

import java.util.Objects;
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

    String name() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Name other = (Name) o;
        return name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
