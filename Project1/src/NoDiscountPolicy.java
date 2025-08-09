/*
 * 3.NoDiscountPolicy Class
 * this class represent a policy with no discount.
 */
public class NoDiscountPolicy implements DiscountPolicy{
    @Override
    public double applyDiscount(double amount) {
        if(amount<0){
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        return amount;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "No Discount";
    }
}