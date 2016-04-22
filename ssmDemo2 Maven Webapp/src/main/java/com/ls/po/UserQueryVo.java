package com.ls.po;

import java.util.List;

import javax.validation.constraints.NotNull;

public class UserQueryVo {
	
	@NotNull(message="{userQueryVo.userCustomers.isNULL}")
	List<UserCustomer> userCustomers;

	public List<UserCustomer> getUserCustomers() {
		return userCustomers;
	}

	public void setUserCustomers(List<UserCustomer> userCustomers) {
		this.userCustomers = userCustomers;
	}
}
