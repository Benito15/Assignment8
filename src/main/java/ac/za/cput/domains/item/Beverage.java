package ac.za.cput.domains.item;

public class Beverage extends Item{

    private int volume;

//    private Beverage() {
//    }

    public Beverage(Builder builder) {
       super(builder);
       volume = 0;

    }

    public static class Builder extends Item.Builder{

        int volume;

        public Builder volume(int volume)
        {
            this.volume = volume;
            return this;
        }


        public Beverage build() {
            return new Beverage(this);
        }

    }

    @Override
    public String toString() {
        return "\n Beverage{" +
                "ItemID='" + itemID + "\n" +
                "Desc='" + desc + "\n" +
                "qty=" + qty + "\n"+
                "price=" + price + "\n"+
                "volume=" + volume + "\n"
               ;
    }
}
