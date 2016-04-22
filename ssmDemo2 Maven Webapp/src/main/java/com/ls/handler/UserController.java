package com.ls.handler;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ls.handler.validation.ValiGrp2;
import com.ls.po.User;
import com.ls.po.UserQueryVo;
import com.ls.service.UserService;

@Controller
public class UserController {

	@Resource
	private UserService userService;
	Log log = LogFactory.getLog(UserController.class);
	
	/**
	 * 查询
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryUsers")
	public ModelAndView queryUsers() throws Exception{
		List<User> users = userService.findUsers();

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("users",users);
		modelAndView.setViewName("user/userList");
		return modelAndView;
	}
	
	/**
	 * 获取单个用户
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getUser",method={RequestMethod.GET,RequestMethod.POST})
	public String getUser(Model model,@RequestParam(value="id",defaultValue="0")int id) throws Exception{
		
		User user = userService.findUserById(id);
		
		model.addAttribute("user", user);
		
		return "user/user";
	}
	
	@RequestMapping(value="/editUser")
	public String editUser(Model model,Integer id,@ModelAttribute("user") @Validated(ValiGrp2.class) User user,BindingResult bindingResult,
			Date date,MultipartFile photo_pic) throws Exception{
		
		if(bindingResult.hasErrors()){
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			for (ObjectError objectError : allErrors) {
				System.out.println(objectError.getObjectName());
				System.out.println(objectError.getDefaultMessage());
			}
			
			model.addAttribute("allErrors", allErrors);
			return "user/user";
		}
		
		//上传图片
		String originalFileName = photo_pic.getOriginalFilename();
		if(photo_pic != null && originalFileName != null && originalFileName.length() > 0){
			String fileDir = "D:\\tomcat\\apache-tomcat-7.0.61\\webapps\\ssmDemo\\img\\";
			
			String newFileName = UUID.randomUUID() + originalFileName.substring(originalFileName.lastIndexOf("."));
			File newFile = new File(fileDir + newFileName);
			photo_pic.transferTo(newFile);
			
			user.setPhoto(newFileName);
		}
		
		userService.editUser(id, user);
		System.out.println(date);
		
		return "redirect:/queryUsers.action";
	}
	
	@RequestMapping("/userListEditQuery")
	public ModelAndView userListEditQuery() throws Exception{
		List<User> users = userService.findUsers();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("users",users);
		modelAndView.setViewName("user/userListEditQuery");
		return modelAndView;
	}
	
	@RequestMapping(value="userListEdit")
	public String userListEdit(@Validated UserQueryVo userQueryVo,BindingResult bindingResult) throws Exception{
		
		if(bindingResult.hasErrors()){
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			for (ObjectError objectError : allErrors) {
				System.out.println(objectError.getObjectName());
				System.out.println(objectError.getDefaultMessage());
			}
		}
		userService.editUserList(userQueryVo);
		
		return "redirect:/queryUsers.action";
	}

}
