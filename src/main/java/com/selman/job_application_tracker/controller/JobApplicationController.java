package com.selman.job_application_tracker.controller;


import com.selman.job_application_tracker.model.JobApplication;
import com.selman.job_application_tracker.service.JobApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "*") // Frontend başka porttan erişecekse
public class JobApplicationController {

    private final JobApplicationService service;

    public JobApplicationController(JobApplicationService service){
        this.service = service;
    }

    // Tüm başvuruları getir
    @GetMapping
    public List<JobApplication> getAll() {
        return service.getAll();
    }

    // ID ile tek başvuru getir
    @GetMapping("/{id}")
    public JobApplication getById(@PathVariable Long id) {
        return service.getById(id).orElse(null);
    }

    // Yeni başvuru ekle
    @PostMapping
    public JobApplication create(@RequestBody JobApplication app) {
        return service.save(app);
    }

    // Başvuruyu güncelle
    @PutMapping("/{id}")
    public JobApplication update(@PathVariable Long id, @RequestBody JobApplication app) {
        app.setId(id);
        return service.save(app);
    }

    // Başvuruyu sil
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
