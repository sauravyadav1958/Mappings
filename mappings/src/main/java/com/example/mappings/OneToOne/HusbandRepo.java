package com.example.mappings.OneToOne;

import com.example.mappings.OneToOne.Husband;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HusbandRepo extends JpaRepository<Husband, Long> {

}
