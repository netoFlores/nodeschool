package org.nodeschool.demo.Demo1.repository;

import org.nodeschool.demo.Demo1.models.Escritor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EscritorRepository extends JpaRepository<Escritor, Integer> {
}
