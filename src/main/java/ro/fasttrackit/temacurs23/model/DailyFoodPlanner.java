package ro.fasttrackit.temacurs23.model;

import javax.persistence.*;
import java.util.List;

@Entity
    public class DailyFoodPlanner {
        @Id
        @GeneratedValue
        private int id;
        @Enumerated(EnumType.STRING)
        private DaysOfTheWeek days;
    @ElementCollection(targetClass = String.class)
        private List<String> products;


        public DailyFoodPlanner() {
        }

        public DailyFoodPlanner(List<String> products) {
            this.products = products;
        }

        public int getId() {
            return id;
        }
    public DaysOfTheWeek getDays() {
        return days;
    }

    public List<String> getProducts() {
            return products;
        }
    public void setDays(DaysOfTheWeek days) {
        this.days = days;
    }
}
