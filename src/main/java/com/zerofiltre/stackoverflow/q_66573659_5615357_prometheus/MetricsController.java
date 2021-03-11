package com.zerofiltre.stackoverflow.q_66573659_5615357_prometheus;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MetricsController {

  @GetMapping(value = "/metrics")
  public void metrics(HttpServletResponse response) throws IOException {
    log.info("Loading metrics ...");
    File file = new File("logparsing");
    InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
    MediaType mediaType = new MediaType("text", "plain", StandardCharsets.UTF_8);
    InputStream myStream = new FileInputStream(file);
    // Set the content type and attachment header.
    response.setContentType("text/plain; version=0.0.4;charset=utf-8");
    response.setCharacterEncoding("utf-8");
    // Copy the stream to the response's output stream.
    IOUtils.copy(myStream, response.getOutputStream());
    response.flushBuffer();
    log.info("Loaded metrics !");
  }

}
