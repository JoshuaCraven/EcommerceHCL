package com.josh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.josh.model.UserCart;
import com.josh.model.UserCartId;

@Repository
public interface UserCartRepository extends JpaRepository<UserCart, UserCartId>{

}
