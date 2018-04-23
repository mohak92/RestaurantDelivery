package project.controllers;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.cxf.binding.corba.wsdl.Array;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.log.SysoLogger;
import com.sun.javafx.collections.MappingChange.Map;

import project.beans.Event;
import project.beans.Exam;
import project.beans.Location;
import project.beans.Menuitems;
import project.beans.Orders;
import project.beans.Student;
import project.beans.Admin;
import project.beans.User;
import project.beans.User_Cart;
import project.service.AdminService;
import project.service.EventService;
import project.service.ExamService;
import project.service.LocationService;
import project.service.MenuService;
import project.service.OrderService;
import project.service.StudentService;
import project.service.UserCartService;
import project.service.UserService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Controller


public class FirstController {
	
	private static final String UPLOAD_DIRECTORY ="/img";  
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	UserCartService userCartService;
	
	@Autowired
	LocationService	locationService;
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping("/index.html")
	public String index(){
		System.out.println("gdgd");
		return "index";
	}
	
	@RequestMapping("/login.html")
	public String login(HttpServletRequest request){
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		if(email!=null){
			return "redirect:menuitems.html";
		}else{
			return "login";
		}
		//return "login";
	}
	
	@RequestMapping("/register.html")
	public String register(HttpServletRequest request){
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		if(email!=null){
			return "redirect:menuitems.html";
		}else{
			return "register";
		}
	}
	
	@RequestMapping("/processRegistration.html")
	public String processReg(HttpServletRequest request,HttpServletResponse response,@ModelAttribute User user,Model model){
		String redirectUrl = "";
		HttpSession session = request.getSession();
		user.setFirstName(request.getParameter("firstname"));
		user.setLastName(request.getParameter("lastname"));
		user.setPassword(request.getParameter("password"));
		user.setGender(request.getParameter("gender"));
		user.setAddress(request.getParameter("address"));
		user.setPhone(request.getParameter("phone"));
		user.setEmail(request.getParameter("email"));
		user.setIsAdmin("0");
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();  
		
		String hashedPassword = passwordEncoder.encode(user.getPassword());  
		user.setPassword(hashedPassword);
		boolean isExist = userService.searchByEmail(request.getParameter("email"));
		if(!isExist){
			userService.saveUser(user);
			session.setAttribute("email", user.getEmail());
			session.setAttribute("isAdmin", user.getIsAdmin());
			//model.addAttribute("msg","User Already Registered");
			redirectUrl = "redirect:menuitems.html";
		}else{
			redirectUrl = "redirect:register.html";
		}
		return redirectUrl;
	}
	
	
	@RequestMapping("/updateDetails.html")
	public String updateDetails(HttpServletRequest request,@ModelAttribute User user){
		String email = request.getParameter("email");
		List<User> userInfo = userService.getDetailsByEmail(email);
		user.setFirstName(request.getParameter("firstname"));
		user.setLastName(request.getParameter("lastname"));
		user.setPassword(request.getParameter("password"));
		user.setGender(request.getParameter("gender"));
		user.setAddress(request.getParameter("address"));
		user.setPhone(request.getParameter("phone"));
		user.setEmail(request.getParameter("email"));
		user.setIsAdmin(userInfo.get(0).getIsAdmin());
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();  
		
		String hashedPassword = passwordEncoder.encode(user.getPassword());  
		user.setPassword(hashedPassword);
		userService.updateUser(user);
		return "redirect:account.html";
	}
	
	@RequestMapping("/account.html")
	public String account(HttpServletRequest request,@ModelAttribute User user){
		
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		String proceedTo = "";
		if(email.equals(null) || email.equals("")){
			proceedTo = "redirect:logout.html";
		}else{
			List<User> userInfo = userService.getDetailsByEmail(email);
			if(userInfo.isEmpty()){
				proceedTo = "redirect:logout.html";
			}else{
				user.setFirstName(userInfo.get(0).getFirstName());
				user.setLastName(userInfo.get(0).getLastName());
				user.setPassword(userInfo.get(0).getPassword());
				user.setGender(userInfo.get(0).getGender());
				user.setAddress(userInfo.get(0).getAddress());
				user.setPhone(userInfo.get(0).getPhone());
				user.setEmail(userInfo.get(0).getEmail());
				user.setIsAdmin(userInfo.get(0).getIsAdmin());
				session.setAttribute("userInfo",user);
				proceedTo = "accountInfo";
			}
		}
		return proceedTo;
	}
	
	
	@RequestMapping("/menuitems.html")
	public String menulist(HttpServletRequest request,HttpServletResponse response,@ModelAttribute Menuitems menuitems,Model model) throws ServletException, IOException{
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		int shown_status= 1;
		if(email!=null){
			List<Menuitems> menuInfo = menuService.getMenuInformation(shown_status);
			
			for(Menuitems menu : menuInfo){
				menuitems.setDescription(menu.getDescription());
				menuitems.setImage(menu.getImage());
				menuitems.setMenuname(menu.getMenuname());
				menuitems.setPrice(menu.getPrice());
				menuitems.setStatus(menu.getStatus());
				
			}
			session.setAttribute("menuDetail", menuInfo);
			model.addAttribute("menuDetail",menuitems);
			return "menuitems";
		}else{
			return "redirect:login.html";
		}		
		//return "menuitems";
	}
	
