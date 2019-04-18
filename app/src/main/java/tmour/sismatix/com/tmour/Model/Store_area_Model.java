package tmour.sismatix.com.tmour.Model;

public class Store_area_Model {
    String image,name,sort_description,new_param,paymet_method,time_limit;

    public Store_area_Model(String image, String name,
                            String sort_description, String new_param,
                            String paymet_method, String time_limit) {
        this.image = image;
        this.name = name;
        this.sort_description = sort_description;
        this.new_param = new_param;
        this.paymet_method = paymet_method;
        this.time_limit = time_limit;
    }

    public String getImage() {

        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSort_description() {
        return sort_description;
    }

    public void setSort_description(String sort_description) {
        this.sort_description = sort_description;
    }

    public String getNew_param() {
        return new_param;
    }

    public void setNew_param(String new_param) {
        this.new_param = new_param;
    }

    public String getPaymet_method() {
        return paymet_method;
    }

    public void setPaymet_method(String paymet_method) {
        this.paymet_method = paymet_method;
    }

    public String getTime_limit() {
        return time_limit;
    }

    public void setTime_limit(String time_limit) {
        this.time_limit = time_limit;
    }
}
