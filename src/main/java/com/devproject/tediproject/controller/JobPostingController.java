package com.devproject.tediproject.controller;


import com.devproject.tediproject.model.Content;
import com.devproject.tediproject.model.JobPosting;
import com.devproject.tediproject.model.Professional;
import com.devproject.tediproject.payload.JobPostingAddRequest;
import com.devproject.tediproject.repository.ContentRepository;
import com.devproject.tediproject.repository.JobPostingRepository;
import com.devproject.tediproject.repository.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class JobPostingController {

    private final JobPostingRepository repository;

    @Autowired
    private ProfessionalRepository profRepository;

    @Autowired
    private ContentRepository contentRepository;

    public JobPostingController(JobPostingRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/jobpostings")
    List<JobPosting> get_All() { return repository.findAll(); }


    ////
    @PostMapping("/jobpostings/add")
    JobPosting newJobPosting(@RequestBody JobPostingAddRequest newJobPostingReq) {

        Optional<Professional> res = profRepository.findById(newJobPostingReq.getProfessional_id());
        Professional prof = res.get();

        //create new post //set professional
        JobPosting newJobPosting = new JobPosting(prof);
        repository.save(newJobPosting); //add post in database

        //create list of content
        List<Content> newContent = new ArrayList<Content>();;
        for (int i=0; i<newJobPostingReq.getContentAdd().size(); i++){
            newContent.add(new Content(newJobPostingReq.getContentAdd().get(i).getType(),
                    newJobPostingReq.getContentAdd().get(i).getPath(), newJobPosting) );
        }

        // for new jobPost
        newJobPosting.setContent(newContent); //set content of new post
        repository.save(newJobPosting); //add post in database

        //add content to array of contents
        for (int i=0; i<newContent.size(); i++) {
            contentRepository.save(newContent.get(i));
        }


        return repository.save(newJobPosting);
    }

    @GetMapping("/jobpostings/{profId}/friends")
    List<JobPosting> getJobPostingsByFriends(@PathVariable String profId){
        return repository.getJobPostingsByFriends(Long.parseLong(profId));
    }

    @GetMapping("/jobpostings/{profId}/nonfriends")
    List<JobPosting> getJobPostingsByNonFriends(@PathVariable String profId){
        return repository.getJobPostingsByNonFriends(Long.parseLong(profId));
    }

    @GetMapping("/jobpostings/{profId}")
    List<JobPosting> getMyJobPostings(@PathVariable String profId){
        return repository.getMyJobPostings(Long.parseLong(profId));
    }

    @PostMapping("/jobpostings/{jobPostId}/interested/{profId}")
    JobPosting addInterestInJobPost(@PathVariable Long jobPostId, @PathVariable Long profId){
        Optional<Professional> res = profRepository.findById(profId);
        Professional prof = res.get();

        Optional<JobPosting> res2 = repository.findById(jobPostId);
        JobPosting jobPosting = res2.get();

        jobPosting.addNewInterested(prof);  //add interested professional in list of interested
        prof.addNewApplication(jobPosting); //add jobPosting in list of applications

        profRepository.save(prof);
        return repository.save(jobPosting);
    }

    @GetMapping("/jobpostings/{jobPostId}/interested")
    List<Professional> getJobPostingInterested(@PathVariable Long jobPostId){
        Optional<JobPosting> res = repository.findById(jobPostId);
        JobPosting jobPosting = res.get();
        return jobPosting.getInterested();
    }
    ///

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
    void deleteJobPosting(@PathVariable Long id) {
        contentRepository.deleteByJobPostingId(id);
        repository.deleteById(id);
    }

}
