package utility;

public enum Type {

    FOOD("food"), DRINKS("drinks"), SANITARY("sanitary"), MAKEUP("makeup"), OTHERS("others");

    public final String type;

    Type(String type) {
        this.type = type;
    }

    public String getValue() {
        return this.type;
    }
}

