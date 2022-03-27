package ro.fasttrackit.temacurs23.controller;

import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.temacurs23.model.DailyFoodPlanner;
import ro.fasttrackit.temacurs23.model.DaysOfTheWeek;
import ro.fasttrackit.temacurs23.service.DailyFoodPlannerService;

@RestController
@RequestMapping("api/dailyFoodPlanners")
public class DailyFoodPlannerApiController {
    private final DailyFoodPlannerService service;

    public DailyFoodPlannerApiController(DailyFoodPlannerService service) {
        this.service = service;
    }

    @PostMapping
    DailyFoodPlanner addFood(@RequestBody DailyFoodPlanner dailyFoodPlanner) {
        return service.add(dailyFoodPlanner);
    }

    @DeleteMapping("{days}")
    DailyFoodPlanner deleteFood(@PathVariable DaysOfTheWeek days) {
        return service.delete(days)
                .orElse(null);
    }
}

