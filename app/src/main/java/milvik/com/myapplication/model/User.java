package milvik.com.myapplication.model;

public class User {
    String name;
    Double balance;
    RechargeBundle rechargeBundle;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public RechargeBundle getRechargeBundle() {
        return rechargeBundle;
    }

    public void setRechargeBundle(RechargeBundle rechargeBundle) {
        this.rechargeBundle = rechargeBundle;
    }
}
