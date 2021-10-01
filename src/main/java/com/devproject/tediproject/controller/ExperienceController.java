package com.devproject.tediproject.controller;

import com.devproject.tediproject.model.Experience;
import com.devproject.tediproject.model.ExperienceId;
import com.devproject.tediproject.model.Professional;
import com.devproject.tediproject.payload.ExperienceRequest;
import com.devproject.tediproject.repository.ExperienceRepository;
import com.devproject.tediproject.repository.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ExperienceController {

    @Autowired
    private ProfessionalRepository profRepository;

    private final ExperienceRepository repository;

    public ExperienceController(ExperienceRepository repository) {
        this.repository = repository;
    }




    @PostMapping("/experiences/add")
    Experience newExperience(@RequestBody ExperienceRequest addExperience) {
        //get professional
        Optional<Professional> res = profRepository.findById(addExperience.getProfessional_id());
        Professional prof = res.get();
        if (prof!=null) {
            prof.setPostList(null);
            prof.setUserNotifications(null);
            prof.setApplications(null);
        }

        Experience newExperience = new Experience(addExperience,prof);
        return repository.save(newExperience);
    }

    @GetMapping("/professionals/{id}/experiences")
    List<Experience> get_All(@PathVariable Long id) {
        return repository.getAllExperience(id);
    }


    @PutMapping("/professionals/{id}/experiences/{id2}")
    Experience replaceExperience(@RequestBody Experience newExperience, @PathVariable Long id, @PathVariable ExperienceId id2){

        return repository.findById(id2)
                .map(experience -> {
                    experience.setStart_date(newExperience.getStart_date());
                    experience.setEnd_date(newExperience.getEnd_date());
                    return repository.save(experience);
                })
                .orElseGet(() -> {
                    return repository.save(newExperience);
                });
    }

    @DeleteMapping("/professionals/{id}/experiences/delete/{id2}")
    void deleteExperience(@PathVariable Long id, @PathVariable ExperienceId id2) { repository.deleteById(id2);}

}