	@RequestMapping("/addToCart.html")
	public String addToCart(HttpServletRequest request,@ModelAttribute User_Cart user_cart){
		
		HttpSession session = request.getSession();
		int menuId = Integer.valueOf(request.getParameter("menuId"));
		System.out.println(menuId);
		String email = (String)session.getAttribute("email");
		List<User> userInfo = userService.getDetailsByEmail(email);
		List<Menuitems> menuInfo = menuService.getMenuInformationById(menuId);
		if(userInfo.isEmpty() && menuInfo.isEmpty()){
			return "redirect:logout.html";
		}else{
			int user_id = userInfo.get(0).getId();
			int menuitemid = menuInfo.get(0).getId();
			double row_price = menuInfo.get(0).getPrice();
			int tax = 5;
			user_cart.setUser_id(user_id);
			user_cart.setMenuitemid(menuitemid);
			user_cart.setRow_price(row_price);
			user_cart.setTax(tax);
			userCartService.saveMenuInCart(user_cart);
			return "redirect:menuitems.html";
		}
	}
	
	@RequestMapping("/processOrder.html")
	public String processOrder(HttpServletRequest request){
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		List<User> userInfo = userService.getDetailsByEmail(email);
		if(userInfo.isEmpty()){
			return "redirect:logout.html";
		}else{
			int user_id = userInfo.get(0).getId();
			
			return "redirect:location.html";
		}
	}
	
	@RequestMapping("/location.html")
	public String location(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		List<Location> location = locationService.getLocations();
		if(location.isEmpty()){
			return "redirect:menuitems.html";
		}else{
			session.setAttribute("locations", location);
			return "location";
		}
	}
	
	@RequestMapping("/showCart.html")
	public String showCart(HttpServletRequest request,@ModelAttribute Orders orders) throws IOException{
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		List<User> userInfo = userService.getDetailsByEmail(email);
		int locationID = Integer.valueOf(request.getParameter("location"));
		if(userInfo.isEmpty()){
			
			return "redirect:index.html";
		}else{
			int user_id = userInfo.get(0).getId();
			List<User_Cart> userCartInfo = userCartService.getCartInformation(user_id);
			List<User_Cart> newCartInfo = new ArrayList<User_Cart>();
			
			//Find Duplicate Value in Array List
			for(int i=0;i<(userCartInfo.size());i++){
				int quantity = 1;
				boolean flag = false;
				double row_price = userCartInfo.get(i).getRow_price();
				for(int j=i+1;j<userCartInfo.size();j++){
					if(userCartInfo.get(j).getMenuitemid() == userCartInfo.get(i).getMenuitemid()){
						quantity++;
						flag = true;
						userCartInfo.remove(j);
					}
				}
				if(!flag){
					
					newCartInfo.add(userCartInfo.get(i));
				}else{
					userCartInfo.get(i).setRow_price(quantity*row_price);
					newCartInfo.add(userCartInfo.get(i));
				}
			}
			
			
			String jsonText = "";
			double tot_amt = 0.0;
			JSONArray jsonArray = new JSONArray();
			for(int j =0 ;j<newCartInfo.size();j++){
				
				org.json.simple.JSONObject jsonObject = new org.json.simple.JSONObject();
				jsonObject.put("menuid",newCartInfo.get(j).getMenuitemid());
				jsonArray.add(jsonObject);
				
				tot_amt += newCartInfo.get(j).getRow_price();
			}
			StringWriter out = new StringWriter();
			jsonArray.writeJSONString(out);
			jsonText = out.toString();
			String status = "uncompleted";
			List<Orders> orderinfo = orderService.getOrderInfoByUserId(user_id,status);
			long timeStamp = new Date().getTime();
			String order_num = String.valueOf(timeStamp);
			if(!orderinfo.isEmpty()){
				order_num = orderinfo.get(0).getOrder_number();
				orderService.deleteOrder(order_num);
				orders.setOrder_number(order_num);
			}else{
				orders.setOrder_number(order_num);
			}
			double tax_val = ((tot_amt*newCartInfo.get(0).getTax())/100);
			tot_amt += tax_val;
			orders.setLocation_id(locationID);
			orders.setMenuInfo(jsonText);
			orders.setPaid("UnPaid");
			orders.setStatus("uncompleted");
			orders.setTax(newCartInfo.get(0).getTax());
			orders.setTotal_amount(tot_amt);
			orders.setUser_id(user_id);
			orderService.saveOrder(orders);
			return "redirect:previewOrder.html";
		}
		//
		
	}
	
