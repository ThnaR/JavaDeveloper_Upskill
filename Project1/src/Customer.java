/*
 * 5.Customer Class
 * It has a "has-a" relationship with DiscountPolicy
 * This class represents a customer with an ID, name, and a DiscountPolicy
 */
public class Customer {
    private final int id;
    private String name;
    private DiscountPolicy discountPolicy;

    /*
     * Constructor for create customer object
     * 
     * @param id รหัสลูกค้าไม่ซ้ำกัน
     * 
     * @param name ไม่ค่าว่าง
     * 
     * @param discount ส่วนลด(%) ต้องอยู่ระหว่าง 0-100
     * 
     * @throws IllegalArgumentException หาก @params ไม่ถูกต้อง
     */
    public Customer(int id, String name, DiscountPolicy discountPolicy) {
        if (id < 0) {
            throw new IllegalArgumentException("Customer ID must be non-negative.");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Customer Name must not be null or blank.");
        }
        if (discountPolicy == null) {
            throw new IllegalArgumentException("Customer must have a discount policy.");
        }

        this.id = id;
        this.name = name;
        this.discountPolicy = discountPolicy;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public DiscountPolicy getDiscountPolicy() {
        return this.discountPolicy;
    }

    public void setDiscount(DiscountPolicy policy) {
        if (policy == null) {
            throw new IllegalArgumentException("Customer must have a discount policy.");
        }
        this.discountPolicy = policy;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Customer{" + "id= " + id + ", name= " + name + ", discountPolicy= " + discountPolicy + "}";
    }
}
