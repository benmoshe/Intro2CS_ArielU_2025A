package Tirgul.week7;

public class Shopping {
    private String dateOfShopping;
    private double price;
    private int howLongItTook;
    private String shopName;

    public Shopping(String date, double pr, int time, String name) {
        int year = 0;
        try {
            year = Integer.parseInt(date.substring(6, 10));
        } catch (Exception e) {
            System.out.println("Date in wrong format, or year is too old");
        }

        if (date.charAt(2) != '/' || date.charAt(5) != '/' || year < 2022) {
            throw new RuntimeException("Date in wrong format, or year is too old");
        } else {
            setDateOfShopping(date);
            setPrice(pr);
            setHowLongItTook(time);
            setShopName(name);
        }
    }
    public String getDateOfShopping() {
        return dateOfShopping;
    }

    public void setDateOfShopping(String date) {
        dateOfShopping = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double pr) {
        price = pr;
    }

    public int getHowLongItTool() {
        return howLongItTook;
    }

    public void setHowLongItTook(int time) {
        howLongItTook = time;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String name) {
        shopName = name;
    }

    public void discount(int percent) {
        double old = getPrice();
        setPrice(old - (old * percent) / 100);
    }

    public String display() {
        return ("the date is: " + dateOfShopping + ". the price is: " + price + ". the shop name is: " + shopName);
    }

}
