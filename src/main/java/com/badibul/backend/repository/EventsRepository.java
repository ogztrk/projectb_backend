package com.badibul.backend.repository;

import com.badibul.backend.entity.Events;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventsRepository extends JpaRepository<Events,Long> {
   // List<Events> findByUserIdAndCategoryId(Long userId, Long categoryId);

    List<Events> findByUserId(Long userId);
//duruma gore burada Query annotation'ı ile query yazılabilir...
  //  List<Events> findByCategoryId(Long categoryId);
}
