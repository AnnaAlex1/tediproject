package com.devproject.tediproject.controller;

import com.devproject.tediproject.model.Education;
import com.devproject.tediproject.model.EducationId;
import com.devproject.tediproject.model.Professional;
import com.devproject.tediproject.payload.EducationRequest;
import com.devproject.tediproject.repository.EducationRepository;
import com.devproject.tediproject.repository.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class EducationController {

    @Autowired
    private ProfessionalRepository profRepository;

    private final EducationRepository repository;

    public EducationController(EducationRepository repository, ProfessionalRepository profRepository) {
        this.repository = repository;
        this.profRepository = profRepository;
    }

    @PostMapping("/professionals/{id}/education/add")
    Education newEducation(@RequestBody EducationRequest newEducationReq, @PathVariable Long id) {

        //get professional
        Optional<Professional> res = profRepository.findById(id);
        Professional prof = res.get();
        if (prof!=null) {
            prof.setPostList(null);
            prof.setUserNotifications(null);
            prof.setApplications(null);
        }

        Education addEducation =  new Education(newEducationReq,prof);
        return repository.save(addEducation);

    }


    @GetMapping("/professionals/{id}/education")
    List<Education> get_All(@PathVariable Long id){
        return repository.getAllEducations(id);
    }

    @PutMapping("/professionals/{id}/education/{id2}")
    Education replaceEducation(@RequestBody Education newEducation, @PathVariable Long id, @PathVariable EducationId id2){

        return repository.findById(id2)
                .map(education -> {
                    education.setType(newEducation.getType());
                    education.setGrade(newEducation.getGrade());
                    education.setDate(newEducation.getDate());
                    return repository.save(education);
                })
                .orElseGet(() -> {
                    return repository.save(newEducation);
                });
    }

    @DeleteMapping("/professionals/{id}/education/delete/{id2}")
    void deleteEducation(@PathVariable Long id, @PathVariable EducationId id2) { repository.deleteById(id2);}


}
