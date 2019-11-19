
package com.example.mobileapp.Repositories;

import java.util.List;
import com.example.mobileapp.Models.*;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
  @Query("select p from Users_roles p where  p.username = :usr and p.role =:role ")
  public Users_roles Rechercheruser(@Param("usr") String username, @Param("role") String role);

}
