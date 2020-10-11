package com.koalmine.curriculumvitae.dao;

import com.koalmine.curriculumvitae.constants.Page;
import com.koalmine.curriculumvitae.model.dto.Footer;

public interface FooterDao {
    public Footer getFooterInformation(Page pageName);
}
