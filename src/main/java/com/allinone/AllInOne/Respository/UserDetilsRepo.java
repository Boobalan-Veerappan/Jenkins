package com.allinone.AllInOne.Respository;

import com.allinone.AllInOne.Domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetilsRepo extends CrudRepository<User,Long> {
}
