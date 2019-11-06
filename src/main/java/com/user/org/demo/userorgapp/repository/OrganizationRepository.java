package com.user.org.demo.userorgapp.repository;

import com.user.org.demo.userorgapp.entity.Organization;
import org.springframework.data.repository.CrudRepository;

public interface OrganizationRepository extends CrudRepository<Organization, Integer> {
}
