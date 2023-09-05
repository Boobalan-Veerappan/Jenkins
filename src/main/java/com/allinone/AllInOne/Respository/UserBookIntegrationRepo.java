package com.allinone.AllInOne.Respository;

import com.allinone.AllInOne.Domain.UserBookId;
import com.allinone.AllInOne.Domain.UserBookIntegraion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBookIntegrationRepo extends JpaRepository<UserBookIntegraion, UserBookId> {

}
