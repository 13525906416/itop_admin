package org.example.itop_admin.mapper;

import jakarta.transaction.Transactional;
import org.example.itop_admin.entity.AppUser;
import org.example.itop_admin.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @ClassName ClientMapper
 * @Author zhaoyb
 * @Date 2024-05-17
 * @Version 1.0
 */

@Repository
public interface ClientMapper extends JpaRepository<Client,Integer> {
    Optional<Client> findByClientId(String clientId);

    @Modifying
    @Transactional
    @Query(nativeQuery=true, value="delete from  client where client_id =? ")
    int deleteByClientId(String clientId);


}
