package com.instagramspringboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.instagramspringboot.dao.InstagramDAOInterface;
import com.instagramspringboot.entity.InstagramUser;

@Service
@Transactional
public class InstagramService implements InstagramServiceInterface {

	@Autowired
	private InstagramDAOInterface iDao;

	@Override
	public int createProfileService(InstagramUser iu) {
		iDao.save(iu);
		return 1;
	}

	public int deleteProfileService(InstagramUser iu) {
		iDao.delete(iu);
		return 1;
	}

	public int editProfileService(InstagramUser iu) {
		iDao.saveAndFlush(iu);
		return 1;
	}

	public InstagramUser viewProfileService(InstagramUser iu) {
		InstagramUser iu1=null;
		Optional<InstagramUser> op =  iDao.findById(iu.getEmail());
		if(op.isPresent()) {
			iu1=op.get();
		}
		return iu1;
	}

	public List<InstagramUser> viewAllProfileService() {
		return iDao.findAll();
	}

	public int loginProfileService(InstagramUser iu) {
		InstagramUser iu1=null;
		int i=0;
		Optional<InstagramUser> op =  iDao.findById(iu.getEmail());
		if(op.isPresent()) {
			iu1=op.get();
			if(iu1.getPassword().equals(iu.getPassword())) {
				i=1;
			}
		}
		return i;
	}

}
