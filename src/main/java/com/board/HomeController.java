package com.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @Autowired
    BoardService boardService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("list",boardService.getBoardList());
        return "list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String boardList(Model model){
        model.addAttribute("list",boardService.getBoardList());
        return "list";
    }
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String addPost(){
        return "addpostform";
    }
    @RequestMapping(value = "/addok", method = RequestMethod.POST)
    public String addPostOK(BoardVO vo){
        boardService.insertBoard(vo);
        return "redirect:list";
    }
    @RequestMapping(value = "/editform/{id}",method = RequestMethod.GET)
    public String editPost(@PathVariable("id") int id, Model model){
        BoardVO boardVO = boardService.getBoard(id);
        model.addAttribute("u",boardVO);
        return "editform";
    }
    @RequestMapping(value = "/editok", method = RequestMethod.POST)
    public String editPostOk(BoardVO vo){
        boardService.updateBoard(vo);
        return "redirect:list";
    }
    @RequestMapping(value = "/deleteok/{id}",method = RequestMethod.GET)
    public String deletePostOk(@PathVariable("id") int id){
        boardService.deleteBoard(id);
        return "redirect:../list";
    }

}