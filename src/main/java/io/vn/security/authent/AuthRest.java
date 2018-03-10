package io.vn.security.authent;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * Class d'authentification REST, implément Spring AuthenticationEntryPoint
 * 
 * @author vn
 */
@Component("RestAuthent")
public class AuthRest implements AuthenticationEntryPoint {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {
		// Renvoi 401 en cas de non identification
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
	}

}