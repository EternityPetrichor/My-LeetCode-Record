public class Person implements Cloneable{
    String name;
    Address address;

    public Person(String name, Address address){
        this.name = name;
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person cloneP = (Person) super.clone();
        cloneP.address = new Address(address.city);
        return cloneP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
