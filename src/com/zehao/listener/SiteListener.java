package com.zehao.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SiteListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
		// ��ȡ��Ŀ·��
		arg0.getServletContext().getRealPath("/");
		
		// ��Ҫ��������
		System.out.println("---------- ���������� ----------");
	}

}
