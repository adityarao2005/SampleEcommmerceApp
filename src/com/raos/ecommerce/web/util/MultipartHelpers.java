package com.raos.ecommerce.web.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public final class MultipartHelpers {

	private MultipartHelpers() {

	}

	public static String saveMultipartData(HttpServletRequest request, HttpServletResponse response, String param)
			throws IOException, ServletException {
		String SAVE_DIR = request.getServletContext().getRealPath("/resources/images/");
		Part part = request.getPart(param);
		if (part == null || part.getSize() == 0) {
			return request.getContextPath() + "/resources/images/default_image.jpg";
		}
		String fileName = SAVE_DIR + Paths.get(part.getSubmittedFileName()).getFileName().toString();
		if (new File(fileName).exists() && new File(fileName).isFile()) {
			return "/resources/images/" + Paths.get(part.getSubmittedFileName()).getFileName().toString();
		}
		part.write(fileName);
		return request.getContextPath() + "/resources/images/" + Paths.get(part.getSubmittedFileName()).getFileName().toString();
	}

}
