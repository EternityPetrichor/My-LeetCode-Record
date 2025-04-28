public class Address implements Cloneable{
    String city;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Address(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
