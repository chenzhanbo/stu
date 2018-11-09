package cn.tedu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
//消费者
@RestController
public class HelloController {
	//依赖注入模板用来远程访问
	@Autowired
	private RestTemplate restTemplate; 
	
	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable String name){
		String url="http://provider-user/hello/"+name;//支持通用访问
		return restTemplate.getForObject(url, String.class);
	}
}
