package com.devproject.tediproject.controller;

import com.devproject.tediproject.model.Experience;
import com.devproject.tediproject.repository.ExperienceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExperienceController {

    private final ExperienceRepository repository;

    public ExperienceController(ExperienceRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/professionals/{id}/experiences")
    Experience newExperience(@RequestBody Experience newExperience, @PathVariable Long id) { return repository.save(newExperience); }

    @GetMapping("/professionals/{id}/experiences")
    List<Experience> get_All(@PathVariable Long id) { return repository.findAll(); }


    @PutMapping("/professionals/{id}/experiences/{id2}")
    Experience replaceExperience(@RequestBody Experience newExperience, @PathVariable Long id, @PathVariable Long id2){
        ProfessionalRepository professionalRepository;

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

    @DeleteMapping("/professionals/{id}/experiences/{id2}")
    void deleteExperience(@PathVariable Long id, @PathVariable Long id2) { repository.deleteById(id2);}

}
