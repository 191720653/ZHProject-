package com.zehao.timetask;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.web.context.ContextLoader;

public class TimeTask extends QuartzJobBean {

	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		// TODO Auto-generated method stub

		System.out.println("---------- ��ʱ��ִ�ж�ʱ�������� ----------");

		ApplicationContext context = ContextLoader
				.getCurrentWebApplicationContext();
		context.getBean("TestService");

		// ��ȡservice��ʼ����

		System.out.println("---------- ��ʱ�������ִ�н��� ----------");

	}

}
