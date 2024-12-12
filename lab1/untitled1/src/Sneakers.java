import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sneakers {
    private String name;
    private double cost;
    private String type;
    private Producer producer;

    public Sneakers(String name, double cost, String type, Producer producer) {
        this.name = name;
        this.cost = cost;
        this.type = type;
        this.producer = producer;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public String getType() {
        return type;
    }

    public Producer getProducer() {
        return producer;
    }

    // Static utility methods
    public static int countProducers(List<Sneakers> sneakersList) {
        List<String> producers = new ArrayList<>();
        for (Sneakers sneakers : sneakersList) {
            if (!producers.contains(sneakers.getProducer().getName())) {
                producers.add(sneakers.getProducer().getName());
            }
        }
        return producers.size();
    }

    public static Map<String, Double> calculateAvgCostByProducer(List<Sneakers> sneakersList) {
        Map<String, List<Double>> producerCosts = new HashMap<>();
        for (Sneakers sneakers : sneakersList) {
            if (!producerCosts.containsKey(sneakers.getProducer().getName())) {
                producerCosts.put(sneakers.getProducer().getName(), new ArrayList<>());
            }
            producerCosts.get(sneakers.getProducer().getName()).add(sneakers.getCost());
        }

        Map<String, Double> avgCostByProducer = new HashMap<>();
        for (Map.Entry<String, List<Double>> entry : producerCosts.entrySet()) {
            double sum = 0;
            for (Double cost : entry.getValue()) {
                sum += cost;
            }
            avgCostByProducer.put(entry.getKey(), sum / entry.getValue().size());
        }
        return avgCostByProducer;
    }

    public static Map<String, Double> calculateAvgCostByType(List<Sneakers> sneakersList) {
        Map<String, List<Double>> typeCosts = new HashMap<>();
        for (Sneakers sneakers : sneakersList) {
            if (!typeCosts.containsKey(sneakers.getType())) {
                typeCosts.put(sneakers.getType(), new ArrayList<>());
            }
            typeCosts.get(sneakers.getType()).add(sneakers.getCost());
        }

        Map<String, Double> avgCostByType = new HashMap<>();
        for (Map.Entry<String, List<Double>> entry : typeCosts.entrySet()) {
            double sum = 0;
            for (Double cost : entry.getValue()) {
                sum += cost;
            }
            avgCostByType.put(entry.getKey(), sum / entry.getValue().size());
        }
        return avgCostByType;
    }
}
