package com.example.collegewebpage.Repository;

import com.example.collegewebpage.Model.YogaClub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YogaClubRepository extends JpaRepository<YogaClub, Long> {
}
