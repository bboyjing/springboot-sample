package cn.didadu.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by jinggg on 16/4/23.
 */

@Component
public class CustomServletContainer implements EmbeddedServletContainerCustomizer{

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
        container.setSessionTimeout(10, TimeUnit.MINUTES);
    }
}
