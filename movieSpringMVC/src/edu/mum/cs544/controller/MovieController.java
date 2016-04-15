package edu.mum.cs544.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs544.DAO.IMovieDAO;


@Controller
public class MovieController {

	@Resource
	private IMovieDAO movieDao;
	
	@RequestMapping(value="/addMovie", method = RequestMethod.GET)
	public ModelAndView home() {
 
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Movie Database, Spring MVC</h3>This message is coming from MovieController.java **********</div><br><br>";
		return new ModelAndView("addMovie", "message", message);
	}
	
	@RequestMapping(value="/movies", method=RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("movies", movieDao.findAll());
		return "movieList";
	}
}
