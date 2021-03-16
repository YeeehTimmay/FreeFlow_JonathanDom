/**
 * Jonathan Dom
 * 1/6/2021
 */
public enum Type {
    EMPTY("Empty"), CIRCLE("Circle"), LINE("Line");

    private String types;

    private Type(String types){
        this.types = types;


    }
    public String getTypes(){
        return types;
    }
}
