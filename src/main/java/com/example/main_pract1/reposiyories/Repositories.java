package com.example.main_pract1.reposiyories;

import com.example.main_pract1.tables.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Repositories extends CrudRepository<Students, Long>, JpaRepository<Students, Long> {
}