	@RequestMapping("/previewOrder.html")
	public String previewOrder(HttpServletRequest request) throws JSONException{
		
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		List<User> userInfo = userService.getDetailsByEmail(email);
		if(userInfo.isEmpty()){
			return "redirect:logout.html";
		}else{
			int user_id = userInfo.get(0).getId();
			String status = "uncompleted";
			List<Orders> orderinfo = orderService.getOrderInfoByUserId(user_id,status);
			List<Menuitems> orderMenuInfo = new ArrayList<Menuitems>();
			if(orderinfo.isEmpty()){
				return "redirect:index.html";
			}else{
				String menuInfo = orderinfo.get(0).getMenuInfo();
				JSONParser parser = new JSONParser();
				try{
					Object obj = parser.parse(menuInfo);
					JSONArray array = (JSONArray)obj;
					for(int i=0;i<array.size();i++){
						org.json.simple.JSONObject obj2 = (org.json.simple.JSONObject)array.get(i);
						int menuid =  Integer.valueOf(obj2.get("menuid").toString());
						orderMenuInfo.add(menuService.getMenuInformationById(menuid).get(0));
					}
					session.setAttribute("orderMenuInfo", orderMenuInfo);
					session.setAttribute("ordernumber", orderinfo.get(0).getOrder_number());
					return "previewOrder";
				}catch(ParseException pe){
					
					return "redirect:index.html";
				}
			}
		}
		
	}
	
	@RequestMapping("/deleteMenu.html")
	public String deleteMenu(HttpServletRequest request,@ModelAttribute Orders orders) throws IOException{
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		List<User> userInfo = userService.getDetailsByEmail(email);
		int menuid = Integer.valueOf(request.getParameter("menuId"));
		if(userInfo.isEmpty()){
			return "redirect:logout.html";
		}else{
			int user_id = userInfo.get(0).getId();
			userCartService.deleteMenuItem(menuid,user_id);
			List<User_Cart> userCartInfo = userCartService.getCartInformation(user_id);
			List<Orders> orderInfo = orderService.getOrderInfoByUserId(user_id,"uncompleted");
			if(userCartInfo.isEmpty()){
				orderService.deleteOrder(orderInfo.get(0).getOrder_number());
				return "redirect:index.html";
			}else{
				int locationID = orderInfo.get(0).getLocation_id();
				List<User_Cart> newCartInfo = new ArrayList<User_Cart>();
				for(int i=0;i<(userCartInfo.size());i++){
					int quantity = 1;
					boolean flag = false;
					double row_price = userCartInfo.get(i).getRow_price();
					for(int j=i+1;j<userCartInfo.size();j++){
						if(userCartInfo.get(j).getMenuitemid() == userCartInfo.get(i).getMenuitemid()){
							quantity++;
							flag = true;
							userCartInfo.remove(j);
						}
					}
					if(!flag){
						
						newCartInfo.add(userCartInfo.get(i));
					}else{
						userCartInfo.get(i).setRow_price(quantity*row_price);
						newCartInfo.add(userCartInfo.get(i));
					}
				}
				String jsonText = "";
				double tot_amt = 0.0;
				JSONArray jsonArray = new JSONArray();
				for(int j =0 ;j<newCartInfo.size();j++){
					
					org.json.simple.JSONObject jsonObject = new org.json.simple.JSONObject();
					jsonObject.put("menuid",newCartInfo.get(j).getMenuitemid());
					jsonArray.add(jsonObject);
					
					tot_amt += newCartInfo.get(j).getRow_price();
				}
				StringWriter out = new StringWriter();
				jsonArray.writeJSONString(out);
				jsonText = out.toString();
				String status = "uncompleted";
				//List<Orders> orderinfo = orderService.getOrderInfoByUserId(user_id,status);
				long timeStamp = new Date().getTime();
				String order_num = String.valueOf(timeStamp);
				if(!orderInfo.isEmpty()){
					order_num = orderInfo.get(0).getOrder_number();
					orderService.deleteOrder(order_num);
					orders.setOrder_number(order_num);
				}else{
					orders.setOrder_number(order_num);
				}
				double tax_val = ((tot_amt*newCartInfo.get(0).getTax())/100);
				tot_amt += tax_val;
				orders.setLocation_id(locationID);
				orders.setMenuInfo(jsonText);
				orders.setPaid("UnPaid");
				orders.setStatus("uncompleted");
				orders.setTax(newCartInfo.get(0).getTax());
				orders.setTotal_amount(tot_amt);
				orders.setUser_id(user_id);
				orderService.saveOrder(orders);
				return "redirect:previewOrder.html";
				
			}
		}
	}
	
