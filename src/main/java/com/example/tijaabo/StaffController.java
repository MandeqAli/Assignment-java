package com.example.tijaabo;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/staff/")
public class StaffController {
    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }
    //getting all staff
    @GetMapping("all")
    public Collection<Staff> getAllStaff(){
        return staffService.GetAllStaff();
    }

    //geting one staff
    @GetMapping("{id}")
    public Staff getStaff(@PathVariable Long id){
        return staffService.getStaffById(id);
    }

    // inserting a new staff
    @PostMapping("/staf")
    public Staff insertStaff(@RequestBody Staff newStaff){
        return staffService.insertStaff(newStaff);
    }

    //updating staff
    @PutMapping("{id}")
    public Staff updateStaff(@PathVariable Long id, @RequestBody Staff newStaff){
        return staffService.updateStaff(id, newStaff);
    }

    //deleting a staff
    @DeleteMapping("{id}")
    public Staff deleteStaff(@PathVariable Long id){
        return  staffService.deleteStaff(id);
    }

}
