package carracing;

import java.util.regex.Pattern;

import static java.util.Objects.*;

public class RacingGameSetupValidator {
    private static final Pattern PATTERN_FOR_POSITIVE_INTEGER = Pattern.compile("^(0*[1-9][0-9]*)$");

    private RacingGameSetupValidator() {

    }

    public static boolean isPositiveInteger(String input) {
        return !isNull(input) && !input.isBlank() && PATTERN_FOR_POSITIVE_INTEGER.matcher(input).find();
    }
}