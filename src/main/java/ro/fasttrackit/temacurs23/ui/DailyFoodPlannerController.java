package ro.fasttrackit.temacurs23.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ro.fasttrackit.temacurs23.model.DailyFoodPlanner;
import ro.fasttrackit.temacurs23.model.DaysOfTheWeek;
import ro.fasttrackit.temacurs23.service.DailyFoodPlannerService;




@Controller
    @RequestMapping("dailyFoodPlanners")
    public class DailyFoodPlannerController {
        private final DailyFoodPlannerService service;

        public DailyFoodPlannerController(DailyFoodPlannerService service){
            this.service = service;
        }
        @GetMapping
        String getFoodPage(Model model, @RequestParam(required = false) DaysOfTheWeek showDay){
            if (showDay != null) {
                model.addAttribute("productsList", service.getProductsInDay(showDay));
            }
            return "dailyFoodPlanners";
        }
    }
