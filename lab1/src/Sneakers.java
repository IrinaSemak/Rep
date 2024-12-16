import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Sneakers {
    private String model;
    private double price;
    private String type;
    private Producer producer;

    public Sneakers(String model, double price, String type, Producer producer) {
        this.model = model;
        this.price = price;
        this.type = type;
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public Producer getProducer() {
        return producer;
    }

    @Override
    public String toString() {
        return "Модель: " + model + ", Цена: " + price + ", Тип: " + type + ", Производитель: " + producer;
    }

    public static int countProducers(List<Sneakers> sneakersList) {
        return (int) sneakersList.stream()
                .map(s -> s.getProducer().getName())
                .distinct()
                .count();
    }

    public static Map<String, Double> calculateAvgCostByProducer(List<Sneakers> sneakersList) {
        return sneakersList.stream()
                .collect(Collectors.groupingBy(
                        s -> s.getProducer().getName(),
                        Collectors.averagingDouble(Sneakers::getPrice)
                ));
    }

    public static Map<String, Double> calculateAvgCostByType(List<Sneakers> sneakersList) {
        return sneakersList.stream()
                .collect(Collectors.groupingBy(
                        Sneakers::getType,
                        Collectors.averagingDouble(Sneakers::getPrice)
                ));
    }
}