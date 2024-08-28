package com.example.collegewebpage.Controller;

import com.example.collegewebpage.Model.YogaClub;
import com.example.collegewebpage.Service.YogaClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="http://localhost:5173")
@RestController
@RequestMapping("/api/yogaclub")
public class YogaClubController {

    @Autowired
    private YogaClubService yogaClubService;

    @GetMapping("/events")
    public List<YogaClub> getAllEvents() {
        return yogaClubService.getAllEvents();
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<YogaClub> getEventById(@PathVariable Long id) {
        Optional<YogaClub> yogaClub = yogaClubService.getEventById(id);
        if (yogaClub.isPresent()) {
            return ResponseEntity.ok(yogaClub.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/events")
    public YogaClub createEvent(@RequestBody YogaClub yogaClub) {
        return yogaClubService.createEvent(yogaClub);
    }

    @PutMapping("/events/{id}")
    public ResponseEntity<YogaClub> updateEvent(@PathVariable Long id, @RequestBody YogaClub yogaClub) {
        YogaClub updatedYogaClub = yogaClubService.updateEvent(id, yogaClub);
        if (updatedYogaClub != null) {
            return ResponseEntity.ok(updatedYogaClub);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/events/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        yogaClubService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }
}
