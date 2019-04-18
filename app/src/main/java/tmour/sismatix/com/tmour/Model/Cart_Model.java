package tmour.sismatix.com.tmour.Model;

public class Cart_Model {
    String cart_image, cart_title, cart_item_price, cart_total;

    public Cart_Model(String cart_image, String cart_title, String cart_item_price, String cart_total) {
        this.cart_image = cart_image;
        this.cart_title = cart_title;
        this.cart_item_price = cart_item_price;
        this.cart_total = cart_total;
    }

    public String getCart_image() {
        return cart_image;
    }

    public void setCart_image(String cart_image) {
        this.cart_image = cart_image;
    }

    public String getCart_title() {
        return cart_title;
    }

    public void setCart_title(String cart_title) {
        this.cart_title = cart_title;
    }

    public String getCart_item_price() {
        return cart_item_price;
    }

    public void setCart_item_price(String cart_item_price) {
        this.cart_item_price = cart_item_price;
    }

    public String getCart_total() {
        return cart_total;
    }

    public void setCart_total(String cart_total) {
        this.cart_total = cart_total;
    }
}