	@RequestMapping("/cancelOrder.html")
	public String cancelOrder(HttpServletRequest request){
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		List<User> userInfo = userService.getDetailsByEmail(email);
		String order_num = request.getParameter("order_num");
		if(userInfo.isEmpty()){
			return "redirect:logout.html";
		}else{
			orderService.deleteOrder(order_num);
			userCartService.deleteMenuItemByUserID(userInfo.get(0).getId());
			return "redirect:index.html";
		}
	}
	
	@RequestMapping("/processPayment.html")
	public String processPayment(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		List<User> userInfo = userService.getDetailsByEmail(email);
		String order_num = request.getParameter("order_num");
		if(userInfo.isEmpty()){
			return "redirect:logout.html";
		}else{
			return "payment";
		}
	}
	
	@RequestMapping("/completePayment.html")
	public String completePayment(HttpServletRequest request,@ModelAttribute Orders orders){
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		List<User> userInfo = userService.getDetailsByEmail(email);
		if(userInfo.isEmpty()){
			return "redirect:logout.html";
		}else{
			int user_id = userInfo.get(0).getId();
			List<Orders> orderInfo = orderService.getOrderInfoByUserId(user_id,"uncompleted");
			String order_id = orderInfo.get(0).getOrder_number();
			orderService.deleteOrder(order_id);
			orders.setLocation_id(orderInfo.get(0).getLocation_id());
			orders.setMenuInfo(orderInfo.get(0).getMenuInfo());
			orders.setOrder_number(order_id);
			orders.setPaid("Paid");
			orders.setStatus("completed");
			orders.setTax(orderInfo.get(0).getTax());
			orders.setTotal_amount(orderInfo.get(0).getTotal_amount());
			orders.setUser_id(user_id);
			orderService.saveOrder(orders);
			userCartService.deleteMenuItemByUserID(user_id);
			
			//Getting order Detail
			String menuInfo = orderInfo.get(0).getMenuInfo();
			List<Menuitems> orderMenuInfo = new ArrayList<Menuitems>();
			JSONParser parser = new JSONParser();
			try{
				Object obj = parser.parse(menuInfo);
				JSONArray array = (JSONArray)obj;
				for(int i=0;i<array.size();i++){
					org.json.simple.JSONObject obj2 = (org.json.simple.JSONObject)array.get(i);
					int menuid =  Integer.valueOf(obj2.get("menuid").toString());
					orderMenuInfo.add(menuService.getMenuInformationById(menuid).get(0));
				}
				List<Location> location = locationService.getLocationsById(orderInfo.get(0).getLocation_id());
				session.setAttribute("LocationInfo", location.get(0));
				session.setAttribute("orderMenuInfo", orderMenuInfo);
				session.setAttribute("completedOrderInfo",orderInfo.get(0));
				session.setAttribute("ordernumber", orderInfo.get(0).getOrder_number());
				return "orderrecipt";
			}catch(ParseException pe){
				
				return "redirect:index.html";
			}
		}
	}
	
