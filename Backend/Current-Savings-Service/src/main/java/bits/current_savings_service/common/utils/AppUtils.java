package bits.current_savings_service.common.utils;

import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class AppUtils {

    public static final String BASE_URL = "/api/v1/current-savings-service";
    public static final String SERVICE_NAME = "current-savings-service";

    public static boolean isUserIdentityFormatValid(List<String> regexList,
                                                    String userIdentity) {
        return regexList.stream().anyMatch(item -> {
            Pattern pattern = Pattern.compile(item);
            Matcher matcher = pattern.matcher(userIdentity);
            return matcher.matches();
        });
    }

    private AppUtils() {
    }

    public static String generateRandomString(Integer size) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = size;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
}
