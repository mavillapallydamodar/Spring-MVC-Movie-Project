package edu.mum.cs544.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs544.DAO.IMovieDAO;
import edu.mum.cs544.model.Movie;


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
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") long id, Model model) {
        Movie movie = movieDao.findById(id);
        model.addAttribute(movie);
        return "/movie/form";
    }
	
	 @RequestMapping(value = "/form", method = RequestMethod.GET)
	    public @ModelAttribute
	    Movie create(Model model) {
	        Movie movie = new Movie();
	        return movie;
	    }

	    @RequestMapping(value = "/form", method = RequestMethod.POST)
	    public String createOnSubmit(@Valid Movie movie,
	            BindingResult bindingResult, Model model) {
	        if (bindingResult.hasErrors()) {
	            model.addAllAttributes(bindingResult.getModel());
	            return "/movie/form";
	        }
	        movieDao.create(movie);
	        return "redirect:/movieList";
	    }
}
