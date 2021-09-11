package com.devproject.tediproject.controller;

import com.devproject.tediproject.model.Education;
import com.devproject.tediproject.model.EducationId;
import com.devproject.tediproject.repository.EducationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EducationController {

    private final EducationRepository repository;

    public EducationController(EducationRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/professionals/{id}/education/add")
    Education newExperience(@RequestBody Education newEducation, @PathVariable Long id) { return repository.save(newEducation); }

    @GetMapping("/professionals/{id}/education")
    List<Education> get_All(@PathVariable Long id){ return  repository.findByProfessionalId(id); }

    @PutMapping("/professionals/{id}/education/{id2}")
    Education replaceEducation(@RequestBody Education newEducation, @PathVariable Long id, @PathVariable EducationId id2){

        return repository.findById(id2)
                .map(education -> {
                    education.setType(newEducation.getType());
                    education.setTitle(newEducation.getTitle());
                    education.setInstitution_name(newEducation.getInstitution_name());
                    education.setGrade(newEducation.getGrade());
                    education.setDate(newEducation.getDate());
                    education.setProfessional_idProfessional(newEducation.getProfessional_idProfessional());
                    return repository.save(education);
                })
                .orElseGet(() -> {
                    newEducation.setTitle(id2.getTitle());
                    newEducation.setInstitution_name(id2.getInstitution_name());
                    newEducation.setProfessional_idProfessional(id2.getProfessional_idProfessional());
                    return repository.save(newEducation);
                });
    }

    @DeleteMapping("/professionals/{id}/education/delete/{id2}")
    void deleteEducation(@PathVariable Long id, @PathVariable EducationId id2) { repository.deleteById(id2);}


}
