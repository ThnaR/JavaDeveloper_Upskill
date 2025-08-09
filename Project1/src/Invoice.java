/*
 * 6.Invoice Class
 * This class represents an invoice, linking a customer to a total amount.
 * Relationship 'has-a' (มี class customer) เช่น รถยนต์ ต้องมี เครื่องยนต์, ล้อ
 */
public class Invoice {
    private int id;
    private Customer customer; // Composition concept
    private double amount;

    public Invoice(int id, Customer customer, double amount) {
        if (id < 0) {
            throw new IllegalArgumentException("Customer ID must be non-negative.");
        }

        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null.");
        }

        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be non-negative.");
        }

        this.id = id;
        this.customer = customer;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be non-negative.");
        }
        this.amount = amount;
    }

    public void setCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null.");
        }

        this.customer = customer;
    }

    public int getCustomerId() {
        return customer.getId();
    }

    public String getCustomerName() {
        return customer.getName();
    }

    /*
     * public int getCustomerDiscount() {
     * return customer.getDiscount();
     * }
     */

    // คำนาณ ยอดเงินสุดท้ายหลังหักส่วนลด
    // Core buisness logic: apply the customer's discount policy
    public double getAmountAfterDiscount() {
        // 1.คำนวณหาส่วนลดจริง
        // double discountAmount = this.amount * (customer.getDiscount() / 100.0);
        // 2.คำนวณหายอดเงินสุดท้ายหลังหักส่วนลด
        // return this.amount = discountAmount;

        return this.customer.getDiscountPolicy().applyDiscount(this.amount);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Invoice{ " + "id= " + id + ", customerId= " + getCustomerId() + ", customerName= " + getCustomerName() +
                ", originalAmount= " + String.format("%.2f", amount) +
                ", discountAmount= " + String.format("%.2f", getAmountAfterDiscount())+"}";
    }
}
