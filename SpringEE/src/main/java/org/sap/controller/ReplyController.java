package org.sap.controller;

import java.util.ArrayList;

import org.sap.model.ReplyVo;
import org.sap.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReplyController {
	@Autowired
	ReplyService rs;
	//댓글쓰기
	@RequestMapping(value = "/replies/new", method = RequestMethod.POST)
	public ResponseEntity<String> replywrite(@RequestBody ReplyVo reply) {
		//insert가 성공했으면 result변수에 1저장
		//insert가 실패했으면 result변수에 0저장
		System.out.println(reply);
		int result = rs.rewrite(reply);
		//result가 1이면 HttpStatus.OK
		//result가 0이면 HttpStatus.INTERNAL_SERVER_ERROR 메세지를 띄움
		return result == 1?new ResponseEntity<>("success", HttpStatus.OK)
						  :new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	//댓글목록리스트
	@RequestMapping(value = "/replies/{bno}", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<ReplyVo>> getlist(@PathVariable int bno) {
		System.out.println(bno);
		return new ResponseEntity<>(rs.list(bno), HttpStatus.OK);
						 
	}
}
