package com.example.bienestarintegral.controller;

import com.example.bienestarintegral.model.instructor;
import com.example.bienestarintegral.service.instructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/instructores")
public class instructorController {

    @Autowired
    private instructorService instructorService;

    @GetMapping
    public List<instructor> getAllInstructores() {
        return instructorService.getAllInstructores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<instructor> getInstructorById(@PathVariable String id) {
        Optional<instructor> instructor = instructorService.getInstructorById(id);
        return instructor.map(ResponseEntity::ok)
                         .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public instructor createInstructor(@RequestBody instructor instructor) {
        return instructorService.createInstructor(instructor);
    }


    @PutMapping("/{id}")
    public ResponseEntity<instructor> updateInstructor(@PathVariable String id, @RequestBody instructor instructorDetails) {
        Optional<instructor> updatedInstructor = instructorService.updateInstructor(id, instructorDetails);
        return updatedInstructor.map(ResponseEntity::ok)
                                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable String id) {
        if (instructorService.deleteInstructor(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
