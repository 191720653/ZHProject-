package com.zehao.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zehao.model.Test;
import com.zehao.service.ITestService;

public class TestAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private ITestService iTestService;

	public void setITestService(ITestService iTestService) {
		this.iTestService = iTestService;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub

		 System.out.println("The size of Table Role is " +
		 iTestService.size());

		// ���Բ���
		Test test = new Test();
		System.out.println("-------------------- add start ------------------------");
		test.setContent("This is a sample test!");
		System.out.println("For testing: add " + test.toString());
		int id = (Integer) iTestService.save(test);
		System.out.println("Add success, the id is " + id);
		System.out.println("The size of table: " + iTestService.getSize());
		System.out.println("-------------------- add end ------------------------");

		// ���Ը���
		System.out.println("-------------------- ���¿�ʼ ------------------------");
		Test temp = iTestService.findById(id);
		temp.setContent("Here for testing update method!");
		iTestService.update(temp);
		temp = iTestService.findById(id);
		System.out.println("Update result: " + temp.toString());
		System.out.println("-------------------- ���½��� ------------------------");

		// ����ɾ��
		System.out.println("-------------------- ɾ����ʼ ------------------------");
		iTestService.delete(id);
		System.out.println("The size of table: " + iTestService.getSize());
		System.out.println("-------------------- ɾ������ ------------------------");

		return SUCCESS;
	}

}
