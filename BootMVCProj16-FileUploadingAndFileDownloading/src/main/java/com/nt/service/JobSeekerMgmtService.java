package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nt.entity.JobSeekerInfo;
import com.nt.repository.IJobSeekerRepository;

@Service
public class JobSeekerMgmtService implements IJobSeekerMgmtService {
	@Autowired
	private IJobSeekerRepository jsRepo;

	@Override
	public String registerJobSeeker(JobSeekerInfo info) {
		return "Job Seeker Saved with  " + jsRepo.save(info).getJsId() + " Id value";
	}

	@Override
	public List<JobSeekerInfo> fetchAllJobSeekers() {
		return jsRepo.findAll();
	}

	@Override
	public String fetchResumePathByJsId(Integer jsId) {
		return jsRepo.getResumePathByJsId(jsId);
	}

	@Override
	public String fetchPhotoPathByJsId(Integer jsId) {
		return jsRepo.getPhotoPathByJsId(jsId);
	}
}
