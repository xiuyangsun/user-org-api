package com.user.org.demo.userorgapp.rest;

import com.user.org.demo.userorgapp.DTO.request.OrganizationReq;
import com.user.org.demo.userorgapp.DTO.response.OrganizationRes;
import com.user.org.demo.userorgapp.DTO.response.SuccessRes;
import com.user.org.demo.userorgapp.entity.Organization;
import com.user.org.demo.userorgapp.service.OrgService;
import com.user.org.demo.userorgapp.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api/organizations")
public class OrganizationRestController {
    @Autowired
    private OrgService orgService;
    /*
     * CRUD function end points for organizations
     */

    // expose "/organizations" and return list of organizations

    @GetMapping
    public ResponseEntity<List<OrganizationRes>> findAllOrganizations() {

        List<Organization> orgs = orgService.findAllOrganizations();
        List<OrganizationRes> res = Mapper.mapAll(orgs, OrganizationRes.class);

        return ResponseEntity.ok(res);
    }

    // expose "/organizations/{organizationId} and return single organization using
    // Id

    @GetMapping("/{organizationId}")
    public ResponseEntity<OrganizationRes> getOrganization(@PathVariable @Positive int organizationId) {

        Organization theOrganization = orgService.findOrgById(organizationId);

        OrganizationRes res = Mapper.map(theOrganization, OrganizationRes.class);

        return ResponseEntity.ok(res);
    }

    // expose "/organizations" for POST to add new organization;

    @PostMapping
    public ResponseEntity<OrganizationRes> addOrganization(@RequestBody @Valid OrganizationReq orgReq) {

        Organization data = Mapper.map(orgReq, Organization.class);

        orgService.saveOrg(data);

        OrganizationRes res = Mapper.map(data, OrganizationRes.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    // expose "/organizations" for PUT to update organization;

    @PutMapping("/{orgId}")
    public ResponseEntity<OrganizationRes> updateOrganization(@RequestBody @Valid OrganizationReq orgReq, @PathVariable @Positive int orgId) {

        Organization org = orgService.findOrgById(orgId);

        org.setName(orgReq.getName());
        org.setAddress(orgReq.getAddress());
        org.setPhone(orgReq.getPhone());

        orgService.saveOrg(org);

        OrganizationRes res = Mapper.map(org, OrganizationRes.class);

        return ResponseEntity.ok(res);
    }

    // expose "/organizations/{organizationId}" to delete an existing organization;

    @DeleteMapping("/{orgId}")
    public ResponseEntity<SuccessRes> deleteOrganization(@PathVariable @Positive int orgId) {
        // Validate organization existence
        orgService.findOrgById(orgId);

        orgService.deleteOrgById(orgId);

        SuccessRes successRes = new SuccessRes();
        successRes.setMessage(String.format("Organization with id - %s deleted successfully!", orgId));

        return ResponseEntity.ok(successRes);
    }

}
