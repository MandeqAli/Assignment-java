package com.example.tijaabo;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class StaffService {
    private Map<Long, Staff> stafService=new ConcurrentHashMap<>();
    private AtomicLong autoid=new AtomicLong();

    //Reading all staff
    public Collection<Staff> GetAllStaff(){return stafService.values();}

    // get specific staff
    public Staff getStaffById(Long id){
        return stafService.get(id);
    }

    // inserting a new staff
    public Staff insertStaff(Staff newStaff){
        Long StaffId = newStaff.getId() != null
                ? newStaff.getId() : autoid.incrementAndGet();
        newStaff.setId(StaffId);
        stafService.put(StaffId,newStaff);
        return newStaff;
    }

    //updating oldStaff to new Staff
    public Staff updateStaff(Long id , Staff newStaff)
    {
        if(stafService.containsKey(id)){
            Staff oldStaff=getStaffById(id);
            oldStaff.setName(newStaff.getName());
            oldStaff.setPosition(newStaff.getPosition());

            stafService.put(id,oldStaff);

        }
        return null;
    }

    // deleting a staff
    public Staff deleteStaff(Long id){
        return stafService.remove(id);
    }

}
