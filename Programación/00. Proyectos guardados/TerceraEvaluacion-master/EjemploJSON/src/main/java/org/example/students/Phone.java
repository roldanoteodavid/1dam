package org.example.students;

public class Phone {
        private long phoneId;
        private String phoneType;
        private String phoneNumber;

        public Phone() {}

        public Phone(String phoneType, String phoneNumber) {
            this.phoneType = phoneType;
            this.phoneNumber = phoneNumber;
        }

    public Phone(long phoneId, String phoneType, String phoneNumber) {
        this.phoneId = phoneId;
        this.phoneType = phoneType;
        this.phoneNumber = phoneNumber;
    }

    public long getPhoneId() {
            return phoneId;
        }

        public void setPhoneId(long phoneId) {
            this.phoneId = phoneId;
        }

        public String getPhoneType() {
            return phoneType;
        }

        public void setPhoneType(String phoneType) {
            this.phoneType = phoneType;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

    @Override
    public String toString() {
        return "Phone{" +
                "phoneId=" + phoneId +
                ", phoneType='" + phoneType + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

