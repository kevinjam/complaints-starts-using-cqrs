package com.kevinjanvier.democomplaints.starts;


public class ComplainFileEvent {
    private final String id;
    private final String description;
    private final String company;

    public ComplainFileEvent(String id, String company, String description) {
        this.id = id;
        this.company = company;
        this.description = description;
    }



    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }


    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "ComplainFileEvent{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
