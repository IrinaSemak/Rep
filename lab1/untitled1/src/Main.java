import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Sneakers {
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

    private static class Producer {
        private String name;
        private String country;

        public Producer(String name, String country) {
            this.name = name;
            this.country = country;
        }

        public String getName() {
            return name;
        }

        public String getCountry() {
            return country;
        }
    }

    public static void main(String[] args) {
        Repository<Sneakers> sneakersRepository = new Repository<>();

        // Создание и добавление объектов Sneakers в репозиторий
        sneakersRepository.add(new Sneakers("Nike Air Max", 150.0, "Running", new Producer("Nike", "USA")));
        sneakersRepository.add(new Sneakers("Adidas Superstar", 100.0, "Casual", new Producer("Adidas", "Germany")));
        sneakersRepository.add(new Sneakers("Nike Mercurial", 150.0, "Running", new Producer("Nike", "США")));
        sneakersRepository.add(new Sneakers("Adidas Predator", 140.0, "Casual", new Producer("Adidas", "Германия")));
        sneakersRepository.add(new Sneakers("Nike Air Jordan", 200.0, "Running", new Producer("Nike", "США")));
        sneakersRepository.add(new Sneakers("Adidas Harden", 180.0, "Casual", new Producer("Adidas", "Германия")));
        sneakersRepository.add(new Sneakers("Puma Suede", 80.0, "Casual", new Producer("Puma", "Германия")));
        sneakersRepository.add(new Sneakers("Reebok Classic", 70.0, "Casual", new Producer("Reebok", "США")));
        sneakersRepository.add(new Sneakers("Converse Chuck Taylor", 60.0, "Casual", new Producer("Converse", "США")));
        sneakersRepository.add(new Sneakers("New Balance 574", 90.0, "Running", new Producer("New Balance", "США")));
        sneakersRepository.add(new Sneakers("Asics Gel-Nimbus", 120.0, "Running", new Producer("Asics", "Япония")));
        sneakersRepository.add(new Sneakers("Brooks Ghost", 110.0, "Running", new Producer("Brooks", "США")));

        List<Sneakers> sneakersList = sneakersRepository.getAll();

        // количество производителей
        int numProducers = countProducers(sneakersList);
        System.out.println("Количество производителей: " + numProducers);

        // средняя стоимость кроссовок для каждого производителя
        Map<String, Double> avgCostByProducer = calculateAvgCostByProducer(sneakersList);
        for (Map.Entry<String, Double> entry : avgCostByProducer.entrySet()) {
            System.out.println("Средняя стоимость для производителя " + entry.getKey() + ": " + entry.getValue());
        }

        // Рассчитайте среднюю стоимость кроссовок для каждого типа
        Map<String, Double> avgCostByType = calculateAvgCostByType(sneakersList);
        for (Map.Entry<String, Double> entry : avgCostByType.entrySet()) {
            System.out.println("Средняя стоимость для типа " + entry.getKey() + ": " + entry.getValue());
        }
    }

    private static int countProducers(List<Sneakers> sneakersList) {
        List<String> producers = new ArrayList<>();
        for (Sneakers sneakers : sneakersList) {
            if (!producers.contains(sneakers.producer.name)) {
                producers.add(sneakers.producer.name);
            }
        }
        return producers.size();
    }

    private static Map<String, Double> calculateAvgCostByProducer(List<Sneakers> sneakersList) {
        Map<String, List<Double>> producerCosts = new HashMap<>();
        for (Sneakers sneakers : sneakersList) {
            if (!producerCosts.containsKey(sneakers.producer.name)) {
                producerCosts.put(sneakers.producer.name, new ArrayList<>());
            }
            producerCosts.get(sneakers.producer.name).add(sneakers.cost);
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

    private static Map<String, Double> calculateAvgCostByType(List<Sneakers> sneakersList) {
        Map<String, List<Double>> typeCosts = new HashMap<>();
        for (Sneakers sneakers : sneakersList) {
            if (!typeCosts.containsKey(sneakers.type)) {
                typeCosts.put(sneakers.type, new ArrayList<>());
            }
            typeCosts.get(sneakers.type).add(sneakers.cost);
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
