/*
 * 1.DiscountPolicy Interface
 */
public interface DiscountPolicy {
    /*
     * @param amount the original amount
     * return amount after discount is applied.
     */
    double applyDiscount(double amount);
}
