package tmour.sismatix.com.tmour.Model;

public class Offers_Model {

    String dates_image,discount,description,price,fake_price;

    public Offers_Model(String dates_image, String discount, String description, String price, String fake_price) {
        this.dates_image = dates_image;
        this.discount = discount;
        this.description = description;
        this.price = price;
        this.fake_price = fake_price;
    }

    public String getDates_image() {
        return dates_image;
    }

    public void setDates_image(String dates_image) {
        this.dates_image = dates_image;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFake_price() {
        return fake_price;
    }

    public void setFake_price(String fake_price) {
        this.fake_price = fake_price;
    }

}
