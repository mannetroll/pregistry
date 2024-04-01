package com.mannetroll.pregistry;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * curl -is "http://127.0.0.1:2020/search?package=apm&prerelease=false&kibana.version=8.11.3"
 * curl -is "http://127.0.0.1:2020/search?package=synthetics&prerelease=true&kibana.version=8.11.3"
 * curl -is "http://127.0.0.1:2020/search?kibana.version=8.11.3"
 * curl -is "http://127.0.0.1:2020/categories?kibana.version=8.11.3"
 *
 */

@RestController
public class SearchController {
	private static final Logger LOG = LogManager.getLogger(SearchController.class);

	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void search(@RequestParam(name = "package", defaultValue = "") String pname, HttpServletResponse response)
			throws IOException {
		ServletOutputStream outputStream = response.getOutputStream();
		LOG.info("package: " + pname);
		if (pname.length() > 1) {
			outputStream.println(file(pname + ".json"));
		} else {
			outputStream.println(file("search.json"));
		}
	}

	@RequestMapping(value = "/categories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void categories(HttpServletResponse response) throws IOException {
		ServletOutputStream outputStream = response.getOutputStream();
		LOG.info("package: categories");
		outputStream.println(file("categories.json"));
	}

	private String file(String json) throws IOException {
		URL file = SearchController.class.getResource(json);
		InputStream fileStream = file.openStream();
		InputStreamReader inStreamReader = new InputStreamReader(fileStream, StandardCharsets.UTF_8);
		StringWriter writer = new StringWriter();
		inStreamReader.transferTo(writer);
		return writer.toString();
	}

}
