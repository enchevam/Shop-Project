package utility;

public class Types {

    public enum types {
        FOOD,DRINKS,SANITARY,MAKEUP,OTHERS;
        }

public String enumTypes(){
        types types = Types.types.FOOD;
        switch (types) {
            case FOOD -> {
                return "food";
            }
            case OTHERS -> {
                return "others";
            }
            case DRINKS -> {
                return "drinks";
            }
            case SANITARY -> {
                return "sanitary";
            }
            case MAKEUP -> {
                return "makeup";
            }default -> System.out.println("NO OTHER TYPES");
        }
    return "something went wrong";
}
}
