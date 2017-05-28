package com.simongk.user;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Szymon Gasienica-Kotelnicki on 21.05.17.
 */
public interface UserRepository extends JpaRepository<User,Long>{
    User findByName(String name);
    User findByEmail(String email);
}
