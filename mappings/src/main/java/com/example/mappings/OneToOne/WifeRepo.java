package com.example.mappings.OneToOne;

import com.example.mappings.OneToOne.Wife;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WifeRepo extends JpaRepository<Wife, Long> {



}
