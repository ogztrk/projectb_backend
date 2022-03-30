package com.badibul.backend.repository;

import com.badibul.backend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    Set<Category> findAllByIdIn(Set<Long> categoryId);

    //List<Category> findByEvents_EventId(Long eventId);
}
