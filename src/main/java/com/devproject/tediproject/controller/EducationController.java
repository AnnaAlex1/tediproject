package com.devproject.tediproject.controller;

import com.devproject.tediproject.model.Education;
import com.devproject.tediproject.repository.EducationRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EducationController {

    private final EducationRepository repository;

    public EducationController(EducationRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/professionals/{id}/education")
    Education newExperience(@RequestBody Education newEducation, @PathVariable Long id) { return repository.save(newEducation); }

    /*


    @PostMapping("/professionals/{id}/experience")
    Experience newExperience(@RequestBody Experience newExperience, @PathVariable Long id) { return repository.save(newExperience); }

    @PostMapping("/professionals/{id}/experience")
    List<Experience> get_All(@PathVariable Long id) { return repository.findAll(); }


    @PutMapping("/professionals/{id}/experience/{id2}")
    Experience replaceExperience(@RequestBody Experience newExperience, @PathVariable Long id, @PathVariable Long id2){
        return repository.findById(id2)
                .map(experience -> {
                    experience.setCompany_name(newExperience.getCompany_name());
                    experience.setTitle(newExperience.getTitle());
                    experience.setStart_date(newExperience.getStart_date());
                    experience.setEnd_date(newExperience.getEnd_date());
                    return repository.save(experience);
                })
                .orElseGet(() -> {
                    newExperience.setId(id2);
                    return repository.save(newExperience);
                });
    }

    @DeleteMapping("/professionals/{id}/experience/{id2}")
    void deleteExperience(@PathVariable Long id, @PathVariable Long id2) { repository.deleteById(id2);}
     */


}