	@RequestMapping("/viewOrders.html")
	public String viewOrders(HttpServletRequest request) throws ParseException{
		
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		List<User> userInfo = userService.getDetailsByEmail(email);
		if(userInfo.isEmpty()){
			return "redirect:logout.html";
		}else{
			int user_id = userInfo.get(0).getId();
			List<Orders> orderInfo = orderService.getOrderInfoByUserId(user_id,"completed");
			HashMap<Integer,Object> mapinfo = new HashMap<Integer, Object>();
			
			
			JSONParser parser = new JSONParser();
			System.out.println(orderInfo.size());
			for(int i=0;i<orderInfo.size();i++){
				HashMap<String,Object> map = new HashMap<String, Object>();
				map.put("orderDetail", orderInfo.get(i));
				
				Object obj = parser.parse(orderInfo.get(i).getMenuInfo());
				JSONArray array = (JSONArray)obj;
				List<Menuitems> menuItemInfo = new ArrayList<Menuitems>();
				for(int j=0;j<array.size();j++){
					org.json.simple.JSONObject obj2 = (org.json.simple.JSONObject)array.get(j);
					int menuid =  Integer.valueOf(obj2.get("menuid").toString());
					menuItemInfo.add(menuService.getMenuInformationById(menuid).get(0));
				}
				map.put("menuInfo", menuItemInfo);
				List<Location> location = locationService.getLocationsById(orderInfo.get(0).getLocation_id());
				map.put("location", location.get(0));
				mapinfo.put(i,map);
			}
			session.setAttribute("ordersHistory", mapinfo);
		}
		return "userpassedorder";
	}

	
	@RequestMapping("/addLocation.html")
	public ModelAndView addLocation(HttpServletRequest request,@ModelAttribute Location location){
		
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		if(email != null){
			boolean flag = true;
		}
		return new ModelAndView("addLocation","key",location);
	}
	
	@RequestMapping("/processLogin.html")
	public ModelAndView processLogin(HttpServletRequest request,HttpServletResponse response,@ModelAttribute User user){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		List<User> userInfo = userService.getDetailsByEmail(username);
		
		String redirect = "";
		if(userInfo.isEmpty()){
			redirect = "redirect:login.html";
		}else{
			String dbPassword = userInfo.get(0).getPassword();
			
			String isAdmin = userInfo.get(0).getIsAdmin();
			user.setAddress(userInfo.get(0).getAddress());
			user.setEmail(userInfo.get(0).getEmail());
			user.setFirstName(userInfo.get(0).getFirstName());
			user.setGender(userInfo.get(0).getGender());
			user.setIsAdmin(isAdmin);
			user.setLastName(userInfo.get(0).getLastName());
			user.setPhone(userInfo.get(0).getPhone());
			
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			boolean isValidUser = passwordEncoder.matches(password,dbPassword);
			if(isValidUser){
				HttpSession session = request.getSession();
				session.setAttribute("email", username);
				session.setAttribute("isAdmin", isAdmin);
				session.setAttribute("userInfo",user);
				System.out.println(isAdmin);
				if(isAdmin.equals("1")){
					redirect = "accountInfo";
				}else{
					redirect = "redirect:menuitems.html";
				}
			}else{
				redirect = "redirect:login.html";
			}
		}
		return new ModelAndView(redirect,"fName",userInfo);
	}
	
		
	@RequestMapping("/logout.html")
	public String logout(HttpServletRequest request){
		HttpSession session=request.getSession();
		
		session.invalidate();
		session = request.getSession(false);
		System.out.println("session "+session);
		if(session == null || !request.isRequestedSessionIdValid()){
			return "logout";
			
		}else{
			return "redirect:index.html";
		}
	}
	
	@RequestMapping("/navigateApp.html")
	public String navigateApp(HttpServletRequest request){
		
		
		return "redirect:userList.html";
	}
	
	@RequestMapping("/userList.html")
	public String userList(HttpServletRequest request){
		HttpSession session=request.getSession();
	
		List<User> userInfo = userService.getUserInfo();
		if(userInfo.isEmpty()){
			return "redirect:index.html";
		}else{
			session.setAttribute("usersInfo", userInfo);
			return "regularuser";
		}
	}
	
