public class Phone {
    private String number;
    private String model;
    private double weight;

    public Phone() {
    }

    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }

    public Phone(String number, String model, double weight) {
        this(number, model);
        this.weight = weight;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void receiveCall(String name) {
        System.out.println("Звонит " + name);
    }

    public void receiveCall(String name, String callerNumber) {
        System.out.println("Звонит " + name + " с номера " + callerNumber);
    }

    public void sendMessage(String... numbers) {
        System.out.println("Отправка сообщения на номера:");
        for (String num : numbers) {
            System.out.println(num);
        }
    }

    @Override
    public String toString() {
        return "Phone{" +
                "number='" + number + '\'' +
                ", model='" + model + '\'' +
                ", weight=" + weight +
                '}';
    }

    public static void main(String[] args) {
        Phone phone1 = new Phone("+375294750285", "Honor 20 Pro", 0.3);
        Phone phone2 = new Phone("+375297654321", "iPhone 12");
        Phone phone3 = new Phone();

        phone3.setNumber("+375291234567");
        phone3.setModel("Samsung Galaxy S21");
        phone3.setWeight(0.25);

        System.out.println(phone1);
        System.out.println(phone2);
        System.out.println(phone3);

        phone1.receiveCall("Alice");
        System.out.println("Номер телефона: " + phone1.getNumber());

        phone2.receiveCall("Bob");
        System.out.println("Номер телефона: " + phone2.getNumber());

        phone3.receiveCall("Charlie");
        System.out.println("Номер телефона: " + phone3.getNumber());

        phone1.receiveCall("Alice", "+375294750285");

        phone1.sendMessage("+375294750285", "+375297654321", "+375291234567");
    }
}
