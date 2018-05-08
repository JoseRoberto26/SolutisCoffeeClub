package com.jose.solutis.server.data;

import com.jose.solutis.server.models.CapsulaCafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface CapsulaRepository extends JpaRepository <CapsulaCafe, Long> {

}