	@RequestMapping("/editUser.html")
	public String editUser(HttpServletRequest request,@ModelAttribute User user){
		HttpSession session = request.getSession();
		int id = Integer.valueOf(request.getParameter("userId"));
		String proceedTo = "";
		if(request.getParameter("userId").equals(null)){
			proceedTo = "redirect:logout.html";
		}else{
			List<User> userInfo = userService.getDetailsByID(id);
			if(userInfo.isEmpty()){
				proceedTo = "redirect:logout.html";
			}else{
				user.setFirstName(userInfo.get(0).getFirstName());
				user.setLastName(userInfo.get(0).getLastName());
				user.setPassword(userInfo.get(0).getPassword());
				user.setGender(userInfo.get(0).getGender());
				user.setAddress(userInfo.get(0).getAddress());
				user.setPhone(userInfo.get(0).getPhone());
				user.setEmail(userInfo.get(0).getEmail());
				user.setIsAdmin(userInfo.get(0).getIsAdmin());
				session.setAttribute("singleUserInfo",user);
				proceedTo = "singleUserInfo";
			}
		}
		return proceedTo;
	}
	
	@RequestMapping("/singleUpdateUser.html")
	public String singleUpdateUser(HttpServletRequest request,@ModelAttribute User user){
		
		
		user.setFirstName(request.getParameter("firstname"));
		user.setLastName(request.getParameter("lastname"));
		user.setPassword(request.getParameter("password"));
		user.setGender(request.getParameter("gender"));
		user.setAddress(request.getParameter("address"));
		user.setPhone(request.getParameter("phone"));
		user.setEmail(request.getParameter("email"));
		user.setIsAdmin("0");
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();  
		
		String hashedPassword = passwordEncoder.encode(user.getPassword());  
		user.setPassword(hashedPassword);
		userService.updateUser(user);
		return "redirect:userList.html";
	}
	
	@RequestMapping("itemList.html")
	public String itemList(HttpServletRequest request){
		HttpSession session=request.getSession();
		
		List<Menuitems> menuitems = menuService.getMenuInformation();
		if(menuitems.isEmpty()){
			return "redirect:index.html";
		}else{
			session.setAttribute("MenuItemsInfo", menuitems);
			return "itemlist";
		}
	}
	
	@RequestMapping("/editMenu.html")
	public ModelAndView editMenu(HttpServletRequest request,@ModelAttribute Menuitems menuitems){
		HttpSession session=request.getSession();
		
		int menuid = Integer.valueOf(request.getParameter("menuId"));
		if(request.getParameter("menuId").equals(null)){
			return new ModelAndView("redirect:itemList.html");
		}else{
			List<Menuitems> menuitem = menuService.getMenuInformationById(menuid);
			if(menuitem.isEmpty()){
				return new ModelAndView("redirect:index.html");
			}else{
				session.setAttribute("MenuItemsInfo", menuitem.get(0));
				return new ModelAndView("singleMenuInfo","key",menuitems);
			}
		}
		
	}
	
	@RequestMapping("/updateMenus.html")
	public String updateMenus(HttpServletRequest request,@RequestParam("imageFile") MultipartFile file,@ModelAttribute Menuitems menuitems) throws IOException{
		
		HttpSession session = request.getSession();
		String imageName = menuitems.getImageFile().getOriginalFilename();
		File files = new File("/Users/mohaktamhane/eclipse-workspace/RestaurantJava/WebContent/img"+imageName);
		menuitems.getImageFile().transferTo(files);
		menuitems.setImage(imageName);
		menuitems.setDescription(request.getParameter("description"));
		menuitems.setMenuname(request.getParameter("itemname"));
		menuitems.setPrice(Double.valueOf(request.getParameter("price")));
		//menuitems.setImage();
		menuitems.setStatus(1);
		Menuitems menuInfo = (Menuitems)session.getAttribute("MenuItemsInfo");
		
		//String image=request.getParameter("image").getOriginalFilename();
		menuService.updateMenu(menuitems,menuInfo.getId());
		return "redirect:editMenu.html?menuId="+menuInfo.getId();
	}
	
	@RequestMapping("/addMenu.html")
	public ModelAndView addMenu(HttpServletRequest request,@ModelAttribute Menuitems menuitems){
		
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		if(email != null){
			return new ModelAndView("addMenuInfo","key",menuitems);
		}else{
			return new ModelAndView("addMenuInfo","key",menuitems);
		}
	}
	
