package com.example.Oauthserver.repository;


import com.example.Oauthserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>
{

    User findByEmail( String email );
}
