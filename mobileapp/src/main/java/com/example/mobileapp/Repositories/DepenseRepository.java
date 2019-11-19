
package com.example.mobileapp.Repositories;

import java.util.List;
import com.example.mobileapp.Models.*;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepenseRepository extends JpaRepository<Depense, Long> {

}
