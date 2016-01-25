package com.secsm.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.secsm.dao.AccountDao;
import com.secsm.info.AccountInfo;

@Controller
public class SecsmController {
	private static final Logger logger = LoggerFactory.getLogger(SecsmController.class);

	@Autowired
	private AccountDao accountDao;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String MainController_index(HttpServletRequest request) {
		logger.info("index Page");

		return "index";
	}
	
	/** 로그인 설정 */
	@RequestMapping(value = "/login_db", method = RequestMethod.POST)
	@ResponseBody
	public String login(HttpServletRequest request) {

		String result = "0";

		logger.info("User Login");

		String email = request.getParameter("Signin_email");
		String password = request.getParameter("Signin_password");

		if(email.length()>50)
			return "email";
		if(password.length()>16)
			return "password";
		
		// 세션 객체 생성
		HttpSession session = request.getSession();

		List<AccountInfo> data = accountDao.select(email);

		// 이메일이 존재하지 않을 때
		if (data == null || data.isEmpty()) {
			result = "0"; // no email
		} else {
			if (data.get(0).getPw().equals(password)) // password unequal
			{
				result = "1";

				session.setAttribute("currentmember", data.get(0));
			} else {
				result = "0";
			}
		}

		return result;
	}
}
