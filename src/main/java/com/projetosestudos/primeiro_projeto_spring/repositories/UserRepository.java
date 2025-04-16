package com.projetosestudos.primeiro_projeto_spring.repositories;

import com.projetosestudos.primeiro_projeto_spring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
