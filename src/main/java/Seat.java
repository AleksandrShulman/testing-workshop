/**
 * Created by ashulman on 11/16/17.
 */
public class Seat {

    private final Integer label;
    private Integer price;
    private boolean booked;


    static final Integer UNSET_PRICE = -99;

    public Seat(Integer label) {
        this.label = label;
        this.setPrice(UNSET_PRICE);
    }

    public Seat(Integer label, Integer price) {
        this.label = label;
        this.setPrice(price);
    }

    public Integer getLabel() {
        return label;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
