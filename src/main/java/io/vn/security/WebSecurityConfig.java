package io.vn.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import io.vn.security.authent.AuthRest;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * Permet de renvoyer le code réponse de la requête 200 / 401 ...
	 */
	@Autowired
	private AuthRest restAuthent;

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().exceptionHandling().authenticationEntryPoint(restAuthent) //
				.and() //
				.authorizeRequests().antMatchers("/action").authenticated() //
				.and() //
				.formLogin() //
				.successHandler(new SimpleUrlAuthenticationSuccessHandler()) // 
				.failureHandler(new SimpleUrlAuthenticationFailureHandler()) //
				.and() //
				.logout();
	}

	/**
	 * Méthode d'authentification, ici en mémoire Utilisateur : user, mot de passe :
	 * password
	 * 
	 * @param auth
	 *            Gestionnaire de la méthode d'authentification
	 * 
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
	}

	/**
	 * Cette méthode permet de ne pas encoder le mot de passe par le client - mode
	 * dev
	 * 
	 * @return testing no encoder
	 */
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

}
