package com.iu.s6;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.board.BoardDTO;
import com.iu.board.notice.NoticeDAO;
import com.iu.file.FileDTO;

public class NoticeTest extends AbstractTestCase {
	@Inject
	private NoticeDAO noticeDAO;
	
	@Test
	public void test() throws Exception{
		BoardDTO boardDTO = noticeDAO.select(22);
		System.out.println("======================");
		System.out.println(boardDTO.getNum());
		System.out.println(boardDTO.getTitle());
		
		for(FileDTO fileDTO:boardDTO.getFiles()) {
			System.out.println(fileDTO.getFname());
		}		
		System.out.println("======================");
	}

}
