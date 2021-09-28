package com.devproject.tediproject.payload;

public class ExperienceRequest {

    String title;
    String start_date;
    String end_date;
    String company_name;
    Long professional_id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public Long getProfessional_id() {
        return professional_id;
    }

    public void setProfessional_id(Long professional_id) {
        this.professional_id = professional_id;
    }
}
