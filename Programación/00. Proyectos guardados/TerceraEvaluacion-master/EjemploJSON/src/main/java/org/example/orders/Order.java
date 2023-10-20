package org.example.orders;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class Order {
        private int id;
        private String orderName;
        private String orderDesc;
        private LocalDate orderCreatedDate;
        private LocalDateTime orderCreatedDateTime;


    public Order(int id, String orderName, String orderDesc, LocalDate orderCreatedDate, LocalDateTime orderCreatedDateTime) {
        this.id = id;
        this.orderName = orderName;
        this.orderDesc = orderDesc;
        this.orderCreatedDate = orderCreatedDate;
        this.orderCreatedDateTime = orderCreatedDateTime;
    }

    public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOrderName() {
            return orderName;
        }

        public void setOrderName(String orderName) {
            this.orderName = orderName;
        }

        public String getOrderDesc() {
            return orderDesc;
        }

        public void setOrderDesc(String orderDesc) {
            this.orderDesc = orderDesc;
        }

        public LocalDate getOrderCreatedDate() {
            return orderCreatedDate;
        }

        public void setOrderCreatedDate(LocalDate orderCreatedDate) {
            this.orderCreatedDate = orderCreatedDate;
        }

        public LocalDateTime getOrderCreatedDateTime() {
            return orderCreatedDateTime;
        }

        public void setOrderCreatedDateTime(LocalDateTime orderCreatedDateTime) {
            this.orderCreatedDateTime = orderCreatedDateTime;
        }

        @Override
        public String toString() {
            return "Order [id=" + id + ", orderName=" + orderName + ", orderDesc=" + orderDesc + ", orderCreatedDate=" +
                    orderCreatedDate + ", orderCreatedDateTime=" + orderCreatedDateTime + "]";
        }
    }