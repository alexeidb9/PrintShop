package com.pluralsight.jacket.test;

import static org.assertj.core.api.Assertions.assertThat;

import main.java.repository.PrintRepository;
import models.Prints.Print;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class PrintRepositoryTest extends AbstractTest {

	@Autowired
	PrintRepository repository;
	private int count;

	@Test
	public void shouldFindAllArticles() {

		Iterable<Print> articles = repository.findAll();

		articles.forEach(a -> {			
			count++;
		});
		assertThat(prints).isNotNull();
		assertThat(count).isEqualTo(2);
	}

}
