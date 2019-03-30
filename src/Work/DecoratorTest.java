package Work;

/**
 * Created by zouy on 19-3-29.
 */
public class DecoratorTest {

    public static void main(String[] args) {
        Drink drink = new Coffee();
        System.out.println(drink.getDescription() + ":" + drink.cost());
        //加牛奶进行装饰
        drink = new Milk(drink);
        System.out.println(drink.getDescription() + ":" + drink.cost());
        //加糖装饰
        drink = new Sugar(drink);
        System.out.println(drink.getDescription() + ":" + drink.cost());
    }

    public interface Drink {
        float cost();
        String getDescription();
    }

    public static class Coffee implements Drink {
        private String description = "coffee";
        @Override
        public float cost() {
            return 10;
        }

        @Override
        public String getDescription() {
            return description;
        }
    }

    public static class Decorator implements Drink{
        protected Drink drink;

        public Decorator(Drink drink) {
            this.drink = drink;
        }
        @Override
        public float cost() {
            return drink.cost();
        }
        @Override
        public String getDescription() {
            return drink.getDescription();
        }
    }

    public static class Milk extends Decorator {

        public Milk(Drink drink) {
            super(drink);
        }
        @Override
        public float cost() {
            return super.cost() + 2;
        }
        @Override
        public String getDescription() {
            return super.getDescription() + " milk";
        }
    }

    public static class Sugar extends Decorator {
        public Sugar(Drink drink) {
            super(drink);
        }
        @Override
        public float cost() {
            return super.cost() + 1;
        }
        @Override
        public String getDescription() {
            return super.getDescription() + " sugar";
        }
    }

}
