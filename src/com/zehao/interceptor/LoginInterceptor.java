package com.zehao.interceptor;

import java.util.Map;


import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.zehao.action.TestAction;
import com.zehao.constant.CONSTANT;

public class LoginInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		System.out.println("---------- ���ǵ�¼������ ----------");
		
		// ��ȡ����
		String url = ServletActionContext.getRequest().getRequestURL().toString();
		((Map<String, Object>)ActionContext.getContext().get("request")).put(CONSTANT.DOMAIN_SIGN, url.split("/")[2]);
		System.out.println("---------- ����"+url+"վ�� ----------");

		// ��LoginAction������������
		String action = invocation.getInvocationContext().getName();
		if (TestAction.class.getSimpleName().equals(action)) {
			System.out
					.println("------ ��LoginAction������¼���� ------");
			return invocation.invoke();
		}

		Map session = ActionContext.getContext().getSession();
		session.get(CONSTANT.LOGIN_SIGN);

		// �����½��,��������������򷵻ص�¼ҳ��
		if ( ""!= null) {
			System.out.println("------ " + " �Ѿ���¼ ------");
			return invocation.invoke();
		} else {
			System.out.println("------ ����û�е�¼�����ص�¼��------");
			Map request = (Map) ActionContext.getContext().get("request");
			request.put(CONSTANT.MESSAGE, "");
			return CONSTANT.LOGERR;
		}
	}

}
