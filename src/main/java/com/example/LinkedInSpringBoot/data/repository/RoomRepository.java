package com.example.LinkedInSpringBoot.data.repository;

import com.example.LinkedInSpringBoot.data.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
}
