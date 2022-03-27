package ro.fasttrackit.temacurs23.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.temacurs23.model.DailyFoodPlanner;
import ro.fasttrackit.temacurs23.model.DaysOfTheWeek;
import ro.fasttrackit.temacurs23.repository.DailyFoodPlannerRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service
    public class DailyFoodPlannerService {
    private final DailyFoodPlannerRepository repository;

    public DailyFoodPlannerService(DailyFoodPlannerRepository repository) {
        this.repository = repository;
    }

    public Optional<DailyFoodPlanner> getProducts(List<String> products) {
        return repository.findByDaysIn(products);
    }

    public List<String> getProductsInDay(DaysOfTheWeek day) {
        return repository.findAllByDays(day)
                .map(DailyFoodPlanner::getProducts)
                .orElse(List.of());
    }

    public Optional<DailyFoodPlanner> delete(DaysOfTheWeek day, int id) {
        Optional<DailyFoodPlanner> toDelete = repository.findAllByDaysAndId(day, id);
        toDelete.ifPresent(repository::delete);
        return toDelete;
    }

    public Optional<DailyFoodPlanner> add(DaysOfTheWeek days,String product) {
        Optional<DailyFoodPlanner> toAdd=  repository.findByDaysIn(List.of(product));
        toAdd.ifPresent(repository::save);
        return toAdd;



    }
//    public DailyFoodPlanner replace(DaysOfTheWeek days,String products) {
//
//        return repository.save(days,products);
//    }
}
//
//    public DailyFoodPlanner add(String product) {
//
//}



