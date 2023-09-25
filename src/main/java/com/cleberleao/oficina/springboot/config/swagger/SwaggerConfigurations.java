package com.cleberleao.oficina.springboot.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author CleberLeão
 */
@Configuration
public class SwaggerConfigurations {
	
//	@Bean
//	public Docket oficinaApi() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.apis(RequestHandlerSelectors.basePackage("com.cleberleao.oficina.springboot"))
//				.paths(PathSelectors.ant("/**"))
//				.build()
//				.ignoredParameterTypes(User.class)
//				.globalOperationParameters(Arrays.asList(
//						new ParameterBuilder()
//						.name("Authorization")
//						.description("Header para token JWT")
//						.modelRef(new ModelRef("string"))
//						.parameterType("header")
//						.required(false)
//						.build()));
//	}
@Bean
public Docket api() {
	return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.any())
			.paths(PathSelectors.any())
			.build();
}

}
