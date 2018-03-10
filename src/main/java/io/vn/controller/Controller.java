package io.vn.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.vn.bean.ObjetBean;

@RestController
public class Controller {

	/**
	 * Titre rajouté à la réponse
	 */
	private static final String titre = "Contenu : %s!";

	/**
	 * Identifiant de la requête
	 */
	private final AtomicLong compteur = new AtomicLong();

	/**
	 * URL Rest de test
	 * 
	 * @param name
	 *            : Contenu qui sera renvoyé par le service
	 * @return
	 */
	@RequestMapping("/action")
	public ObjetBean action(@RequestParam(value = "1", defaultValue = "test") String name) {
		return new ObjetBean(compteur.incrementAndGet(), String.format(titre, name));
	}
}