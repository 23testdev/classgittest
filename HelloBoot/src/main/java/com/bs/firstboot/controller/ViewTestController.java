package com.bs.firstboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bs.firstboot.model.dto.Member;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ViewTestController {
	
	@Value("${linux.home}")
	private String homeDir;
	@Value("${linux.url}")
	private String url;
	
	//@Value("${window.javahome}")
	private String path;
	
	 
	@GetMapping("/valuetest")
	@ResponseBody
	public List<String> ymlData(){
		log.debug(homeDir);
		log.debug(url);
		log.debug(path);
		return List.of(homeDir,url,path);
	}
	
	@PostMapping("/fileupload")
	public String uploadfile(MultipartFile[] upFile){
		for(MultipartFile f : upFile) {
		log.debug(f.getOriginalFilename());
		log.debug("크기:  {}",f.getSize());
		}
		return "redircet:/";
	}
	
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("name", "bsLove23");

		Member m=Member.builder()
				.name("홍정재")
				.age(21)
				.address("경상남도 창원시")
				.gender("M").build();
		List<String> team=List.of("김태하","서진","김선진","오지영","박대웅");
		model.addAttribute("team", team);
		model.addAttribute("member",m);
		
		return "index";
	}
	
	@GetMapping("/test")
	public String test() {
		return "user/test";
	}
//	
//	@GetMapping("/board/boardlist")
//	public String boardmain() {
//		return "board/boardlist";
//	}
}
