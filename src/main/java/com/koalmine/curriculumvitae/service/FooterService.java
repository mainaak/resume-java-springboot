package com.koalmine.curriculumvitae.service;

import com.koalmine.curriculumvitae.constants.Page;
import com.koalmine.curriculumvitae.dao.FooterDao;
import com.koalmine.curriculumvitae.model.dto.Footer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FooterService {

    private final FooterDao footerDao;

    @Autowired
    public FooterService(@Qualifier("Database-Fake") FooterDao footerDao) {
        this.footerDao = footerDao;
    }

    public Footer getFooterInformation(Page pageName){
        return footerDao.getFooterInformation(pageName);
    }
}
