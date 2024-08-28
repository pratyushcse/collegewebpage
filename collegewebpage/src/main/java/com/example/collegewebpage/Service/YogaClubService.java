package com.example.collegewebpage.Service;

import com.example.collegewebpage.Model.YogaClub;
import com.example.collegewebpage.Repository.YogaClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class YogaClubService {

    @Autowired
    private YogaClubRepository yogaClubRepository;

    public List<YogaClub> getAllEvents() {
        return yogaClubRepository.findAll();
    }

    public Optional<YogaClub> getEventById(Long id) {
        return yogaClubRepository.findById(id);
    }

    public YogaClub createEvent(YogaClub yogaClub) {
        return yogaClubRepository.save(yogaClub);
    }

    public YogaClub updateEvent(Long id, YogaClub yogaClub) {
        if (yogaClubRepository.existsById(id)) {
            yogaClub.setId(id);
            return yogaClubRepository.save(yogaClub);
        }
        return null;
    }

    public void deleteEvent(Long id) {
        yogaClubRepository.deleteById(id);
    }
}
