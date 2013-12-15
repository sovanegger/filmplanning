package cz.tomsovsky.bc.filmplanning.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cz.tomsovsky.bc.filmplanning.dto.User;
import cz.tomsovsky.bc.filmplanning.service.UserService;

public class UserControllerTest {
	private UserService userService;
	private UserController controller;
	
	@Before
	public void setUp() {
		userService = mock(UserService.class);
		controller = new UserController(userService);
	}
	
	@Test
	public void testLogout() {
		String expectedRedirectUrl = "redirect:/users/j_spring_security_logout";
		String redirectUrl = controller.logout();
		assertEquals(expectedRedirectUrl, redirectUrl);
	}
	
	@Test
	public void testLogin() {
		String expectedView = "users/login";
		String view = controller.login(null, null);
		assertEquals(expectedView, view);
	}

	@Test
	public void testSaveUser() {
		BindingResult bindingResult = mock(BindingResult.class);
		RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);
		User user = mock(User.class);
		String expectedRedirectUrl = "";
		String redirectUrl = "";
		
		when(bindingResult.hasErrors()).thenReturn(true);
		expectedRedirectUrl = "users/add";
		redirectUrl = controller.saveUser(user, bindingResult, redirectAttributes);
		assertEquals(expectedRedirectUrl, redirectUrl);
		
		when(bindingResult.hasErrors()).thenReturn(false);
		expectedRedirectUrl = "redirect:/users/login";
		redirectUrl = controller.saveUser(user, bindingResult, redirectAttributes);
		assertEquals(expectedRedirectUrl, redirectUrl);
	}
	
	@Test
	public void testGetAddForm() {
		Model model = mock(Model.class);
		String expectedView = "users/add";
		String view = controller.getAddForm(model);
		assertEquals(expectedView, view);
	}
	
	@Test
	public void testShowPage() {
		String username = "username";
		Model model = mock(Model.class);
		
		String expectedView = "users/show";
		String view = controller.getShowPage(username, model);
		assertEquals(expectedView, view);
	}
}
