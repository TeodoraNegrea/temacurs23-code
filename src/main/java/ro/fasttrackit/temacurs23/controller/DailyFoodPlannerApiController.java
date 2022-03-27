package ro.fasttrackit.temacurs23.controller;

import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.temacurs23.model.DailyFoodPlanner;
import ro.fasttrackit.temacurs23.model.DaysOfTheWeek;
import ro.fasttrackit.temacurs23.service.DailyFoodPlannerService;

import java.util.Optional;

@RestController
@RequestMapping("api/dailyFoodPlanners")
public class DailyFoodPlannerApiController {
    private final DailyFoodPlannerService service;

    public DailyFoodPlannerApiController(DailyFoodPlannerService service) {
        this.service = service;
    }

    @PostMapping("{days}")
    Optional<DailyFoodPlanner> addFood(@PathVariable DaysOfTheWeek days, @PathVariable String product) {
        return service.add(days,product);



    }
//    @PutMapping("{days}")
//    DailyFoodPlanner replaceDailyFoodPlanner(@PathVariable DaysOfTheWeek days,@PathVariable String products) {
//        return service.replace(days,products);
//    }

    @DeleteMapping("{day}/{id}")
    Optional<DailyFoodPlanner> deleteFood(@PathVariable DaysOfTheWeek day,@PathVariable int id) {
        return service.delete(day, id);

    }
}

