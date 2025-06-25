package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVO;

@Controller
public class GuestbookController {

	//필드
	@Autowired
    private GuestbookService guestbookService;
	
	//생성자
	
	//메소드gs
	
	//메소드일반
	//-방명록 전체 리스트 가져오기
	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("GuestbookController.list()");
		
		//service		
		//guestbookService 메모리에 올려주세요
		//"glist" 이름으로 0x333(guestbookList) 을 넣어줘
		//GuestbookService guestbookService = new GuestbookService();
		
		List<GuestbookVO> guestbookList = guestbookService.exeGetGuestbookList();
		
		//*Model개념
		//D.S 야!!!!! 
		//request의 어트리뷰트영역에 
		//"gList" 이름으로 0x333(guestbookList) 을 넣어줘
		model.addAttribute("gList", guestbookList);
		
		//*View개념
		//D.S 야!!!!! 
		// "/WEB-INF/views/addlist.jsp" 에 포워드해
		return "addlist";
		
	}
	
	
	//-방명록 글 저장
	@RequestMapping(value="add", method= {RequestMethod.GET, RequestMethod.POST})
	public String add(@ModelAttribute GuestbookVO guestbookVO) {
		           //D.S야!!!! request의 파라미터값을 꺼내서
		           //GuestbookVO로 묶어줘
		System.out.println("GuestbookController.add()");	
		
		/*D.S가 하는일
		1)파라미터의 값을 꺼낸다
	    name=aaa                setName()
		password=123            setPasswor()
		content=abcdefg         setContent()

		2)GuestbookVO 메모리에 올린다(기본생성자 사용!!!)
	    GuestbookVO guestbookVO = new GuestbookVO();
	
		3)Setter로 값을 넣는다
	    name=aaa   --->     setName(aaa)
	    password=123 --->   setPassword(123)
	    content=abcdefg --> setContent(abcdefg)
	
	    
	    4)D.S는 add(guestbookVO)실행한다 
		
		
		*url 파라미터이름 과 VO의 필드 이름을 같게 만든다
		*/
		////////////////////////////////////////////////////
		
		//GuestbookService guestbookService = new GuestbookService();
		guestbookService.exeGuestbookAdd(guestbookVO);
		
		
		//리다이렉트 하는법 "redirect:" 앞쪽에 써준다
		//http://localhost:8888/guestbook4/list
		return "redirect:/list";
	}
	
	/*
	@RequestMapping(value="add", method= {RequestMethod.GET, RequestMethod.POST})
	public String add(@RequestParam(value="name") String name, 
			          @RequestParam(value="password") String pw, 
			          @RequestParam(value="content") String content) {         
		//D.S야!!!! request의 파라미터 영역의 name 인 값을 꺼내줘
		
		System.out.println("GuestbookController.add()");
		
		GuestbookVO guestbookVO = new GuestbookVO();
		guestbookVO.setName(name);
		guestbookVO.setPassword(pw);
		guestbookVO.setContent(content);
		
		System.out.println(guestbookVO);
		
		return "";
	}
	*/
	
	//삭제폼(삭제랑 헷갈리지 말자)  폼만 보여주면 됨
	@RequestMapping(value="rform", method = {RequestMethod.GET, RequestMethod.POST})
	public String removeForm() {
		System.out.println("GuestbookController.removeForm()");
		
		return "removeform";
	}
	
	//삭제
	@RequestMapping(value="/remove", method= {RequestMethod.GET, RequestMethod.POST})
	public String remove(@ModelAttribute GuestbookVO guestbooVO) {
		System.out.println("GuestbookController.remove()");
		
		//GuestbookService guestbookService = new GuestbookService();
		guestbookService.exeGuestbookRemove(guestbooVO);
		

		return "redirect:/list";
	}
	
	
}