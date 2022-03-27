package ro.fasttrackit.temacurs23.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.temacurs23.model.DailyFoodPlanner;
import ro.fasttrackit.temacurs23.model.DaysOfTheWeek;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface DailyFoodPlannerRepository extends JpaRepository<DailyFoodPlanner,Integer> {
    Optional<DailyFoodPlanner> findAllByDays(DaysOfTheWeek day);
    Optional<DailyFoodPlanner> findByDaysIn(List<String> products);

    Optional<DailyFoodPlanner> findAllByDaysAndId(DaysOfTheWeek day, int id);
}
