package com.badibul.backend.repository;

import com.badibul.backend.entity.Events;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventsRepository extends JpaRepository<Events,Long> {
   List<Events> findByUserIdAndCategoryId(Long userId, Long categoryId);

    List<Events> findByUserId(Long userId);

    List<Events> findByCategoryId(Long categoryId);

}
