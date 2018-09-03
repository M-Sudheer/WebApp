package practise.task;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import demo.project.tables.dao.VendorService;
import demo.project.tables.model.Login;
import demo.project.tables.model.Vendor;

@Controller
public class HomeController 
{
	@Autowired
	private Vendor vendor;
	@Autowired
	private VendorService vendorService;
	@Autowired
	private SessionFactory sessionFactory;
	
	@GetMapping(value= {"index"})
	public ModelAndView indexPage()
	{
		ModelAndView modelAndView=new ModelAndView("index");
	    return modelAndView;
	}
	
	@RequestMapping("/contact")
	public String  contactPage(Model model,HttpSession session)
	{
		session.setAttribute("name","Sudheer");
		model.addAttribute("date", new Date());
		return "contact";
	}
	@RequestMapping("/home")
	public  ModelAndView getDate()
	{
		ModelAndView modelAndView=new ModelAndView("home");
		modelAndView.addObject("date", new Date());
		return modelAndView;
	}

	
	@GetMapping(value= {"/","/signup"})
	public String signup(Model model)
	{
		model.addAttribute("vendor", new Vendor());
		return "signup";
	}
	@PostMapping("/register")
	public String addVendor(@ModelAttribute("vendor")Vendor vendor) 
	{
		if(vendorService.getVendorByEmail(vendor.getEmail())==null)
		{
			vendorService.addVendor(vendor);
			return "redirect:/login";
		}
		else
		{
			return "signup";
		}
	}
	@GetMapping("/login")
	public String login(Model model)
	{
		model.addAttribute("login", new Login());
		return "login";
	}

	@PostMapping("/login")
	public String getVendor(@ModelAttribute("login") Login login,Vendor vendor,HttpSession httpSession)
		{
		if((vendorService.login(login.getEmail(),login.getPassword())!=null))
		{
			vendor=vendorService.login(login.getEmail(),login.getPassword());
			httpSession.setAttribute("profile",vendor);
			return "profile";
		}
		else
		{
			return "login";
		}
		}
	@GetMapping("/profile")
	public String profile()
	{
	return "profile";
	}
	
	@GetMapping(value= {"/edit"})
	public String editProfile(HttpSession httpSession,Model model)
	{
		model.addAttribute("vendor", httpSession.getAttribute("profile"));
		return "edit";
	}
	
	
	@PostMapping("update")
	public String update(@ModelAttribute("vendor")Vendor vendor,HttpSession httpSession)
	{
		System.out.println(vendor.getVid());
		httpSession.setAttribute("profile", vendor);
		vendorService.updateVendor(vendor);
		return "redirect:profile";
		
	}
}
