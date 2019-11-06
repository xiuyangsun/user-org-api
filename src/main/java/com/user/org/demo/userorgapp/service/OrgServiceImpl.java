package com.user.org.demo.userorgapp.service;

import com.user.org.demo.userorgapp.entity.Organization;
import com.user.org.demo.userorgapp.repository.OrganizationRepository;
import com.user.org.demo.userorgapp.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class OrgServiceImpl implements OrgService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public List<Organization> findAllOrganizations() {

        Iterable<Organization> organizationsI = organizationRepository.findAll();
        List<Organization> organizations = Mapper.mapAll(organizationsI, Organization.class);

        return organizations;
    }

    @Override
    public Organization findOrgById(int theId) {

        Organization organization = organizationRepository.findById(theId).orElse(null);
        if (organization == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Organization id not found -" + theId);
        }
        return organization;
    }

    @Override
    public void saveOrg(Organization theOrganization) {

        organizationRepository.save(theOrganization);
    }

    @Override
    public void deleteOrgById(int theId) {

        organizationRepository.deleteById(theId);
    }

}
