package com.iu.s6;

import static org.junit.Assert.*;

import java.util.Random;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.board.notice.NoticeDTO;
import com.iu.board.notice.NoticeTestService;
import com.iu.file.FileDTO;

public class NoticeServiceTest extends AbstractTestCase {

	@Inject
	private NoticeTestService ns;
	
	@Test
	public void test() throws Exception  {


		NoticeDTO noticeDTO = new NoticeDTO();
		FileDTO fileDTO = new FileDTO();
		
		noticeDTO.setNum(42);
		noticeDTO.setTitle("T");
		noticeDTO.setWriter("T");
		noticeDTO.setContents("T");
		
		fileDTO.setNum(40);
		fileDTO.setFname(null);
		fileDTO.setOname("T");
		fileDTO.setKind("n");
		
		ns.insert(noticeDTO, fileDTO);
		
	}

}
