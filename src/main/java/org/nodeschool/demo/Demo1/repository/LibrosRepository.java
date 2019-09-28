package org.nodeschool.demo.Demo1.repository;

import org.nodeschool.demo.Demo1.models.Libros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrosRepository extends JpaRepository<Libros, Integer> {
}
