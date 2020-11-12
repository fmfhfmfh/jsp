package kr.or.ddit.config.spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import kr.or.ddit.mvc.view.DownloadView;
import kr.or.ddit.mvc.view.ExcelDownloadView;
import kr.or.ddit.mvc.view.ProfileImgView;

@Configuration
@ComponentScan(basePackages = {"kr.or.ddit"}, useDefaultFilters = false, 
			includeFilters = {@Filter(type = FilterType.ANNOTATION, classes = {Controller.class, ControllerAdvice.class})})
@EnableWebMvc // <mvc:annotation-driven/>
public class ApplicationContext extends WebMvcConfigurerAdapter {
	
	// <mvc:default-servlet-handler/> ==> extends 구현(WebMvcConfigurerAdapter)
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	
	
	
//	<bean id="excelView" class="kr.or.ddit.mvc.view.ExcelDownloadView"/>
//	<bean id="profileImgView" class="kr.or.ddit.mvc.view.ProfileImgView"/>
//	<bean id="downloadView" class="kr.or.ddit.mvc.view.DownloadView"/>
//	<bean id="jsonView" class="org.springframework.web.servlet.view.json.MappingJackson2JsonView"/>

	@Bean
	public ProfileImgView profileImgView() {
		ProfileImgView profileImgView = new ProfileImgView();
		
		return profileImgView;
	}
	
	@Bean
	public MappingJackson2JsonView jsonView() {
		MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
		
		return jsonView;
	}
	
	@Bean
	public ExcelDownloadView excelView() {
		ExcelDownloadView excelView = new ExcelDownloadView();
		
		return excelView;
	}
	
	@Bean
	public DownloadView downloadView() {
		DownloadView downloadView = new DownloadView();
		
		return downloadView;
	}
	
	
	
//	<bean class="org.springframework.web.servlet.view.BeanNameViewResolver">
//		<property name="order" value="1"/>
//	</bean>	
	
	@Bean
	public BeanNameViewResolver beanNameViewResolver() {
		BeanNameViewResolver beanNameViewResolver = new BeanNameViewResolver();
		beanNameViewResolver.setOrder(1);
		
		return beanNameViewResolver;
	}
	
	
	
//	<bean id="tilesConfigurer" class="org.springframework.web.servlet.view.tiles3.TilesConfigurer">
//	<property name="definitions">
//		<list>
//			<value>classpath:kr/or/ddit/config/tiles/tiles-definition.xml</value>
//		</list>
//	</property>
//	</bean>	
	
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions("classpath:kr/or/ddit/config/tiles/tiles-definition.xml");
		
		return tilesConfigurer;
	}
	
	
	
//	<bean class="org.springframework.web.servlet.view.tiles3.TilesViewResolver">
//	<property name="order" value="0"/>
//	<property name="viewClass" value="org.springframework.web.servlet.view.tiles3.TilesView"/>
//	</bean>
	
	@Bean
	public TilesViewResolver tilesViewResolver() {
		TilesViewResolver tilesViewResolver = new TilesViewResolver();
		tilesViewResolver.setOrder(0);
		tilesViewResolver.setViewClass(TilesView.class);
		
		return tilesViewResolver;
	}
	
	
	
//	<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
//	<!-- 
//		prefix : 접두어, suffix : 접미어 
//		Controller가 리턴하는 문자열에 prefix, suffix를 적용 하여 해당경로의 파일로 응답을 생성
//		
//		LoginController.getView() ==> "login/view"
//		
//			prefix			  viewName		suffix
//		"/WEB-INF/views/" + "login/view" + ".jsp" 
//		
//		"/WEB-INF/views/login/view.jsp"
//	-->
//	
//	<property name="order" value="2"/>
//	<property name="prefix" value="/WEB-INF/views/"/>
//	<property name="suffix" value=".jsp"/>
//	</bean>

	@Bean
	public InternalResourceViewResolver InternalResourceViewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setOrder(2);
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		
		return internalResourceViewResolver;
	}
	
	
	
//	<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver"/>
	@Bean
	public MultipartResolver multipartResolver() {
		MultipartResolver multipartResolver = new CommonsMultipartResolver();
		
		return multipartResolver;
	}
	
	
	
//	<bean id="localeResolver" class="org.springframework.web.servlet.i18n.SessionLocaleResolver"/>
	@Bean
	public SessionLocaleResolver localeResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		
		return localeResolver;
	}
	
	
	
	
	
//	<mvc:interceptors>
//		<mvc:interceptor>
//			<mvc:mapping path="/**"/>
//			<bean class="org.springframework.web.servlet.i18n.LocaleChangeInterceptor">
//				<property name="paramName" value="lang"/>
//			</bean>
//		</mvc:interceptor>
//	</mvc:interceptors>
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		
		registry.addInterceptor(localeChangeInterceptor).addPathPatterns("/**");
	}
	
	
	
//	<mvc:resources mapping="/resources/**" location="/WEB-INF/views/error/"/>
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/views/error/");
	}
	
	
	
}
