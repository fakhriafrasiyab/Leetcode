package test;

public final class Employee {

    private final String name;
    private final Address addr;

    public Employee(String name, Address addr) {
        this.name = name;
        this.addr = new Address(addr.getCity());
    }

    public String getName() {
        return name;
    }

    public Address getAddr() {
        return new Address(addr.getCity());
    }


}
