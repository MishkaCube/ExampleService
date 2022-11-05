package com.devcloudy.exampleservice.controllers;

import com.devcloudy.exampleservice.service.AdminService;
import com.devcloudy.exampleservice.user.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/updateRole")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String createAdmin(@RequestParam(required = true) String username,
                              @RequestParam UserRole role) {
        adminService.updateRole(username, role);
        return "User is updated";
    }
}
