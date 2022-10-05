package com.example.controller;

import com.example.dto.FacilityDto;
import com.example.model.facility.Facility;
import com.example.model.facility.FacilityType;
import com.example.model.facility.RentType;
import com.example.service.IFacilityService;
import com.example.service.IFacilityTypeService;
import com.example.service.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IFacilityTypeService facilityTypeService;

    @Autowired
    private IRentTypeService rentTypeService;

    @ModelAttribute
    public List<FacilityType> getFacilityType() {
        return facilityTypeService.findAll();
    }

    @ModelAttribute
    public List<RentType> getRentType() {
        return rentTypeService.findAll();
    }

    @GetMapping("/list")
    public String showList(Model model,
                           @PageableDefault(value = 3) Pageable pageable,
                           @RequestParam(defaultValue = "") String name) {
        model.addAttribute("facilityList", facilityService.findALl(pageable, name));
        model.addAttribute("rentType", getRentType());
        model.addAttribute("facilityType", getFacilityType());
        model.addAttribute("name",name);
        return "facility/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("facility",new FacilityDto());
        model.addAttribute("rentType", getRentType());
        model.addAttribute("facilityType", getFacilityType());
        return "facility/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("facility") FacilityDto facilityDto, RedirectAttributes attributes){
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto,facility);

        RentType rentType = new RentType();
        rentType.setId(facilityDto.getRentTypeID());
        facility.setRentTypeID(rentType);

        FacilityType facilityType = new FacilityType();
        facilityType.setId(facilityDto.getFacilityTypeID());
        facility.setFacilityTypeID(facilityType);

        facilityService.save(facility);
        attributes.addFlashAttribute("success","Thêm mới thành công");
        return "redirect:/facility/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id,Model model,FacilityDto facilityDto){
        Optional<Facility> facility = facilityService.findById(id);
        if (facility.isPresent()){
            BeanUtils.copyProperties(facility.get(),facilityDto);
            model.addAttribute("facilityDto",facilityDto);
            model.addAttribute("rentType",getRentType());
            model.addAttribute("facilityType",getFacilityType());
        }
        return "facility/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("facilityDto") FacilityDto facilityDto, RedirectAttributes attributes){
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto,facility);

        RentType rentType = new RentType();
        rentType.setId(facilityDto.getRentTypeID());
        facility.setRentTypeID(rentType);

        FacilityType facilityType = new FacilityType();
        facilityType.setId(facilityDto.getFacilityTypeID());
        facility.setFacilityTypeID(facilityType);

        facilityService.save(facility);
        attributes.addFlashAttribute("success","Cập nhật thành công");
        return "redirect:/facility/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes attributes) {
        facilityService.remove(id);
        attributes.addFlashAttribute("success", "Xóa thành công " +
                facilityService.findById(id).get().getName());
        return "redirect:/facility/list";
    }
}
