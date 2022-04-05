package com.alexeykuznetsov.currency.repository;

import com.alexeykuznetsov.currency.model.Role;
import com.alexeykuznetsov.currency.model.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(UserRoleEnum roleEnum);
}
