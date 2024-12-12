import java.util.List;
import java.util.Map;

public class Main {
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

        // Количество производителей
        int numProducers = Sneakers.countProducers(sneakersList);
        System.out.println("Количество производителей: " + numProducers);

        // Средняя стоимость кроссовок для каждого производителя
        Map<String, Double> avgCostByProducer = Sneakers.calculateAvgCostByProducer(sneakersList);
        for (Map.Entry<String, Double> entry : avgCostByProducer.entrySet()) {
            System.out.println("Средняя стоимость для производителя " + entry.getKey() + ": " + entry.getValue());
        }

        // Рассчитайте среднюю стоимость кроссовок для каждого типа
        Map<String, Double> avgCostByType = Sneakers.calculateAvgCostByType(sneakersList);
        for (Map.Entry<String, Double> entry : avgCostByType.entrySet()) {
            System.out.println("Средняя стоимость для типа " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
