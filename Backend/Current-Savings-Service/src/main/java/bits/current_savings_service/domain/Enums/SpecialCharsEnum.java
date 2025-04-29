package bits.current_savings_service.domain.enums;

public enum SpecialCharsEnum {

    COLON(":"),
    SPACE(" "),
    HYPHEN("-"),
    UNDERSCORE("_"),
    HASH("#"),
    AT_SIGN("@"),
    PREFIX("MERCHANT");

    private String sign;

    SpecialCharsEnum(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

}
