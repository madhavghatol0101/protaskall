package com.infy.protaskresourceentityfilieuploding121.app.servicei;

import java.util.List;

import com.infy.protaskresourceentityfilieuploding121.app.Model.Applicant;

public interface Servicei {

	public Applicant saveapp(Applicant ac);

	public List<Applicant> getData();

	public void deleteApp(int applicantId);


}
