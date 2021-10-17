package test.printshop.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import main.java.repository.PrintRepository;
import main.java.service.models.AddPrint;
import main.java.service.models.GetPrint;
import models.Prints.Print;
import org.apache.commons.logging.Log;
import org.junit.Before;
import org.junit.Test;

import main.java.service.PrintDetailsServiceOnArticleRepository;
import main.java.service.PrintServiceException;

public class PrintShopPrintsServiceOnRepositoryTest {
	PrintDetailsServiceOnArticleRepository printEntryServiceOnRepository;
	PrintRepository entryRepository;
	UsersRepository usersRepository;
	Log log;
	PrintDetailsServiceOnArticleRepository service;

	@Before
	public void before() {
		entryRepository = mock(PrintRepository.class);
		usersRepository = mock(UsersRepository.class);
		log = mock(Log.class);
		service = new PrintDetailsServiceOnArticleRepository(entryRepository, usersRepository, log);
	}

	@Test
	public void getAllEntries_should_return_all_articles() throws SerialException, SQLException {

		User user = new User();
		Print entry = new Print();
		entry.setImage(new byte[0]);
		entry.setUser(user);

		when(entryRepository.findByUserId(1)).thenReturn(Arrays.asList(entry));

		List<GetPrint> prints = service.getAllArticles(1);

		assertThat(prints.size()).isEqualTo(1);
	}

	@Test
	public void getEntry_should_return_a_single_entry() throws SerialException, SQLException {

		Long id = 1L;
		Print entryIn = new Print();
		User user = new User();
		user.setId(1L);
		entryIn.setUser(user);
		entryIn.setImage(new byte[0]);
		when(entryRepository.findOne(id)).thenReturn(entryIn);

		service = new PrintDetailsServiceOnArticleRepository(entryRepository, usersRepository, log);
		GetPrint entry = service.getArticle(id);

		assertThat(entry).isNotNull();
	}

	@Test(expected = PrintServiceException.class)
	public void getEntry_should_throw_an_exception_when_the_id_is_wrong() {

		long id = 1;
		when(entryRepository.findOne(id)).thenReturn(null);

		service = new PrintDetailsServiceOnArticleRepository(entryRepository, usersRepository, log);
		service.getArticle(id);
	}

	@Test
	public void getEntry_should_return_a_single_entry_with_the_correct_title_and_url()
			throws SerialException, SQLException {

		long id = 1;
		String title = "Title";
		String url = "URL";

		Print entry = new Print();
		User user = new User();
		user.setId(1L);
		entry.setUser(user);
		entry.setTitle(title);
		entry.setUrl(url);

		entry.setImage(new byte[0]);

		when(entryRepository.findOne(id)).thenReturn(entry);

		service = new PrintDetailsServiceOnArticleRepository(entryRepository, usersRepository, log);
		GetPrint jacketEntry = service.getArticle(id);

		assertThat(jacketEntry.getTitle()).isEqualTo(title);
		assertThat(jacketEntry.getUrl()).isEqualTo(url);
	}

	@Test(expected = PrintServiceException.class)
	public void addEntry_should_throw_an_exception_when_title_is_null() {
		service.addPrint(new AddPrint(1L, "url", null, 1L, new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB)));
	}

	@Test(expected = PrintServiceException.class)
	public void addEntry_should_throw_an_exception_when_url_is_null() {
		service.addPrint(new AddPrint(1L, null, "title", 1L, new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB)));
	}

	@Test(expected = PrintServiceException.class)
	public void addEntry_should_throw_an_exception_when_image_is_null() {
		service.addPrint(new AddPrint(1L, "url", "title", 1L, null));
	}

	@Test(expected = PrintServiceException.class)
	public void addEntry_should_throw_an_exception_when_entry_is_null() {
		service.addPrint(null);
	}
}
