package ro.fasttrackit.temacurs23.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.temacurs23.model.DailyFoodPlanner;
import ro.fasttrackit.temacurs23.model.DaysOfTheWeek;
import ro.fasttrackit.temacurs23.repository.DailyFoodPlannerRepository;

import java.util.List;
import java.util.Optional;


@Service
    public class DailyFoodPlannerService {
        private final DailyFoodPlannerRepository repository;

        public DailyFoodPlannerService(DailyFoodPlannerRepository repository){
            this.repository = repository;
        }
        public List<DailyFoodPlanner> getAll(){
            return repository.findAll();
        }
    public Optional<DailyFoodPlanner> getProductsInDay(DaysOfTheWeek day) {
        return repository.findAllByDays(day);
    }

    public Optional<DailyFoodPlanner> delete(DaysOfTheWeek day) {
        Optional<DailyFoodPlanner> toDelete = repository.findAllByDays(day);
        toDelete.ifPresent(repository::delete);
        return toDelete;
    }

    public DailyFoodPlanner add(DailyFoodPlanner dailyFoodPlanner) {
        return repository.save(dailyFoodPlanner);
    }
    }

