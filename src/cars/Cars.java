package cars;

public class Cars implements Comparable<Cars>{
    String name;
    String origin;
    Float horsepower;

    public Cars(String name, String origin, Float horsepower){
        this.name = name;
        this.origin = origin;
        this.horsepower = horsepower;
    }

    public Cars() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Float getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(Float horsepower) {
        this.horsepower = horsepower;
    }

    public String output(){

        return this.name + ", " + this.origin + ", " + this.horsepower.toString();
    }

    //For sorting
    @Override
    public int compareTo(Cars c) {
        if (getHorsepower() == null || c.getHorsepower() == null) {
            return 0;
        }
        return c.getHorsepower().compareTo(getHorsepower());
    }
}
