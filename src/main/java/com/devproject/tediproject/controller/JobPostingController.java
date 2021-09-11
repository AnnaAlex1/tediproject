package com.devproject.tediproject.controller;


import com.devproject.tediproject.model.JobPosting;
import com.devproject.tediproject.repository.JobPostingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobPostingController {

    private final JobPostingRepository repository;

    public JobPostingController(JobPostingRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/jobpostings/add")
    JobPosting newJobPosting(@RequestBody JobPosting newJobPosting) { return repository.save(newJobPosting); }

    @GetMapping("/jobpostings")
    List<JobPosting> get_All() { return repository.findAll(); }



    @PutMapping("/jobpostings/{id}")
    JobPosting replaceJobPosting(@RequestBody JobPosting newJobPosting, @PathVariable Long id){
        return repository.findById(id)
                .map( jobPosting -> {
                    jobPosting.setContent(newJobPosting.getContent());
                    return repository.save(jobPosting);
                })
                .orElseGet( () -> {
                    newJobPosting.setIdJobPosting(id);
                    return repository.save((newJobPosting));
                });
    }

    @DeleteMapping("/jobpostings/delete/{id}")
    void deleteJobPosting(@PathVariable Long id) { repository.deleteById(id);}

}
