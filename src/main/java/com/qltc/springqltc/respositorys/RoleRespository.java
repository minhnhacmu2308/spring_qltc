package com.qltc.springqltc.respositorys;

import com.qltc.springqltc.domains.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRespository extends JpaRepository<Role,Integer> {
    @Query("select r.roleName from Role r where r.id = :id")
    List<String> getListRoleName(@Param("id") int id);

    Role findRoleById(int id);
}
