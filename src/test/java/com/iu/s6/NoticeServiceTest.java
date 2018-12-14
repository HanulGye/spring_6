package com.iu.s6;

import static org.junit.Assert.*;

import java.util.Random;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.board.notice.NoticeDTO;
import com.iu.board.notice.NoticeTestService;
import com.iu.file.FileDTO;

public class NoticeServiceTest extends AbstractTestCase{

	@Inject
	private NoticeTestService ns;
	
	@Test
	public void noticeServiceTest() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		FileDTO fileDTO = new FileDTO();
		
		
		
		noticeDTO.setNum(32);
		noticeDTO.setTitle("testt");
		noticeDTO.setWriter("testw");
		noticeDTO.setContents("testc");
		
		fileDTO.setNum(32);
		fileDTO.setOname("dfdf");
		fileDTO.setFname("dfdf");
		fileDTO.setKind("n");
		
		ns.insert(noticeDTO, fileDTO);
		
	}

}
