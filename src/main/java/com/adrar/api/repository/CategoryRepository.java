package com.adrar.api.repository;

import com.adrar.api.model.Category;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {
    boolean existsByName(@NotNull String name);
}
