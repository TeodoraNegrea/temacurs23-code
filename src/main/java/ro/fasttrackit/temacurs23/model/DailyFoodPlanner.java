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

        public DailyFoodPlanner(DaysOfTheWeek days, List<String> products) {
            this.products = products;
            this.days=days;
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

    public void setProducts(List<String> products) {
        this.products = products;
    }

    public void setId(int id) {
        this.id = id;
    }
}

