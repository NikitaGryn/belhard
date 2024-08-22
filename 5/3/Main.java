public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("Apple", 1.5, 4.8);
        Product product2 = new Product("Banana", 1.2, 4.5);
        Product product3 = new Product("Orange", 2.0, 4.7);
        Product product4 = new Product("Milk", 1.8, 4.9);
        Product product5 = new Product("Cheese", 5.0, 4.6);

        Category fruits = new Category("Fruits", new Product[]{product1, product2, product3});
        Category dairy = new Category("Dairy", new Product[]{product4, product5});

        System.out.println("Каталог продуктов:");
        System.out.println(fruits);
        System.out.println(dairy);

        User user1 = new User("user1", "pass1");
        User user2 = new User("user2", "pass2");

        user1.getBasket().addProduct(product1);
        user1.getBasket().addProduct(product4);

        user2.getBasket().addProduct(product2);
        user2.getBasket().addProduct(product5);

        System.out.println("\nПокупки пользователей:");
        System.out.println(user1.getLogin() + " купил: " + user1.getBasket());
        System.out.println(user2.getLogin() + " купил: " + user2.getBasket());
    }
}