	@RequestMapping("/addNewMenus.html")
	public String addNewMenus(HttpServletRequest request,@RequestParam("imageFile") MultipartFile file,@ModelAttribute Menuitems menuitems) throws IOException{
		
		HttpSession session = request.getSession();
		String imageName = menuitems.getImageFile().getOriginalFilename();
		File files = new File("/Users/mohaktamhane/eclipse-workspace/RestaurantJava/WebContent/img"+imageName);
		menuitems.getImageFile().transferTo(files);
		menuitems.setImage(imageName);
		menuitems.setDescription(request.getParameter("description"));
		menuitems.setMenuname(request.getParameter("itemname"));
		menuitems.setPrice(Double.valueOf(request.getParameter("price")));
		//menuitems.setImage();
		menuitems.setStatus(1);
		menuService.saveMenu(menuitems);
		return "redirect:itemList.html";
	}
	
	@RequestMapping("/locationList.html")
	public String locationList(HttpServletRequest request){
		HttpSession session=request.getSession();
		
		List<Location> location = locationService.getLocations();
		if(location.isEmpty()){
			return "redirect:index.html";
		}else{
			session.setAttribute("locationInDetail", location);
			return "locationList";
		}
	}
	
	@RequestMapping("/editLocation.html")
	public ModelAndView editLocation(HttpServletRequest request,@ModelAttribute Location location){
		HttpSession session=request.getSession();
		
		int locid = Integer.valueOf(request.getParameter("locId"));
		if(request.getParameter("locId").equals(null)){
			return new ModelAndView("redirect:locationList.html");
		}else{
			List<Location> locations = locationService.getLocationsById(locid);
			if(locations.isEmpty()){
				return new ModelAndView("redirect:index.html");
			}else{
				session.setAttribute("locationsInfo", locations.get(0));
				return new ModelAndView("locationInfo","key",location);
			}
		}
		
	}
	
	@RequestMapping("/addNewLocation.html")
	public String addNewLocation(HttpServletRequest request,@RequestParam("imageFile") MultipartFile file,@ModelAttribute Location location) throws IOException{
		
		HttpSession session = request.getSession();
		String imageName = location.getImageFile().getOriginalFilename();
		File files = new File("F:\\Rohit\\RestaurantJava\\WebContent\\WEB-INF\\views\\img\\"+imageName);
		location.getImageFile().transferTo(files);
		location.setImage(imageName);
		location.setLocation_name(request.getParameter("location"));
		location.setAddress(request.getParameter("add"));
		location.setCity(request.getParameter("city"));
		location.setStaffs(Integer.valueOf(request.getParameter("staff")));
		location.setZipcode(request.getParameter("zip"));
		locationService.saveLocation(location);
		return "redirect:locationList.html";
	}
	
	@RequestMapping("/updateLocations.html")
	public String updateLocation(HttpServletRequest request,@RequestParam("imageFile") MultipartFile file,@ModelAttribute Location location) throws IOException{
		
		HttpSession session = request.getSession();
		String imageName = location.getImageFile().getOriginalFilename();
		File files = new File("F:\\Rohit\\RestaurantJava\\WebContent\\WEB-INF\\views\\img\\"+imageName);
		location.getImageFile().transferTo(files);
		location.setImage(imageName);
		location.setLocation_name(request.getParameter("location"));
		location.setAddress(request.getParameter("add"));
		location.setCity(request.getParameter("city"));
		location.setStaffs(Integer.valueOf(request.getParameter("staff")));
		location.setZipcode(request.getParameter("zip"));
		Location locations = (Location)session.getAttribute("locationsInfo");
		
		//String image=request.getParameter("image").getOriginalFilename();
		locationService.updateLocation(location,locations.getId() );
		return "redirect:editLocation.html?locId="+locations.getId();
	}
	
	@RequestMapping("orderList.html")
	public String orderList(HttpServletRequest request){
		HttpSession session=request.getSession();
		List<Orders> orders = orderService.getOrderInfoByStatus("completed");
		System.out.println(orders.size());
		if(orders.isEmpty()){
			return "redirect:index.html";
		}else{
			session.setAttribute("orderInformation", orders);
			return "orderlist";
		}
		
	}
	
	@RequestMapping("/deleteOrder.html")
	public String deleteOrder(HttpServletRequest request){
		HttpSession session=request.getSession();
		String order_num = request.getParameter("order_num");
		if(order_num.equals(null)){
			return "redirect:index.html";
		}else{
			orderService.deleteOrder(order_num);
			return "redirect:orderList.html";
		}
	}
	
}
