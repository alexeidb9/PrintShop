
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = { "/", "/print" })
public class PrintController {

	private PrintShopArticleService service;
	private Log log;

	@Inject
	public PrintController(PrintShopPrintService service, Log log) {
		this.service = service;
		this.log = log;
	}

	@RequestMapping(value = { "/", "" })
	public ModelAndView index(@CurrentUser AuthenticatedUser user) {
		List<GetPrint> serviceEntries = service.getAllArticles(user.getId());
		List<Print> prints = new ArrayList<Print>();
		serviceEntries.forEach(e -> {
			Print entry = new Print(e);
			prints.add(entry);
		});

		ModelAndView mv = new ModelAndView("print/index");
		mv.addObject("prints", prints);
		
		return mv;
	}
	//InputStreamResource
	@RequestMapping(value = "image/{imageId}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ByteArrayResource> downloadLinkInage(@PathVariable Long imageId) {
	    BufferedImage image = (BufferedImage) service.getArticleImage(imageId);

	    byte[] bytes = getByteArrayFromImage(image, log);
	    ByteArrayResource bsr = new ByteArrayResource(bytes);
	    return ResponseEntity.ok()
	            .contentLength(bytes.length)
	            .contentType(MediaType.parseMediaType("image/png"))
	            .body(bsr);
	}
	
}
