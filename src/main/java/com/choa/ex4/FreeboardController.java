package com.choa.ex4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.board.BoardDTO;
import com.choa.free.FreeDTO;
import com.choa.free.FreeServiceImpl;



@Controller
@RequestMapping(value="/free/**")
public class FreeboardController {

	@Autowired //만들어진 서비스를 주입시키기
	private FreeServiceImpl freeService;
	
	
	//List
	@RequestMapping(value="freeList" , method=RequestMethod.GET )
	public String freeList(Model model, @RequestParam(defaultValue="1") Integer curPage) throws Exception{
		
		List<BoardDTO> ar  = freeService.boardList(curPage);
		
		model.addAttribute("list", ar);
		model.addAttribute("board", "free");
		return "board/boardList";
	}
	@RequestMapping(value="freeView" , method=RequestMethod.GET )
	public void freeView(Integer num,Model model) throws Exception{
		int result = freeService.boardHit(num);
		
		if(result >0){
		BoardDTO boardDTO= freeService.boardView(num);
		model.addAttribute("dto", boardDTO);
		}

	}
	//write DB
	@RequestMapping(value="freeWrite" , method=RequestMethod.GET )
	public void freeWrite(Model model) throws Exception{
		model.addAttribute("path","Write");
	}
	@RequestMapping(value="freeWrite" , method=RequestMethod.POST )
	public String freeWrite(RedirectAttributes rd, FreeDTO freeDTO) throws Exception{
		int result= freeService.boardWrite(freeDTO);
		String message="Write FAIL";
		if(result > 0){
			message="Write SUCCESS";
		} 
		rd.addFlashAttribute("message", message);
		
		return "redirect:freeList?curPage=1";
	}
	@RequestMapping(value="freeUpdate" , method=RequestMethod.GET )
	public String freeUpdate(Integer num, Model model) throws Exception{
		
BoardDTO boardDTO= freeService.boardView(num);		
		model.addAttribute("dto",boardDTO);
		model.addAttribute("path", "Update");
		return "free/freeWrite";
	}
	@RequestMapping(value="freeUpdate" , method=RequestMethod.POST )
	public String freeUpdate(RedirectAttributes rd,FreeDTO freeDTO) throws Exception{
		
		int result  = freeService.boardUpdate(freeDTO);
		String message= "Fail Update";
		if(result > 0){
			message= "Success Update";
		}
		
		rd.addAttribute("message",message);
		
		return "redirect:freeList?curPage=1";
	}
	
	@RequestMapping(value="freeDelete" , method=RequestMethod.GET )
	public String freeDelete(RedirectAttributes rd, int num) throws Exception{
			int result = freeService.boardDelete(num);
			String message="Fail Delete";
			if(result > 0){
				message="success delete";
			}
		rd.addAttribute("message",message);
		
		return "redirect:freeList?curPage=1";
	}	
}
