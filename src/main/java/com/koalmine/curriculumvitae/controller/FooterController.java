package com.koalmine.curriculumvitae.controller;

import com.koalmine.curriculumvitae.constants.Page;
import com.koalmine.curriculumvitae.exceptions.FooterTypeException;
import com.koalmine.curriculumvitae.model.dto.Footer;
import com.koalmine.curriculumvitae.service.FooterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/footer")
public class FooterController {

    private final FooterService footerService;

    @Autowired
    public FooterController(FooterService footerService) {
        this.footerService = footerService;
    }

    @GetMapping
    public Footer getFooterInformation(@RequestParam String pageName){

        if (Page.home.matches(pageName)){
            Page page = Page.valueOf(pageName);
            return footerService.getFooterInformation(page);
        }

        throw new FooterTypeException(pageName);
    }
}
